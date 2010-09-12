// Token class definition
// Token is a class to represent lexical tokens in the MicroScala programming 
// language.

public class Token {

  private TokenClass symbol;	// current token
  private String lexeme;	// lexeme

  public Token () { }

  public Token (TokenClass symbol) {
    this (symbol, null);
  }

  public Token (TokenClass symbol, String lexeme) {
    this . symbol = symbol;
    this . lexeme  = lexeme;
  }

  public TokenClass symbol () { return symbol; }

  public String lexeme () { return lexeme; }

  public String toString () {
    switch (symbol) {
      case ARGS :         return "(keyword, args) ";
      case ARRAY :        return "(keyword, Array) ";
      case DEF :          return "(keyword, def) ";
      case ELSE :         return "(keyword, else) ";
      case IF :           return "(keyword, if) ";
      case INT :          return "(keyword, Int) ";
      case LIST :         return "(keyword, List) ";
      case MAIN :         return "(keyword, main) ";
      case NIL :          return "(keyword, Nil) ";
      case OBJECT :       return "(keyword, object) ";
      case PRINTLN :      return "(keyword, println) ";
      case RETURN :       return "(keyword, return) ";
      case STRING :       return "(keyword, String) ";
      case VAR :          return "(keyword, var) ";
      case WHILE :        return "(keyword, while) ";
      case ASSIGN :       return "(operator, =) ";
      case AND :          return "(operator, &&) ";
      case CONS :         return "(operator, ::) ";
      case NOT :          return "(operator, !) ";
      case OR :           return "(operator, ||) ";
      case ADDOP :        return "(operator, " + lexeme + ") ";
      case MULTOP :       return "(operator, " + lexeme + ") ";
      case RELOP :        return "(operator, " + lexeme + ") ";
      case LISTOP :       return "(operator, " + lexeme + ") ";
      case LEFTPAREN :    return "(operator, () ";
      case RIGHTPAREN :   return "(operator, )) ";
      case LEFTBRACE :    return "(operator, {) ";
      case RIGHTBRACE :   return "(operator, }) ";
      case LEFTBRACKET :  return "(operator, [) ";
      case RIGHTBRACKET : return "(operator, ]) ";
      case COMMA :        return "(punctuation, ,) ";
      case PERIOD :       return "(punctuation, .) ";
      case SEMICOLON :    return "(punctuation, ;) ";
      case COLON :        return "(punctuation, :) ";
      case ID :           return "(identifier, " + lexeme + ") ";
      case INTEGER :      return "(integer, " + lexeme + ") ";
      default :           ErrorMessage . print (0, "Unrecognized token");
                          return null;
    }
  }

}
