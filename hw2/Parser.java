// Parser is a class to represent a recursive descent parser for the 
// MicroScala programming language.	The parser also constructs a 
// syntax tree representation of all executable constructions.

import java.util.*;

public class Parser {

	protected MicroScalaLexer lexer;	// lexical analyzer
	protected Token token;					 // current token

	public Parser () throws java.io.IOException {
		lexer = new MicroScalaLexer (System . in);
		getToken ();
	}

	protected void getToken () throws java.io.IOException {
		token = lexer . nextToken ();
	}

	// compilationUnit parses MicroScala programs.
	public void CompilationUnit () throws java.io.IOException {
		// object
		if (token.symbol()!=TokenClass.OBJECT) {
			ErrorMessage.print("object expected");
		}
		getToken();
		
		// id
		if (token.symbol()!=TokenClass.ID) {
			ErrorMessage.print("id expected");
		}
		getToken();
		
		// {
		if (token.symbol()!=TokenClass.LEFTBRACE) {
			ErrorMessage.print("Left Brace expected");
		}
		getToken();
		
		// one or more defs
		while (token.symbol()==TokenClass.DEF||token.symbol()==TokenClass.VAR) {
			Def();
		}
		getToken();
		
		// }
		if (token.symbol()!=TokenClass.RIGHTBRACE) {
			ErrorMessage.print("Right BRACE Expected");
		}
		getToken();
				
		if (token.symbol()!=TokenClass.EOF) {
			ErrorMessage.print("EOF expected");			
		}
	}
	
	// Def
	public void Def() throws java.io.IOException {
		if (token.symbol()==TokenClass.VAR) {
			// this is a vardef			
			VarDef();
		}
		
		if (token.symbol()==TokenClass.DEF) {
			getToken();
			if (token.symbol()==TokenClass.MAIN) {
				// this is a main
				// TODO add this main def
			}
			if (token.symbol()==TokenClass.ID) {
				// normal def
				getToken();
				
				if (token.symbol()!=TokenClass.LEFTPAREN) {
					ErrorMessage.print("( expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.ID) {
					ErrorMessage.print("ID expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected");
				}
				getToken();
				
				Type();
				
				if (token.symbol()!=TokenClass.COMMA) {
					ErrorMessage.print(", expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.ID) {
					ErrorMessage.print("ID expected");
				}
				getToken();

				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected");
				}
				getToken();

				Type();
				
				if (token.symbol()!=TokenClass.RIGHTPAREN) {
					ErrorMessage.print(") expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected");
				}
				getToken();
				
				Type();
				
				if (token.symbol()!=TokenClass.ASSIGN) {
					ErrorMessage.print("= expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.LEFTBRACE) {
					ErrorMessage.print("{ expected");
				}
				getToken();
				
				while (token.symbol()==TokenClass.VAR) {
					VarDef();
				}
				
				Statement();
				
				if (token.symbol()!=TokenClass.RETURN) {
					ErrorMessage.print("return expected");
				}
				getToken();
				
				ListExpr();
				
				if (token.symbol()!=TokenClass.SEMICOLON) {
					ErrorMessage.print("; expected");
				}
				getToken();
				
				if (token.symbol()!=TokenClass.RIGHTBRACE) {
					ErrorMessage.print("} expected");
				}
				getToken();
			}
		}
		
	}
	
	public void VarDef() throws java.io.IOException {
		if (token.symbol()!=TokenClass.ID) {
			ErrorMessage.print("ID expected");
		}
		getToken();
		
		if (token.symbol()!=TokenClass.COLON) {
			ErrorMessage.print(": expected");
		}
		getToken();
		
		Type();

		if (token.symbol()!=TokenClass.RELOP&&token.lexeme()!="=") {
			ErrorMessage.print("= expected");
		}
		getToken();
		
		Literal();
		
		if (token.symbol()!=TokenClass.SEMICOLON) {
			ErrorMessage.print("; expected");
		}
		getToken();
	}
	
	public void Type() throws java.io.IOException {
		if (token.symbol()==TokenClass.INT) {
			getToken();
		}
		else if (token.symbol()==TokenClass.LIST) {
			getToken();
			if (token.symbol()!=TokenClass.LEFTBRACKET) {
				ErrorMessage.print("[ expected");
			}
			getToken();
			if (token.symbol()!=TokenClass.INT) {
				ErrorMessage.print("int expected");
			}
			getToken();
			if (token.symbol()!=TokenClass.RIGHTBRACKET) {
				ErrorMessage.print("] expected");
			}
			getToken();
		}
		else {
			ErrorMessage.print("Type expected");
		}
	}
	
	public void Literal() throws java.io.IOException {
		if (token.symbol()!=TokenClass.INTEGER) {
			if (token.symbol()!=TokenClass.NIL) {
				ErrorMessage.print("Integer expected");
			}
			else {
				getToken();
			}
		}
		else {
			getToken();
		}
	}
	
	public void Statement() {
		System.out.println("statment");
	}
	
	public void ListExpr() {
		System.out.println("listexpr");
	}
}
