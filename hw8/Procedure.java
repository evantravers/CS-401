// Procedure.java

// Procedure is a class to represent the components of a procedure.

class Procedure {

  private Environment env;
  private SyntaxTree syntaxTree;

  public Procedure (Environment env, SyntaxTree syntaxTree)
  {
    this . env         = env;
    this . syntaxTree  = syntaxTree;
  }

  public Environment env () { return env; }

  public SyntaxTree syntaxTree () { return syntaxTree; }

  public void print (String procedureName) {
    syntaxTree . print (procedureName);
    env . print (procedureName);
  }

}
