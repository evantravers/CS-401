// etravers@uab.edu
// SyntaxTree.java

// SyntaxTree is a class to represent a node of a ternary syntax tree.

class SyntaxTree {

  private Object node;
  private SyntaxTree left;
  private SyntaxTree middle;
  private SyntaxTree right;

  // constructor functions

  public SyntaxTree () { 
    this (null, null, null, null);
  }

  public SyntaxTree (Object nodeValue) {
    this (nodeValue, null, null, null);
  }

  public SyntaxTree (Object nodeValue, SyntaxTree leftTree) {
    this (nodeValue, leftTree, null, null);
  }

  public SyntaxTree (Object nodeValue, SyntaxTree leftTree, 
      SyntaxTree middleTree) {
    this (nodeValue, leftTree, middleTree, null);
  }

  public SyntaxTree (Object nodeValue, SyntaxTree leftTree, 
      SyntaxTree middleTree, SyntaxTree rightTree) {
    node   = nodeValue;
    left   = leftTree;
    middle = middleTree;
    right  = rightTree;
  }

  // public int constValue()
  // {
  //    return (Integer)left().root().intValue();
  // }
  
  public Location varLoc()
  {
  	return (Location)left().left().root();
  }
  
  public SyntaxTree procBody()
  {
  	return left().left().left();
  }

  // selector functions

  public Object root ()       { return node; }
  public SyntaxTree left ()   { return left; }
  public SyntaxTree middle () { return middle; }
  public SyntaxTree right ()  { return right; }

  // print prints the tree in Cambridge Polish prefix notation with a heading.

  public void print (String block_name) {
    System . out . println ();
    System . out . println ();
    System . out . println ("Syntax Tree for " + block_name);
    System . out . print ("----------------");
    for (int i = 0; i < block_name . length (); i++)
      System . out . print ("-");
    System . out . println ();
    System . out . print (this);
  }

  // toString returns the tree in Cambridge Polish prefix notation.

  public String toString () {
    if (left == null) 
      return node.toString();
    else if (middle == null)
      return "(" + node + " " + left + ")";
    else if (right == null)
      return "(" + node + " " + left + " " + middle + ")";
    else
      return "(" + node + " " + left + " " + middle + " " + right + ")";
  }

}
