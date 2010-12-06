// etravers@uab.edu
// Parser is a class to represent a recursive descent parser for the 
// MicroScala programming language.	The parser also constructs a 
// syntax tree representation of all executable constructions.

// TODO fix the scope numbers in the environment
 
import java.util.*;

public class Parser2 {

	protected MicroScalaLexer lexer;		// lexical analyzer
	protected Token token;					// current token

	public Parser2 () throws java.io.IOException {
		lexer = new MicroScalaLexer (System . in);
		getToken ();
	}

	protected void getToken () throws java.io.IOException {
		token = lexer . nextToken ();
	}

	// compilationUnit parses MicroScala programs.
	public SyntaxTree CompilationUnit (Environment env) throws java.io.IOException {
		// CompEnvironment env;
		SyntaxTree tree = null;
		// Environment varEnv = new Environment(env);
		String componentId;
		// object id { {Def} MainDef	}
		// object
		if (token.symbol()!=TokenClass.OBJECT) {
			ErrorMessage.print("object expected");
		}
		getToken();
		
		// id
		if (token.symbol()!=TokenClass.ID) {
			ErrorMessage.print("id expected");
		}
		componentId = token.lexeme();
		// env = new Enviroment();
		// varEnv = new VariableEnvironment (componentId);
		getToken();
		
		// {
		if (token.symbol()!=TokenClass.LEFTBRACE) {
			ErrorMessage.print("Left Brace expected");
		}
		getToken();
		
		// one or more defs
		while (token.symbol()==TokenClass.DEF||token.symbol()==TokenClass.VAR) {
			if (token.symbol()==TokenClass.DEF) {
				if (tree==null) {
					tree = Def(env);
				}
				else {
					// TODO examine whether putting "DEF" as the root here makes any difference
					tree = new SyntaxTree("DEF", tree, Def(env));
				}
			}
			else {
				VarDef(env);
			}
		}
		
		// }
		if (token.symbol()!=TokenClass.RIGHTBRACE) {
			ErrorMessage.print("Right BRACE Expected");
		}
		getToken();
				
		if (token.symbol()!=TokenClass.EOF) {
			ErrorMessage.print("EOF expected");			
		}
		//env.print();
		return tree;
//		return env;
	}
	
	// Def	
	public SyntaxTree Def(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		String defID="";
		Type defType=null;
		DefDenot defDenot;
		ArrayList <String> parameterList=null;
		if (token.symbol()!=TokenClass.DEF) {
			ErrorMessage.print("Def expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		if (token.symbol()==TokenClass.MAIN) {
			defID="MAIN";
			defType=Type.NULL;
			// this is a maindef
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			// time to get the args
			parameterList = new ArrayList <String> ();
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
				VarDef(env);
			}
			int stmtNum=0;
			do {
				if (stmtNum==0) {
					syntaxTree = Statement(env);
					stmtNum++;
				}
				else {
					syntaxTree = new SyntaxTree(";", syntaxTree, Statement(env));					
				}
			}
			while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE);
			
			if (token.symbol()!=TokenClass.RIGHTBRACE) {
				ErrorMessage.print("} expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();		
		}
		
		else if (token.symbol()==TokenClass.ID) {
			defID=token.lexeme();
			env.updateEnvProc(defID);
			Environment varEnv= new Environment(env);
			// varEnv.updateEnvProc(defID);
			// normal def
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
			parameterList = new ArrayList <String> ();
			if (token.symbol()==TokenClass.ID) {
				String varID = token.lexeme();	
				getToken();
				
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				
				Type varType = Type();
				if (varType==Type.INT) {
        		    varEnv.updateEnvVar(varID);
        		}
        		else {
        		    varEnv.updateEnvList(varID);
        		}
				while (token.symbol()==TokenClass.COMMA) {
					getToken();
					if (token.symbol()!=TokenClass.ID) {
						ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
					}
					varID = token.lexeme();
					
					getToken();
					if (token.symbol()!=TokenClass.COLON) {
						ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
					}
					getToken();
					varType = Type();
					
					varEnv.updateEnvVar(varID); 
				}
				if (token.symbol()!=TokenClass.RIGHTPAREN) {
					ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				if (token.symbol()!=TokenClass.COLON) {
					ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				// TODO this is where the return value of the def is set
				defType = Type();
				if (token.symbol()!=TokenClass.ASSIGN) {
					ErrorMessage.print("= expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				if (token.symbol()!=TokenClass.LEFTBRACE) {
					ErrorMessage.print("{ expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				while (token.symbol()==TokenClass.VAR) {
					VarDef(varEnv);
				}
				int stmtNum=0;
				while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE) {
					if (stmtNum==0) {
						syntaxTree = Statement(varEnv);
						stmtNum++;
					}
					else {
						syntaxTree = new SyntaxTree(";", syntaxTree, Statement(varEnv));						
						stmtNum++;
					}
				}
				if (token.symbol()!=TokenClass.RETURN) {
					ErrorMessage.print("Return expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}				
				getToken();
				// TODO fix this.
				syntaxTree= new SyntaxTree(";", syntaxTree, new SyntaxTree("RETURN", ListExpr(varEnv)));
				if (token.symbol()!=TokenClass.SEMICOLON) {
					ErrorMessage.print("; expected, current token is " + token.lexeme());
				}
				getToken();
				
				if (token.symbol()!=TokenClass.RIGHTBRACE) {
					ErrorMessage.print("} expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
			}
			env.updateEnvProc(defID, syntaxTree, varEnv);
		}
		
		else {
			// varEnv = new VariableEnvironment (defID);
			VarDef(env);
		}
		
		// defDenot = new DefDenot(parameterList, defType, varEnv, syntaxTree);
		// syntaxTree.print(defID);
		System . out . println ();
	    System . out . println ();
	    
		return syntaxTree;
	}
		
	public void VarDef(Environment env) throws java.io.IOException {
		String varId;
	    Type varType;
	
		if (token.symbol()!=TokenClass.VAR) {
			ErrorMessage.print("Var expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		if (token.symbol()!=TokenClass.ID) {
			ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		varId = token.lexeme ();
		getToken();
		
		if (token.symbol()!=TokenClass.COLON) {
			ErrorMessage.print(": expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		varType = Type();
		
		if (token.symbol()!=TokenClass.ASSIGN) {
			ErrorMessage.print("= expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		
		Literal();
		
		if (token.symbol()!=TokenClass.SEMICOLON) {
			ErrorMessage.print("; expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		getToken();
		// TODO this needs to have the value of the var in the null spot, taken from the literal.
		// env.updateEnvVar(varId);
		if (varType==Type.INT) {
		    env.updateEnvVar(varId);
		}
		else {
		    env.updateEnvList(varId);
		}
	}
	
	public Type Type() throws java.io.IOException {
		if (token.symbol()==TokenClass.INT) {
			getToken();
			return Type.INT;
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
			return Type.LIST;
		}
		else {
			ErrorMessage.print("Type expected");
			return null;
		}
	}
	
	public SyntaxTree Statement(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()==TokenClass.IF) {
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.lexeme());
			}
			getToken();
			SyntaxTree tmpExpr = Expr(env);
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.lexeme());
			}
			getToken();
			SyntaxTree result1 = Statement(env);
			if (token.symbol()==TokenClass.ELSE) {
				getToken();
				SyntaxTree result2 = Statement(env);
				
				syntaxTree = new SyntaxTree("IF",tmpExpr,result1,result2);
			}
			else {
				syntaxTree = new SyntaxTree("IF",tmpExpr,result1);				
			}
		}
		else if (token.symbol()==TokenClass.WHILE) {
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.lexeme());
			}
			getToken();
			SyntaxTree tmpExpr = Expr(env);
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.lexeme());
			}
			getToken();
			syntaxTree = new SyntaxTree("WHILE", tmpExpr, Statement(env));
		}
		else if (token.symbol()==TokenClass.ID) {
			// TODO handle this assignment statement here.
            // SyntaxTree tmpID = new SyntaxTree("ID", new SyntaxTree(token.lexeme()));
			String varID = token.lexeme();
			DenotableValue denotVal = env.accessEnv (varID);
            SyntaxTree tmpID = new SyntaxTree ("ID", 
                new SyntaxTree (varID,
                  new SyntaxTree (denotVal.value ())));
			getToken();
			if (token.symbol()!=TokenClass.ASSIGN) {
				ErrorMessage.print("= expected, current token is " + token.lexeme());
			}
			getToken();
			syntaxTree = new SyntaxTree("=", tmpID, ListExpr(env));
			if (token.symbol()!=TokenClass.SEMICOLON) {
				ErrorMessage.print("; expected, current token is " + token.lexeme());
			}
			getToken();
			// TODO fix this
			// env.update(varID, new ExpressibleValue (Type.INT, null));
		}
		else if (token.symbol()==TokenClass.PRINTLN) {
			getToken();
			if (token.symbol()!=TokenClass.LEFTPAREN) {
				ErrorMessage.print("( expected, current token is " + token.lexeme());
			}
			getToken();
			SyntaxTree listExp = ListExpr(env);
			syntaxTree = new SyntaxTree("PRINTLN", listExp);
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.lexeme());
			}
			getToken();
			if (token.symbol()!=TokenClass.SEMICOLON) {
				ErrorMessage.print("; expected, current token is " + token.lexeme());
			}
			getToken();
		}
		else if (token.symbol()==TokenClass.LEFTBRACE) {
			getToken();
			int stmtNum=0;
			do {
				if (stmtNum==0) {
					syntaxTree=Statement(env);
					stmtNum=1;
				}
				else {
					syntaxTree= new SyntaxTree(";", syntaxTree, Statement(env));
				}
			}
			while (token.symbol()==TokenClass.IF || token.symbol()==TokenClass.WHILE || token.symbol()==TokenClass.ID || token.symbol()==TokenClass.PRINTLN || token.symbol()==TokenClass.LEFTBRACE);
			if (token.symbol()!=TokenClass.RIGHTBRACE) {
				ErrorMessage.print("} expected, current token is " + token.lexeme());
			}
			getToken();
		}
		else {
			ErrorMessage.print("Statement expected, current token is " + token.lexeme());
		}
		return syntaxTree;
	}
	
	public SyntaxTree Expr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		// AndExpr {|| AndExpr}
		syntaxTree = AndExpr(env);
		while (token.symbol()==TokenClass.OR) {
			getToken();
			syntaxTree = new SyntaxTree("||", syntaxTree, AndExpr(env));
		}
		return syntaxTree;
	}
	
	public SyntaxTree AndExpr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		// RelExpr {&& RelExpr}
		syntaxTree = RelExpr(env);
		while (token.symbol()==TokenClass.AND) {
			getToken();
			syntaxTree = new SyntaxTree("AND", syntaxTree, RelExpr(env));
		}
		return syntaxTree;
	}
	
	public SyntaxTree RelExpr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		// [!] ListExpr [RelOper ListExpr]
		if (token.symbol()==TokenClass.NOT) {
			getToken();
			syntaxTree = new SyntaxTree("NOT", ListExpr(env));
		}
		else {
			syntaxTree = ListExpr(env);
		}
		if (token.symbol()==TokenClass.RELOP) {
			String tmpRel = token.lexeme();
			getToken();
			SyntaxTree tmpList = ListExpr(env);
			syntaxTree = new SyntaxTree(tmpRel, syntaxTree, tmpList);
		}
		return syntaxTree;
	}
	
	public SyntaxTree RelOper() throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()!=TokenClass.RELOP) {
			ErrorMessage.print("Relational operator expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		syntaxTree = new SyntaxTree(token.lexeme());
		getToken();
		return syntaxTree;
	}
	
	public SyntaxTree ListExpr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		// AddExpr | AddExpr :: ListExpr
		syntaxTree = AddExpr(env);
		if (token.symbol()==TokenClass.CONS) {
			getToken();
			SyntaxTree tmpList = ListExpr(env);
			syntaxTree = new SyntaxTree("::", syntaxTree, tmpList);
		}
		return syntaxTree;
	}
	
	public SyntaxTree AddExpr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		// MulExpr {AddOper MulExpr}
		syntaxTree = MulExpr(env);
		while (token.symbol()==TokenClass.ADDOP) {
			String tmpAdd = token.lexeme();
			getToken();
			syntaxTree= new SyntaxTree(tmpAdd,syntaxTree,MulExpr(env));
		}
		return syntaxTree;
	}
	
	public SyntaxTree AddOper() throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()!=TokenClass.ADDOP) {
			ErrorMessage.print("+ or - expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
	 	syntaxTree = new SyntaxTree(token.lexeme());
		getToken();
		return syntaxTree;
	}
	
	public SyntaxTree MulExpr(Environment env) throws java.io.IOException {
		// TODO I believe this is correct
		SyntaxTree syntaxTree=null;
		// PrefixExpr {MulOper PrefixExpr}
		syntaxTree = PrefixExpr(env);
		while (token.symbol()==TokenClass.MULTOP) {
			String tmpOp = token.lexeme();
			getToken();
			syntaxTree = new SyntaxTree(tmpOp, syntaxTree, PrefixExpr(env));
		}
		return syntaxTree;
	}
	
	public SyntaxTree MulOper() throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()!=TokenClass.MULTOP) {
			ErrorMessage.print("* or / expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		syntaxTree = new SyntaxTree(token.lexeme());
		getToken();
		return syntaxTree;
	}
	
	public SyntaxTree PrefixExpr(Environment env) throws java.io.IOException {
		// TODO this is wrong, check further
		SyntaxTree syntaxTree=null;
		if (token.symbol()==TokenClass.ADDOP) {
			String addop = token.lexeme();
			getToken();
			syntaxTree = new SyntaxTree(addop, SimpleExpr(env));
		}
		else {
			syntaxTree = SimpleExpr(env);
		}
		while (token.symbol()==TokenClass.PERIOD) {
			syntaxTree = new SyntaxTree(".", syntaxTree, ListMethodCall());
		}
		return syntaxTree;
	}
	
	public SyntaxTree ListMethodCall() throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()!=TokenClass.PERIOD) {
			ErrorMessage.print(". expected, current token is " + token.lexeme());
		}
		getToken();
		
		if (token.symbol()!=TokenClass.LISTOP) {
			ErrorMessage.print("List Operand expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
		}
		syntaxTree = new SyntaxTree(token.lexeme());
		getToken();
		return syntaxTree;
	}
	
	public SyntaxTree SimpleExpr(Environment env) throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()==TokenClass.NIL||token.symbol()==TokenClass.INTEGER) {
			syntaxTree = Literal();
		}
		else if (token.symbol()==TokenClass.LEFTPAREN) {
			// (Expr
			getToken();
			syntaxTree = Expr(env);
			if (token.symbol()!=TokenClass.RIGHTPAREN) {
				ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			getToken();
		}
		else {
			if (token.symbol()!=TokenClass.ID) {
				ErrorMessage.print("ID expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
			}
			String tmpID = token.lexeme();
			DenotableValue denotVal = env.accessEnv (tmpID);
			syntaxTree = new SyntaxTree ("ID", 
                new SyntaxTree (tmpID,
                  new SyntaxTree (denotVal.value ())));
			getToken();
			if (token.symbol()==TokenClass.LEFTPAREN) {
				getToken();
				// should be an optional ListExpr
				SyntaxTree tmp = ListExpr(env);
				// followed by 0 or more list expr preceded by a comma
				while (token.symbol()==TokenClass.COMMA) {
					getToken();
					// TODO check this
					tmp = new SyntaxTree(",", tmp, ListExpr(env));
				}
				if (token.symbol()!=TokenClass.RIGHTPAREN) {
					ErrorMessage.print(") expected, current token is " + token.symbol() + " with the lexeme " + token.lexeme());
				}
				getToken();
				// TODO manage this
				syntaxTree = new SyntaxTree("APPLY", syntaxTree, tmp);
				return syntaxTree;
			}
		}
		return syntaxTree;
	}
	
	public SyntaxTree Literal() throws java.io.IOException {
		SyntaxTree syntaxTree=null;
		if (token.symbol()!=TokenClass.INTEGER) {
			if (token.symbol()!=TokenClass.NIL) {
				ErrorMessage.print("Integer expected");
			}
			else {
				syntaxTree = new SyntaxTree("NIL");
				getToken();
			}
		}
		else {
			syntaxTree = new SyntaxTree(token.lexeme());
			getToken();
		}
		return syntaxTree;
	}
}
