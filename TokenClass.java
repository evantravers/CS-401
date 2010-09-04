// TokenClass enumeration definition
// TokenClass is an enumeration to represent lexical token classes in the 
// MicroScala programming language.

public enum TokenClass {
	// TODO Change all of these
	// keywords
	OBJECT, DEF, MAIN, ARGS, ARRAY, STRING, VAR, IF, ELSE, WHILE, PRINT
	// operators
	,PLUS, MINUS, TIMES, SLASH, LPAREN, RPAREN, LBRAC, RBRAC, EQ, LT, GT, NE, LE, GE
	// punctuation
	,COMMA, PERIOD, COLON, SEMICOLON
	// integer
	,LITERAL
}