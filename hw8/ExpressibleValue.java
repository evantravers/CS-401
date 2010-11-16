// ExpressibleValue is a class to represent the values of expressions in
// a MicroScala program.

class ExpressibleValue extends DenotableValue {

  private Type evtype;
  private Value evvalue;

  public ExpressibleValue (Type type, Value value) {
    evtype  = type;
    evvalue = value;
  }

  public Type type () { return evtype; }

  public Value value () { return evvalue; }

  public String toString () { 
    return evtype + "  " + evvalue; 
  }

}
