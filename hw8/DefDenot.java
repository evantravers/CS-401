// FuncDenot is a class to represent the components of a MicroScala function.

import java.util.*;

public class DefDenot extends DenotableValue {

  private ArrayList <String> parameterList;
  private SyntaxTree syntaxTree;
  private Type type;
  private VariableEnvironment env;

  public DefDenot (ArrayList <String> funcParameters, Type funcType, 
      Environment localEnv, SyntaxTree funcSyntaxTree) {
    parameterList = funcParameters;
    type = funcType;
    env = localEnv;
    syntaxTree  = funcSyntaxTree;
  }

  public ArrayList <String>  parameterList () { return parameterList; }
  public Type                type ()          { return type; }
  public Environment 		 environment ()   { return env; }
  public SyntaxTree          syntaxTree ()    { return syntaxTree; }

  public void print (String functionName) {
    syntaxTree . print (functionName);
    env . print ();
  }

}
