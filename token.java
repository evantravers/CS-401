// etravers@uab.edu
// token class for microscala

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
		case OBJECT :   	return "(keyword, object) ";
		case DEF :      	return "(keyword, def) ";
		case MAIN :     	return "(keyword, main)";
		case ARGS :			return "(keyword, args)";
		
		case ASSIGN :   	return "(operator, :=) ";
		case LT :       	return "(operator, <) ";
		case COMMA :    	return "(punctuation, ,) ";
		case PERIOD :   	return "(punctuation, .) ";
		case SEMICOLON :	return "(punctuation, ;) ";
		case ID :       	return "(identifier, " + lexeme + ") ";
		case INTEGER :  	return "(integer, " + lexeme + ") ";
default : 
	ErrorMessage . print (0, "Unrecognized token");
        return null;
    }
  }

}