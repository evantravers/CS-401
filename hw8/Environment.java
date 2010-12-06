// Environment.java

// Environment is a class to represent the environment for MicroScala programs.

import java.util.*;

public class Environment {

  private Environment parent;
  private Location location;
  private TreeMap map;
  private int maxIdLength = 2; // for heading "Id"

  public Environment () {
    location = new Location ();
    map = new TreeMap ();
  }

  public Environment (Environment staticParent) {
    location = staticParent . location . nextStackFrame ();
    map      = new TreeMap ();
    parent   = staticParent;
  }

  public Location location () { return location; }

  public TreeMap map () { return map; }

  public Location newLocation () { return location . nextLocation (); }

  public Environment newBlock () { 
    return new Environment (this);
  }

  public DenotableValue accessEnv (String id) {
    DenotableValue denotVal = (DenotableValue) map . get (id);
    if (denotVal == null)
      if (parent == null) {
        ErrorMessage . print ("Identifier " + id + " undeclared");
        return null; // will not happen since ErrorMessage . print exits
      }
      else
        return parent . accessEnv (id);
    else
      return denotVal;
  }

  public void updateEnvConst (String id, Integer constValue) {
    updateEnv (id, new DenotableValue (Category . CONSTANT, constValue));
  }

  public void updateEnvVar (String id) {
    updateEnv (id, new DenotableValue (Category . INT, newLocation ()));
  }
  
  public void updateEnvList (String id) {
      updateEnv (id, new DenotableValue (Category . LIST, newLocation ()));
  }

  public void updateEnvProc (String id) { // denotable value filled in later
    updateEnv (id, new DenotableValue (Category . DEF, null));
  }

  public void updateEnvProc (String id, SyntaxTree syntaxTree, Environment env) {
    updateEnv (id, 
      new DenotableValue (Category . DEF, new Procedure (env, syntaxTree)));
  }

  public void updateEnv (String id, DenotableValue denotableValue) {
    DenotableValue denotVal = (DenotableValue) map . get (id);
    if (denotVal != null && denotVal . value () != null)
      ErrorMessage . print ("Identifier " + id + " previously declared");
    if (id . length () > maxIdLength)
      maxIdLength = id . length ();
    map . put (id, denotableValue);
  }

  public void print (String blockName) {
    System . out . println ("");
    System . out . println ("Identifier Table for " + blockName);
    System . out . print ("---------------------");
    for (int i = 0; i < blockName . length (); i++) 
      System . out . print ("-");
    System . out . println ("");
    System . out . println ("");
    System . out . print ("Id");
    for (int i = 0; i <= maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . println ("Category");
    System . out . print ("--");
    for (int i = 0; i <= maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . println ("--------");
    Iterator envIterator = map . entrySet () . iterator ();
    TreeMap procedureList = new TreeMap ();
    while (envIterator . hasNext ()) {
      Map . Entry envEntry = (Map . Entry) envIterator . next ();
      String entryId = (String) envEntry . getKey ();
      System . out . print (entryId);
      for (int i = 0; i <= maxIdLength - entryId . length (); i++)
        System . out . print (" ");
      DenotableValue entryDenotVal = (DenotableValue) envEntry . getValue ();
      System . out . println (entryDenotVal);
      if (entryDenotVal . category () == Category . DEF)
	procedureList . put (entryId, entryDenotVal . value ());
    }
    Iterator procIterator = procedureList . entrySet () . iterator ();
    while (procIterator . hasNext ()) {
      Map . Entry procEntry = (Map . Entry) procIterator . next ();
      String procId = (String) procEntry . getKey ();
      ((Procedure) procEntry . getValue ()) . print (procId);
    }
  }

}
