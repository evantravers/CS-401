// Assign6 class 
// This class is a MicroScala parser which reads a MicroScala source 
// program and outputs the set of syntax trees comprising that program's 
// executable functions and the symbol tables for those functions. 

public class Assign6 {

  public static void main (String args []) throws java.io.IOException {

    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    ParserWithSymbolTable parser = new ParserWithSymbolTable ();
    Environment env = parser . program ();
    env.print("main");
  }

}
