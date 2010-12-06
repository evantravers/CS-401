public class Category
{
  public static final int CONSTANT = 0;
  public static final int INT = 1;
  public static final int LIST = 2;
  public static final int DEF = 3;

  public static String toString(int paramInt)
  {
    switch (paramInt) { case 0:
      return "constant ";
    case 1:
      return "int ";
    case 2:
      return "list ";
    case 3:
      return "def "; }
    return null;
  }
}

