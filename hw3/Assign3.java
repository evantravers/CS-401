// etravers@uab.edu
// Assign3 class 
// This class is a MicroScala parser which reads a MicroScala source 
// program and outputs the set of syntax trees comprising that program's 
// executable functions. 
import java.io.*;

public class Assign3 {

  public static void main (String args []) throws java.io.IOException {

    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    Parser parser = new Parser ();
    parser . CompilationUnit ();

  }

}
