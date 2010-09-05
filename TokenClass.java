// TokenClass enumeration definition
// TokenClass is an enumeration to represent lexical token classes in the 
// MicroScala programming language.

public enum TokenClass {
	// CHANGED Change all of these
	// keywords
	EOF, OBJECT, DEF, MAIN, ARGS, ARRAY, STRING, VAR, IF, ELSE, WHILE, PRINT, RETURN, INT, LIST, NOT, HEAD, TAIL, ISEMPTY
	// operators
	,DOT ,PLUS, MINUS, TIMES, SLASH, LPAREN, RPAREN, LBRAC, RBRAC, LCURL, RCURL, EQ, LT, GT, NE, LE, GE
	// punctuation
	,COMMA, PERIOD, COLON, SEMICOLON
	// integer
	,LITERAL, NIL, IDENTIFIER
}