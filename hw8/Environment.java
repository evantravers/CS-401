// Environment is a class to represent the environment for MicroScala
// programs.

import java.util.*;

public class Environment {

  protected String blockName;
  protected TreeMap idMap;
  protected int maxIdLength = 3; // for "run"

  public Environment () {
    idMap = new TreeMap ();
  }

  public TreeMap idMap () { return idMap; }

  public DenotableValue access (String id) {
    return (DenotableValue) idMap . get (id);
  }

  public void update (String id, DenotableValue denotVal) {
    DenotableValue currentDenotVal = (DenotableValue) idMap . get (id);
    if (currentDenotVal != null)
      ErrorMessage . print ("Identifier " + id + " previously declared");
    if (id . length () > maxIdLength)
      maxIdLength = id . length ();
    idMap . put (id, denotVal);
  }

  public void print () {
    System . out . println ();
    System . out . println ("Identifier Table for " + blockName);
    System . out . print ("---------------------");
    for (int i = 0; i < blockName . length (); i++) 
      System . out . print ("-");
    System . out . println ();
    System . out . println ();
  }

}
