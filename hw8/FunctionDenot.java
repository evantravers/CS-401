import java.util.*;

class FunctionDenot extends DenotableValue {

  private ArrayList <String> parameter;
  private Environment env;
  private SyntaxTree syntaxTree;

  public FunctionDenot (ArrayList <String> funcParameter, Type funcType,
      Environment funcEnv, SyntaxTree funcSyntaxTree) {
    parameter = funcParameter;
    type = funcType;
    env = funcEnv;
    syntaxTree  = funcSyntaxTree;
  }

  public ArrayList<String> parameterList () { return parameter; }
  public Environment environment () { return env; }
  public SyntaxTree functionBody () { return syntaxTree; }
  public Type type() { return type; }

  public void print (String functionName) {
    syntaxTree . print (functionName);
    env . print (functionName);
  }

}
