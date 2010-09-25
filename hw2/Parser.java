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
		// ob ject	id	{	{Def}	MainDef	}
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
		if (token.symbol()!=TokenClass.DEF) {
			ErrorMessage.print("Def expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		if (token.symbol()==TokenClass.MAIN) {
			// this is a maindef
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.ARGS) {
				ErrorMessage.print("args expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.COLON) {
				ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.ARRAY) {
				ErrorMessage.print("Array expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.LEFTBRACKET) {
				ErrorMessage.print("[ expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.STRING) {
				ErrorMessage.print("String expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.RIGHTBRACKET) {
				ErrorMessage.print("] expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.LEFTBRACE) {
				ErrorMessage.print("{ expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			while (token.symbol()==TokenClass.VAR) {
				VarDef();
			}
			
			Statement();
			
			while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE) {
				Statement();
			}
			if (token.symbol()!=TokenClass.RIGHTBRACE) {
				ErrorMessage.print("} expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
		}
		
		else if (token.symbol()==TokenClass.ID) {
			// normal def
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()==TokenClass.ID) {
				getToken();
				
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				
				Type();
				
				while (token.symbol()==TokenClass.COMMA) {
					getToken();
					if (token.symbol()!=TokenClass.ID) {
						ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
					}
					getToken();
					if (token.symbol()!=TokenClass.COLON) {
						ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
					}
					getToken();
					Type();
				}
				if (token.symbol()!=TokenClass.RIGHTPAREN) {
					ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				Type();
				if (token.symbol()!=TokenClass.ASSIGN) {
					ErrorMessage.print("= expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				if (token.symbol()!=TokenClass.LEFTBRACE) {
					ErrorMessage.print("{ expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				while (token.symbol()==TokenClass.VAR) {
					VarDef();
				}
				while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE) {
					Statement();
				}
				if (token.symbol()!=TokenClass.RETURN) {
					ErrorMessage.print("Return expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}				
				getToken();
				ListExpr();
				if (token.symbol()!=TokenClass.RIGHTBRACE) {
					ErrorMessage.print("} expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
			}
		}
		
		else {
			VarDef();
		}
	}
	
	public void VarDef() throws java.io.IOException {
		if (token.symbol()!=TokenClass.VAR) {
			ErrorMessage.print("Var expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		if (token.symbol()!=TokenClass.ID) {
			ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		if (token.symbol()!=TokenClass.COLON) {
			ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		Type();
		
		if (token.symbol()!=TokenClass.ASSIGN) {
			ErrorMessage.print("= expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		Literal();
		
		if (token.symbol()!=TokenClass.SEMICOLON) {
			ErrorMessage.print("; expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
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
	
	public void Statement() throws java.io.IOException {
		if (token.symbol()==TokenClass.IF) {
			// if ( Expr ) Statement [else Statement]
			
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			Expr();
			
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			Statement();
			
			if (token.symbol()==TokenClass.ELSE) {
				getToken();
				Statement();
			}
			getToken();
		}
		else if (token.symbol()==TokenClass.WHILE) {
			// while ( Expr ) Statement
			getToken();
			
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			Expr();
			
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			Statement();
			getToken();
			
		}
		else if (token.symbol()==TokenClass.ID) {
			// id = ListExpr ;
			getToken();
			
			if (token.symbol()!=TokenClass.ASSIGN) {
				ErrorMessage.print("= expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			ListExpr();
		}
		else if (token.symbol()==TokenClass.PRINTLN) {
			// println ( ListExpr ) ;
			getToken();
			
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			ListExpr();
			
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
			if (token.symbol()!=TokenClass.SEMICOLON) {
				ErrorMessage.print("; expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			
		}
		else if (token.symbol()==TokenClass.LEFTBRACE) {
			// { Statement {Statement} }
			getToken();
			Statement();
			while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE) {
				Statement();
			}
		}
		else {
			ErrorMessage.print("Flaw in expected statement, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
	}
	
	public void Expr() throws java.io.IOException {
		// AndExpr {|| AndExpr}
		AndExpr();
		while (token.symbol()==TokenClass.OR) {
			getToken();
			AndExpr();
		}
	}
	
	public void AndExpr() throws java.io.IOException {
		// RelExpr {&& RelExpr}
		RelExpr();
		while (token.symbol()==TokenClass.AND) {
			getToken();
			RelExpr();
		}
	}
	
	public void RelExpr() throws java.io.IOException {
		// [!] ListExpr [RelOper ListExpr]
		if (token.symbol()==TokenClass.NOT) {
			getToken();
		}
		ListExpr();
		if (token.symbol()==TokenClass.RELOP) {
			getToken();
			ListExpr();
		}
	}
	
	public void RelOper() throws java.io.IOException {
		if (token.symbol()!=TokenClass.RELOP) {
			ErrorMessage.print("Relational operator expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
	}
	
	public void ListExpr() throws java.io.IOException {
		// AddExpr | AddExpr :: ListExpr
		AddExpr();
		if (token.symbol()==TokenClass.CONS) {
			getToken();
			ListExpr();
		}
	}
	
	public void AddExpr() throws java.io.IOException {
		// MulExpr {AddOper MulExpr}
		MulExpr();
		while (token.symbol()==TokenClass.ADDOP) {
			getToken();
			MulExpr();
		}
	}
	
	public void AddOper() throws java.io.IOException {
		if (token.symbol()!=TokenClass.ADDOP) {
			ErrorMessage.print("+ or - expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
	}
	
	public void MulExpr() throws java.io.IOException {
		// PrefixExpr {MulOper PrefixExpr}
		PrefixExpr();
		while (token.symbol()==TokenClass.MULTOP) {
			getToken();
			PrefixExpr();
		}
	}
	
	public void MulOper() throws java.io.IOException {
		if (token.symbol()!=TokenClass.MULTOP) {
			ErrorMessage.print("* or / expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
	}
	
	public void PrefixExpr() throws java.io.IOException {
		if (token.symbol()==TokenClass.ADDOP) {
			getToken();
		}
		SimpleExpr();
		while (token.symbol()==TokenClass.LISTOP) {
			ListMethodCall();
		}
	}
	
	public void ListMethodCall() throws java.io.IOException {
		if (token.symbol()!=TokenClass.LISTOP) {
			ErrorMessage.print("List Operand expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
	}
	
	public void SimpleExpr() throws java.io.IOException {
		if (token.symbol()==TokenClass.NIL||token.symbol()==TokenClass.INTEGER) {
			Literal();
			getToken();
		}
		else if (token.symbol()==TokenClass.LEFTPAREN) {
			// (Expr)
			getToken();
			Expr();
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
		}
		else {
			if (token.symbol()!=TokenClass.ID) {
				ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			if (token.symbol()==TokenClass.LEFTPAREN) {
				getToken();
				// should be an optional ListExpr
				
				// followed by 0 or more list expr preceded by a comma
				while (token.symbol()!=TokenClass.COMMA) {
					getToken();
					ListExpr();
				}
				if (token.symbol()!=TokenClass.RIGHTPAREN) {
					ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
			}
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
}
