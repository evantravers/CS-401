// VariableEnvironment is a class to represent the environment for variables
// in MicroScala functions.

import java.util.*;

public class VariableEnvironment extends Environment {

  public VariableEnvironment (String functionName) {
    blockName = functionName;
  }

  public void print () {
    super . print ();
    System . out . print ("Id");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . println ("Type");
    System . out . print ("--");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . println ("----");
    Iterator envIterator = idMap . entrySet () . iterator ();
    while (envIterator . hasNext ()) {
      Map . Entry envEntry = (Map . Entry) envIterator . next ();
      String entryId = (String) envEntry . getKey ();
      System . out . print (entryId);
      for (int i = 0; i <= maxIdLength - entryId . length (); i++)
        System . out . print (" ");
      System . out . print (" ");
      Type variableType = ((ExpressibleValue) envEntry . getValue ()) . type ();
      System . out . println (variableType);
    }
    System . out . println ();
  }

}
