%%
%{
  private void echo () { System . out . print (yytext ()); }

  public int position () { return yycolumn; }
%}

%class    MicroScalaLexer
%function nextToken
%type	  Token
%unicode
%line
%column
%eofval{
  { return new Token (TokenClass . EOF); }
%eofval}

Identifier = [:letter:]("_"?([:letter:] | [:digit:]))*
Integer    = [:digit:] [:digit:]*

%%
[ \t\n]	{ echo (); }
"//".*	{ echo (); }
";"		{ echo (); return new Token (TokenClass . SEMICOLON); }
":"		{ echo (); return new Token (TokenClass . COLON); }
"."		{ echo (); return new Token (TokenClass . PERIOD); }
","		{ echo (); return new Token (TokenClass . COMMA); }
"{"		{ echo (); return new Token (TokenClass . LEFTBRACE); }
"}"		{ echo (); return new Token (TokenClass . RIGHTBRACE); }
"["		{ echo (); return new Token (TokenClass . LEFTBRACKET); }
"]"		{ echo (); return new Token (TokenClass . RIGHTBRACKET); }
"||"		{ echo (); return new Token (TokenClass . OR); }
"&&"		{ echo (); return new Token (TokenClass . AND); }
"!"		{ echo (); return new Token (TokenClass . NOT); }
"<"		{ echo (); return new Token (TokenClass . RELOP, "<"); }
"<="		{ echo (); return new Token (TokenClass . RELOP, "<="); }
">"		{ echo (); return new Token (TokenClass . RELOP, ">"); }
">="		{ echo (); return new Token (TokenClass . RELOP, ">"); }
"=="		{ echo (); return new Token (TokenClass . RELOP, "=="); }
"!="		{ echo (); return new Token (TokenClass . RELOP, "!="); }
"::"		{ echo (); return new Token (TokenClass . CONS); }
"("		{ echo (); return new Token (TokenClass . LEFTPAREN); }
")"		{ echo (); return new Token (TokenClass . RIGHTPAREN); }
"+"		{ echo (); return new Token (TokenClass . ADDOP, "+"); }
"-"		{ echo (); return new Token (TokenClass . ADDOP, "-"); }
"*"		{ echo (); return new Token (TokenClass . MULTOP, "*"); }
"/"		{ echo (); return new Token (TokenClass . MULTOP, "/"); }
"="		{ echo (); return new Token (TokenClass . ASSIGN); }
args		{ echo (); return new Token (TokenClass . ARGS); }
Array		{ echo (); return new Token (TokenClass . ARRAY); }
def		{ echo (); return new Token (TokenClass . DEF); }
else		{ echo (); return new Token (TokenClass . ELSE); }
head		{ echo (); return new Token (TokenClass . LISTOP, "head"); }
if		{ echo (); return new Token (TokenClass . IF); }
Int		{ echo (); return new Token (TokenClass . INT); }
isEmpty	{ echo (); return new Token (TokenClass . LISTOP, "isEmpty"); }
List		{ echo (); return new Token (TokenClass . LIST); }
main		{ echo (); return new Token (TokenClass . MAIN); }
Nil		{ echo (); return new Token (TokenClass . NIL); }
object	{ echo (); return new Token (TokenClass . OBJECT); }
println	{ echo (); return new Token (TokenClass . PRINTLN); }
return	{ echo (); return new Token (TokenClass . RETURN); }
String	{ echo (); return new Token (TokenClass . STRING); }
tail		{ echo (); return new Token (TokenClass . LISTOP, "tail"); }
var		{ echo (); return new Token (TokenClass . VAR); }
while		{ echo (); return new Token (TokenClass . WHILE); }
{Integer}	{ echo (); return new Token (TokenClass . INTEGER, yytext ()); }
{Identifier}	{ echo (); return new Token (TokenClass . ID, yytext ()); }
.		{ echo (); ErrorMessage . print (yychar, "Illegal character"); }
