class ExpressibleValue extends DenotableValue {

  private Object value; // used as parent class of Integer and ArrayList

  public ExpressibleValue (Type type, Object value) {
    this . type  = type;
    this . value = value;
  }

  public Object value () { return value; }

  public String toString () { return type + "  " + value; }

}
