class Type {

  public static final int INTEGER = 0;
  public static final int LIST    = 1;
  public static final int BOOLEAN = 2;
  public static final int VOID    = 3;

  private int type;

  public Type (int type) {
    this . type = type;
  }

  public int type () { return type; }

  public String toString () {
    switch (type) {
      case INTEGER : return "int ";
      case LIST    : return "list";
      case BOOLEAN : return "bool";
      case VOID    : return "void";
      default      : return null;
    }
  }  

}
