// ParserWithSymbolTable is a class to represent a recursive descent parser for
// the MicroScala programming language.  The parser also constructs a syntax 
// tree representation of all executable constructions and an environment for
// each function.

import java.util.*;

public class ParserWithSymbolTable {

  protected MicroScalaLexer lexer;  // lexical analyzer
  protected Token token;           // current token

  public ParserWithSymbolTable () throws java.io.IOException {
    lexer = new MicroScalaLexer (System . in);
    getToken ();
  }

  protected void getToken () throws java.io.IOException {
    token = lexer . nextToken ();
  }

  // program parses MicroScala programs.

  public Environment program () throws java.io.IOException {
    Environment envglobal = new Environment ();
    String funcId = null, objId = null;
    boolean maindef;
    if (token . symbol () != TokenClass . OBJECT) 	// object
      ErrorMessage . print ("object EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . ID)    	// id
      ErrorMessage . print ("ID EXPECTED");
    objId = token . lexeme ();
    getToken ();
    if (token . symbol () != TokenClass . LEFTBRACE)    // {
      ErrorMessage . print ("{ EXPECTED");
    getToken ();
    maindef = false;
    while ((token . symbol () == TokenClass . DEF ||
        token . symbol () == TokenClass . VAR) && !maindef) {  	
      if (token . symbol () == TokenClass . DEF) {  	// def
        getToken ();
        if (token . symbol () == TokenClass . ID) {	// id
          funcId = token . lexeme ();
          getToken ();
          functionDef (funcId, envglobal); 		// function definition
        }
        else if (token . symbol () == TokenClass . MAIN) { // main
          getToken ();
          mainDef (envglobal); 				// main definition
          maindef = true;
        }
        else
          ErrorMessage . print ("ID EXPECTED");
      }
      else
        varDef (envglobal); 					// VarDef
    }
    if (!maindef)
      ErrorMessage . print ("main DEFINITION EXPECTED");
    if (token . symbol () != TokenClass . RIGHTBRACE)   // }
      ErrorMessage . print ("} EXPECTED");
    getToken (); 					
    if (token . symbol () != TokenClass . EOF) 		
      ErrorMessage . print ("END OF PROGRAM EXPECTED");
    // envglobal . print (objId);
    return envglobal;
  }

  // mainDef parses MicroScala main definitions.

  public void mainDef (Environment envglobal) throws java.io.IOException {
    Environment envlocal = new Environment ();
    SyntaxTree statementTree, syntaxTree;
    if (token . symbol () != TokenClass . LEFTPAREN)    // (
      ErrorMessage . print ("( EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . ARGS)         // args
      ErrorMessage . print ("args EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . COLON)        // :
      ErrorMessage . print (": EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . ARRAY)        // Array
      ErrorMessage . print ("Array EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . LEFTBRACKET)  // [
      ErrorMessage . print ("[ EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . STRING)       // String
      ErrorMessage . print ("String EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . RIGHTBRACKET) // ]
      ErrorMessage . print ("] EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . RIGHTPAREN)   // )
      ErrorMessage . print (") EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . LEFTBRACE)    // {
      ErrorMessage . print ("{ EXPECTED");
    getToken ();
    while (token . symbol () == TokenClass . VAR)  	// { VarDef } 
      varDef (envlocal);
    syntaxTree = statement (); 				// Statement
    while (token . symbol () != TokenClass . RIGHTBRACE) { // { Statement } 
      statementTree = statement ();
      syntaxTree = new SyntaxTree (";", syntaxTree, statementTree);
    }
    getToken (); 					// }
    envglobal . 
      update ("main",
        new FunctionDenot (null, new Type (Type . VOID), envlocal, syntaxTree));
  }

  // functionDef parses MicroScala function definitions.

  public void functionDef (String funcId, Environment envglobal) 
      throws java.io.IOException {
    ArrayList<String> parameter = new ArrayList<String> ();
    Environment envlocal = new Environment ();
    String argId;
    SyntaxTree listExprTree, returnTree, statementTree, syntaxTree;
    Type argType, funcType;
    if (token . symbol () != TokenClass . LEFTPAREN)    // (
      ErrorMessage . print ("( EXPECTED");
    getToken ();
    if (token . symbol () == TokenClass . ID) {         // [ id
      argId = token . lexeme ();
      parameter . add (argId);
      getToken ();
      if (token . symbol () != TokenClass . COLON)      // :
        ErrorMessage . print (": EXPECTED");
      getToken ();
      argType = type (); 				// Type
      envlocal . update (argId, new ExpressibleValue (argType, null));
      while (token . symbol () == TokenClass . COMMA) {	// { ,
        getToken ();
        if (token . symbol () != TokenClass . ID)       // id
          ErrorMessage . print ("id EXPECTED");
        argId = token . lexeme ();
        parameter . add (argId);
        getToken ();
        if (token . symbol () != TokenClass . COLON)    // :
          ErrorMessage . print (": EXPECTED");
        getToken ();
        argType = type (); 				// Type
        envlocal . update (argId, new ExpressibleValue (argType, null));
      } 						// }
    } 							// ]
    if (token . symbol () != TokenClass . RIGHTPAREN)   // )
      ErrorMessage . print (") EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . COLON)    	// :
      ErrorMessage . print (": EXPECTED");
    getToken ();
    funcType = type (); 				// Type
    if (token . symbol () != TokenClass . ASSIGN)       // =
      ErrorMessage . print ("= EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . LEFTBRACE)    // {
      ErrorMessage . print ("{ EXPECTED");
    getToken ();
    while (token . symbol () == TokenClass . VAR)  	// { VarDef } 
      varDef (envlocal);
    syntaxTree = null;
    while (token . symbol () != TokenClass . RETURN) {	// { Statement } 
      statementTree = statement ();
      if (syntaxTree == null)
        syntaxTree = statementTree;
      else
        syntaxTree = new SyntaxTree (";", syntaxTree, statementTree);
    }
    getToken (); 					// return
    listExprTree = listExpr (); 			// ListExpr
    returnTree = new SyntaxTree ("return", listExprTree);
    if (syntaxTree == null)
      syntaxTree = returnTree;
    else
      syntaxTree = new SyntaxTree (";", syntaxTree, returnTree);
    if (token . symbol () != TokenClass . SEMICOLON)    // ;
      ErrorMessage . print ("; EXPECTED");
    getToken (); 	
    if (token . symbol () != TokenClass . RIGHTBRACE)   // }
      ErrorMessage . print ("} EXPECTED");
    envglobal . 
      update (funcId, 
        new FunctionDenot (parameter, funcType, envlocal, syntaxTree));
    getToken (); 	
  }

  // varDef parses variable definitions.

  public void varDef (Environment env) throws java.io.IOException {
    String varId;
    SyntaxTree literalTree;
    Type varType;
    if (token . symbol () != TokenClass . VAR)    	// var
      ErrorMessage . print ("var EXPECTED");
    getToken ();
    if (token . symbol () != TokenClass . ID)    	// id
      ErrorMessage . print ("id EXPECTED");
    varId = token . lexeme ();
    getToken ();
    if (token . symbol () != TokenClass . COLON)  	// :
      ErrorMessage . print (": EXPECTED");
    getToken ();					
    varType = type (); 					// Type
    if (token . symbol () != TokenClass . ASSIGN)  	// =
      ErrorMessage . print ("= EXPECTED");
    getToken ();					
    literalTree = literal (); 				// Literal
    if (varType . type () == Type . INTEGER && 
        literalTree . root () . contentEquals ("0"))
      env . update (varId, new ExpressibleValue (varType, new Integer (0)));
    else if (varType . type () == Type . LIST &&
        literalTree . root () . contentEquals ("Nil")) 
      env . update (varId, 
        new ExpressibleValue (varType, new ArrayList <Integer> ()));
    else
      ErrorMessage . 
        print ("Initial value must be 0 for integers and Nil for lists");
    if (token . symbol () != TokenClass . SEMICOLON)  	// ;
      ErrorMessage . print ("; EXPECTED");
    getToken ();					
  }
  
  // type parses types.

  public Type type () throws java.io.IOException {
    Type type = null;
    if (token . symbol () == TokenClass . INT) {          // Int 
      type = new Type (Type . INTEGER);
      getToken ();
    }
    else if (token . symbol () == TokenClass . LIST) {    // List
      type = new Type (Type . LIST);
      getToken ();
      if (token . symbol () != TokenClass . LEFTBRACKET)  // [
        ErrorMessage . print ("[ EXPECTED");
      getToken ();
      if (token . symbol () != TokenClass . INT)          // Int
        ErrorMessage . print ("String EXPECTED");
      getToken ();
      if (token . symbol () != TokenClass . RIGHTBRACKET) // ]
        ErrorMessage . print ("] EXPECTED");
      getToken ();
    }
    else
      ErrorMessage . print ("TYPE EXPECTED");
    return type;
  }

  // statement parses statements.

  public SyntaxTree statement () throws java.io.IOException {
    SyntaxTree expressionTree, idTree, syntaxTree = null;
    SyntaxTree statementTree = null, statement1Tree, statement2Tree;

    switch (token . symbol ()) {

      case IF :						  // if
        getToken ();
        if (token . symbol () != TokenClass . LEFTPAREN)  // (
          ErrorMessage . print ("( EXPECTED");
        getToken ();
        expressionTree = expr (); 		  	  // Expr
        if (token . symbol () != TokenClass . RIGHTPAREN) // )
          ErrorMessage . print (") EXPECTED");
        getToken ();
        statement1Tree = statement ();			  // Statement
        if (token . symbol () == TokenClass . ELSE) {	  // [ else
	    getToken (); 					
	    statement2Tree = statement ();           	  // Statement
        }
        else
          statement2Tree = null; 			  // ]
        syntaxTree = 
	    new SyntaxTree ("if", expressionTree, statement1Tree, statement2Tree);
        break;
  
      case WHILE :					  // while
        getToken (); 
        if (token . symbol () != TokenClass . LEFTPAREN)  // (
          ErrorMessage . print ("( EXPECTED");
        getToken ();
        expressionTree = expr (); 		  	  // Expr
        if (token . symbol () != TokenClass . RIGHTPAREN) // )
          ErrorMessage . print (") EXPECTED");
        getToken ();
        statementTree = statement ();			  // Statement
        syntaxTree = 
          new SyntaxTree ("while", expressionTree, statementTree);
        break;

      case ID  : 					  // id
        idTree = new SyntaxTree (token . lexeme ());
        getToken ();
        if (token . symbol () != TokenClass . ASSIGN) 	  // =
          ErrorMessage . print ("= EXPECTED");
        getToken ();					
        expressionTree = listExpr (); 			  // ListExpr
        syntaxTree = new SyntaxTree ("=", idTree, expressionTree);
        if (token . symbol () != TokenClass . SEMICOLON)  // ;
          ErrorMessage . print ("; EXPECTED");
        getToken ();					
        break;

      case PRINTLN :					  // println
        getToken ();
        if (token . symbol () != TokenClass . LEFTPAREN)  // (
          ErrorMessage . print ("( EXPECTED");
        getToken ();					
        expressionTree = listExpr (); 			  // ListExpr
        if (token . symbol () != TokenClass . RIGHTPAREN) // )
          ErrorMessage . print (") EXPECTED");
        getToken ();					
        syntaxTree = new SyntaxTree ("println", expressionTree);
        if (token . symbol () != TokenClass . SEMICOLON)  // ;
          ErrorMessage . print ("; EXPECTED");
        getToken ();					
        break;

      case LEFTBRACE : 					  // {
        getToken ();
        syntaxTree = statement (); 				// Statement
        while (token . symbol () != TokenClass . RIGHTBRACE) { // { Statement } 
          statementTree = statement ();
          syntaxTree = new SyntaxTree (";", syntaxTree, statementTree);
        }
        getToken (); 					  // }
        break;
      
      default :
        ErrorMessage . print ("STATEMENT EXPECTED");
    }
  
    return syntaxTree;
  }

  // expr parses expressions. 
   
  public SyntaxTree expr () throws java.io.IOException {
    SyntaxTree andExprTree, syntaxTree;
    syntaxTree = andExpr (); 				// AndExpr
    while (token . symbol () == TokenClass . OR) {   	// { ||
      getToken ();
      andExprTree = andExpr (); 			// AndExpr
      syntaxTree = new SyntaxTree ("||", syntaxTree, andExprTree);
    } 							// }
    return syntaxTree;
  }

  // andExpr parses and expressions. 
   
  public SyntaxTree andExpr () throws java.io.IOException {
    SyntaxTree relExprTree, syntaxTree;
    syntaxTree = relExpr (); 				// RelExpr
    while (token . symbol () == TokenClass . AND) {   	// { &&
      getToken ();
      relExprTree = relExpr (); 			// RelExpr
      syntaxTree = new SyntaxTree ("&&", syntaxTree, relExprTree);
    } 							// }
    return syntaxTree;
  }

  // relExpr parses relational expressions. 
   
  public SyntaxTree relExpr () throws java.io.IOException {
    boolean notExpr;
    String relop;
    SyntaxTree listExprTree, syntaxTree;
    notExpr = false;
    if (token . symbol () == TokenClass . NOT) { 	// [!]
      getToken ();
      notExpr = true;
    }
    syntaxTree = listExpr (); 				// ListExpr
    if (token . symbol () == TokenClass . RELOP) {	// [ RelOper
      relop = token . lexeme ();
      getToken ();
      listExprTree = listExpr (); 			// ListExpr
      syntaxTree = new SyntaxTree (relop, syntaxTree, listExprTree);
    } 							// ]
    if (notExpr)
      syntaxTree = new SyntaxTree ("!", syntaxTree);
    return syntaxTree;
  }
  
  // listExpr parses list expressions. 
   
  public SyntaxTree listExpr () throws java.io.IOException {
    SyntaxTree listExprTree, syntaxTree;
    syntaxTree = addExpr (); 				// AddExpr
    if (token . symbol () == TokenClass . CONS) { 	// ::
      getToken ();
      listExprTree = listExpr (); 			// ListExpr
      syntaxTree = new SyntaxTree ("::", syntaxTree, listExprTree);
    }
    return syntaxTree;
  }
  
  // addExpr parses additive expressions. 
   
  public SyntaxTree addExpr () throws java.io.IOException {
    String addop;
    SyntaxTree mulExprTree, syntaxTree;
    syntaxTree = mulExpr (); 				// MulExpr
    while (token . symbol () == TokenClass . ADDOP) {   // { AddOper
      addop = token . lexeme ();
      getToken ();
      mulExprTree = mulExpr (); 			// MulExpr
      syntaxTree = new SyntaxTree (addop, syntaxTree, mulExprTree);
    } 							// }
    return syntaxTree;
  }
  
  // mulExpr parses multiplicative expressions. 
   
  public SyntaxTree mulExpr () throws java.io.IOException {
    String mulop;
    SyntaxTree prefixExprTree, syntaxTree;
    syntaxTree = prefixExpr (); 			// prefixExpr
    while (token . symbol () == TokenClass . MULTOP) { 	// { mult-operator
      mulop = token . lexeme ();
      getToken ();
      prefixExprTree = prefixExpr (); 			// prefixExpr
      syntaxTree = new SyntaxTree (mulop, syntaxTree, prefixExprTree);
    } 							// }
    return syntaxTree;
  }
  
  // prefixExpr parses prefixExpr expressions.
  
  public SyntaxTree prefixExpr () throws java.io.IOException {
    String addop, listop;
    SyntaxTree syntaxTree = null;
    addop = null;
    if (token . symbol () == TokenClass . ADDOP) { 	// [AddOper]
      addop = token . lexeme ();
      getToken ();
    }
    syntaxTree = simpleExpr (); 			// SimpleExpr
    while (token . symbol () == TokenClass . PERIOD) {  // { .
      getToken ();
      if (token . symbol () != TokenClass . LISTOP)	// head | tail | isEmpty
        ErrorMessage . print ("LIST METHOD EXPECTED");
      listop = token . lexeme ();
      getToken ();
      syntaxTree = new SyntaxTree (listop, syntaxTree);
    } 							// }
    if (addop != null)
      syntaxTree = new SyntaxTree (addop, syntaxTree);
    return syntaxTree;
  }

  // simpleExpr parses simple expressions.
  
  public SyntaxTree simpleExpr () throws java.io.IOException {
    SyntaxTree exprListTree, idTree, listExprTree;
    SyntaxTree syntaxTree = null;
    if (token . symbol () == TokenClass . LEFTPAREN) {  // (
      getToken ();
      syntaxTree = expr (); 			 	// Expr
      if (token . symbol () != TokenClass . RIGHTPAREN) // )
        ErrorMessage . print (") EXPECTED");
      getToken ();
    }
    else if (token . symbol () == TokenClass . ID) {	// id
      idTree = new SyntaxTree (token . lexeme ());
      getToken ();			
      if (token . symbol () != TokenClass . LEFTPAREN) 	
        syntaxTree = idTree; 			
      else { 						// (
        getToken ();
        exprListTree = null;
        if (token . symbol () != TokenClass . RIGHTPAREN)  { // [
          exprListTree = listExpr ();			// ListExpr
          while (token . symbol () == TokenClass . COMMA) { // { , 
            getToken ();
            listExprTree = listExpr ();			// ListExpr
            exprListTree = new SyntaxTree (",", exprListTree, listExprTree);
          }						// }
          if (token . symbol () != TokenClass . RIGHTPAREN) // )
            ErrorMessage . print (") EXPECTED");
        } 						// ]
        getToken ();
        syntaxTree = new SyntaxTree ("apply", idTree, exprListTree);
      }
    }
    else
      syntaxTree = literal (); 				// Literal
    return syntaxTree;
  }

  // literal parses literals.
  
  public SyntaxTree literal () throws java.io.IOException {
    SyntaxTree syntaxTree = null;
    if (token . symbol () == TokenClass . INTEGER) {	// integer
      syntaxTree = new SyntaxTree (token . lexeme ());
      getToken ();
    }
    else if (token . symbol () == TokenClass . NIL) {	// Nil
      syntaxTree = new SyntaxTree ("Nil");
      getToken ();
    }
    else
      ErrorMessage . print ("LITERAL EXPECTED");
    return syntaxTree;
  }

}
