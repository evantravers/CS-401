// DenotableValue.java

// DenotableValue is a class to represent the denotable values of identifiers
// in a Micro Scala program.

public class DenotableValue {

  private int category;
  private Object value;

  public DenotableValue (int category, Object value) {
    this.category = category;
    this.value = value;
  }

  public int category () {
      return category;
  }

  public Object value () {
      return value;
  }

  public String toString () {
    String printString = Category . toString (category);
    if (category == Category . CONSTANT || category == Category . VARIABLE) {
        printString = printString + "(" + value + ")";
    }
    return printString;
  }

}
