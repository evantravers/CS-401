%%
%{
  private void echo () { System . out . print (yytext ()); }

  public int position () { return yycolumn; }
%}

%class    ScalaLexer
%function nextToken
%type	  Token
%unicode
%line
%column
%eofval{
  { return new Token (TokenClass . EOF); }
%eofval}

// CHANGED in the new identifier, it allows underscores as well.
Literal    = [:digit:] [:digit:]*
Identifier = [:letter:] ("_"? ([:letter:] | [:digit:]))*

%%
[ \t\n]				{ echo (); }
"//".*            	{ echo (); }
object				{ echo(); return new Token (TokenClass.OBJECT);} 
def					{ echo(); return new Token (TokenClass.DEF);}         
main				{ echo(); return new Token (TokenClass.MAIN);}        
args				{ echo(); return new Token (TokenClass.ARGS);}		   
array				{ echo(); return new Token (TokenClass.ARRAY);} 	   
String				{ echo(); return new Token (TokenClass.STRING);} 	   
var					{ echo(); return new Token (TokenClass.VAR);} 		   
if 					{ echo(); return new Token (TokenClass.IF);}		   
else				{ echo(); return new Token (TokenClass.ELSE);} 	   
while 				{ echo(); return new Token (TokenClass.WHILE);} 	   
println 			{ echo(); return new Token (TokenClass.PRINT);} 	   
return  			{ echo(); return new Token (TokenClass.RETURN);}
"+" 				{ echo(); return new Token (TokenClass.PLUS);}		   
"-" 				{ echo(); return new Token (TokenClass.MINUS);}	   
"*" 				{ echo(); return new Token (TokenClass.TIMES);}       
"/" 				{ echo(); return new Token (TokenClass.SLASH);}       
"(" 				{ echo(); return new Token (TokenClass.LPAREN);}      
")" 				{ echo(); return new Token (TokenClass.RPAREN);} 
"[" 				{ echo(); return new Token (TokenClass.LBRAC);}      
"]" 				{ echo(); return new Token (TokenClass.RBRAC);}     
"{" 				{ echo(); return new Token (TokenClass.LCURL);}      
"}" 				{ echo(); return new Token (TokenClass.RCURL);}
"!" 				{ echo(); return new Token (TokenClass.NOT);}  
"&&" 				{ echo(); return new Token (TokenClass.AND);}  
"||" 				{ echo(); return new Token (TokenClass.OR);}
"==" 				{ echo(); return new Token (TokenClass.EQU);} 
"=" 				{ echo(); return new Token (TokenClass.EQ);}     	   
"<" 				{ echo(); return new Token (TokenClass.LT);}     	   
">" 				{ echo(); return new Token (TokenClass.GT);}     	   
"!=" 				{ echo(); return new Token (TokenClass.NE);}     	   
"<=" 				{ echo(); return new Token (TokenClass.LE);}     	   
">=" 				{ echo(); return new Token (TokenClass.GE);}     	   
"," 				{ echo(); return new Token (TokenClass.COMMA);}       
"." 				{ echo(); return new Token (TokenClass.PERIOD);}      
":" 				{ echo(); return new Token (TokenClass.COLON);}	   
";" 				{ echo(); return new Token (TokenClass.SEMICOLON);}
{Literal}			{ echo (); return new Token (TokenClass . LITERAL, yytext ()); }
{Identifier}	  	{ echo (); return new Token (TokenClass . IDENTIFIER, yytext ()); }
.					{ echo (); ErrorMessage . print (yychar, "Illegal character"); }