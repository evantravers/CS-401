// Environment is a class to represent the environment for MicroScala
// programs.

import java.util.*;

public class CompEnvironment extends Environment {

  public CompEnvironment (String componentName) {
    blockName = componentName;
  }

  public void print () {
    super . print ();
    System . out . print ("Id");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . print ("Type");
    System . out . print ("     ");
    System . out . println ("Code");
    System . out . print ("--");
    for (int i = 0; i < maxIdLength - 2; i++)
      System . out . print (" ");
    System . out . print ("  ");
    System . out . print ("----");
    System . out . print ("     ");
    System . out . println ("----");
    Iterator envIterator = idMap . entrySet () . iterator ();
    TreeMap functionList = new TreeMap ();
    while (envIterator . hasNext ()) {
      Map . Entry envEntry = (Map . Entry) envIterator . next ();
      String entryId = (String) envEntry . getKey ();
      System . out . print (entryId);
      for (int i = 0; i <= maxIdLength - entryId . length (); i++)
        System . out . print (" ");
      System . out . print (" ");
      DefDenot defDenot =  (DefDenot) envEntry . getValue ();
      Type defType = defDenot . type ();
      System . out . print (defType);
      System . out . print ("  ");
      SyntaxTree syntaxTree = defDenot . syntaxTree ();
      System . out . println (syntaxTree);
      VariableEnvironment variableEnvironment = defDenot . environment ();
      variableEnvironment . print ();
    }
  }

}
