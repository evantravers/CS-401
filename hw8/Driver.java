// This program is an interpreter for MicroScala. At the conclusion of interpreting
// a program, the program's memory store is output.

public class Driver {

  public static void main (String args []) throws java.io.IOException {
    System.out.println ("Source Program");
    System.out.println ("--------------");
    System.out.println ("");

    Parser2 scala = new Parser2();
    Environment env = new Environment();
    SyntaxTree syntaxTree = scala.CompilationUnit(env);
    syntaxTree.print ("main");
    // env.print ("MAIN");
    Interpreter interpreter = 
      new Interpreter (Location.stackFrameSize(), Location.mainProgSize());
    interpreter.C(syntaxTree);
    System.out.println ("");
    System.out.println (interpreter.store());
  }
}
