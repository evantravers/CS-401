// TokenClass enumeration definition
// TokenClass is an enumeration to represent lexical token classes in the 
// MicroScala programming language.

public enum TokenClass {
  EOF, 
  // keywords
  ARGS, ARRAY, DEF, ELSE, IF, INT, LIST, MAIN, NIL, OBJECT, PRINTLN, RETURN, 
  STRING, VAR, WHILE,
  // punctuation
  COMMA, PERIOD, SEMICOLON, COLON, LEFTBRACE, RIGHTBRACE, 
  LEFTBRACKET, RIGHTBRACKET,
  // operators
  LEFTPAREN, RIGHTPAREN, ASSIGN, OR, AND, NOT, CONS, RELOP, ADDOP, MULTOP, 
  LISTOP,
  // ids and integers
  ID, INTEGER
}
