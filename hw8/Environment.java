import java.util.*;

class Environment {

  private TreeMap <String, DenotableValue> map;
  private int maxIdLength = 2; // for heading "Id"

  public Environment () {
    map = new TreeMap <String, DenotableValue> ();
  }
  
  public Environment (Environment env) {
      map = env.map();
  }

  public TreeMap <String, DenotableValue> map () { return map; }

  public DenotableValue access (String id) {
    return map . get (id);
  }

  public void update (String id, DenotableValue denotVal) {
    DenotableValue currentDenotVal = map . get (id);
    if (currentDenotVal != null)
      ErrorMessage . print ("Identifier " + id + " previously declared");
    if (id . length () > maxIdLength)
      maxIdLength = id . length ();
    map . put (id, denotVal);
  }
  
  public void updateVal (String id, DenotableValue denotVal) {
      DenotableValue currentDenotVal = map . get (id);
      // if (currentDenotVal == null)
      //           ErrorMessage . print ("Identifier " + id + " does not exist");
      if (id . length () > maxIdLength)
          maxIdLength = id . length ();
      map . put (id, denotVal);
  }

  public void print (String blockName) {
    System . out . println ();
    System . out . println ();
    System . out . println ("Identifier Table for " + blockName);
    System . out . print ("---------------------");
    for (int i = 0; i < blockName . length (); i++) 
      System . out . print ("-");
    System . out . println ();
    System . out . println ();
    System . out . print ("Id");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . print ("Category");
    System . out . print ("  ");
    System . out . print ("Type");
    System . out . print ("  ");
    System . out . println ("Value");
    System . out . print ("--");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . print ("--------");
    System . out . print ("  ");
    System . out . print ("----");
    System . out . print ("  ");
    System . out . println ("-----");
    Iterator <Map . Entry <String, DenotableValue>> envIterator = 
      map . entrySet () . iterator ();
    TreeMap <String, FunctionDenot> functionList = 
      new TreeMap <String, FunctionDenot> ();
    while (envIterator . hasNext ()) {
      Map . Entry <String, DenotableValue> envEntry = envIterator . next ();
      String entryId = envEntry . getKey ();
      System . out . print (entryId);
      for (int i = 0; i <= maxIdLength - entryId . length (); i++)
        System . out . print (" ");
      System . out . print (" ");
      DenotableValue entryDenotVal = envEntry . getValue ();
      if (entryDenotVal instanceof ExpressibleValue) { // variable
        System . out . print ("variable");
        System . out . print ("  ");
        System . out . println (entryDenotVal);
      }
      else { // function
        System . out . print ("function");
        System . out . print ("  ");
        System . out . println (entryDenotVal . type ());
	functionList . put (entryId, (FunctionDenot) entryDenotVal);
      }
    }
    Iterator <Map . Entry <String, FunctionDenot>> funcIterator = 
      functionList . entrySet () . iterator ();
    while (funcIterator . hasNext ()) {
      Map . Entry <String, FunctionDenot> funcEntry = funcIterator . next ();
      String funcId = funcEntry . getKey ();
      funcEntry . getValue () . print (funcId);
    }
  }
  
  public void store (String blockName) {
      System . out . println ();
      System . out . println ();
      System . out . println ("Identifier Table for " + blockName);
      System . out . print ("---------------------");
      for (int i = 0; i < blockName . length (); i++) 
        System . out . print ("-");
      System . out . println ();
      System . out . println ();
      System . out . print ("Id");
      for (int i = 0; i < maxIdLength - 2; i++)
        System . out . print (" ");
      System . out . print ("  ");
      System . out . print ("Category");
      System . out . print ("  ");
      System . out . print ("Type");
      System . out . print ("  ");
      System . out . println ("Value");
      System . out . print ("--");
      for (int i = 0; i < maxIdLength - 2; i++)
        System . out . print (" ");
      System . out . print ("  ");
      System . out . print ("--------");
      System . out . print ("  ");
      System . out . print ("----");
      System . out . print ("  ");
      System . out . println ("-----");
      Iterator <Map . Entry <String, DenotableValue>> envIterator = 
        map . entrySet () . iterator ();
      TreeMap <String, FunctionDenot> functionList = 
        new TreeMap <String, FunctionDenot> ();
      while (envIterator . hasNext ()) {
        Map . Entry <String, DenotableValue> envEntry = envIterator . next ();
        String entryId = envEntry . getKey ();
        System . out . print (entryId);
        for (int i = 0; i <= maxIdLength - entryId . length (); i++)
          System . out . print (" ");
        System . out . print (" ");
        DenotableValue entryDenotVal = envEntry . getValue ();
        if (entryDenotVal instanceof ExpressibleValue) { // variable
          System . out . print ("variable");
          System . out . print ("  ");
          System . out . println (entryDenotVal);
        }
        else { // function
          System . out . print ("function");
          System . out . print ("  ");
          System . out . println (entryDenotVal . type ());
  	functionList . put (entryId, (FunctionDenot) entryDenotVal);
        }
      }
    }

}
