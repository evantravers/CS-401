import java.util.*;

// DenotableValue is a class to represent the denotable values of identifiers
// a MicroScala program. A denotable value is either an expressible value or a 
// function denotation.

class DenotableValue {

  protected Type type;

  public Type type () { return type; }

  public String toString () {
    return type . toString ();
  }

}
