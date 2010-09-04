%%
%{
  private void echo () { System . out . print (yytext ()); }

  public int position () { return yycolumn; }
%}

%class    scalaLexer
%function nextToken
%type	  Token
%unicode
%line
%column
%eofval{
  { return new Token (TokenClass . EOF); }
%eofval}

Identifier = [:letter:]([:letter:] | [:digit:])*
Integer    = [:digit:] [:digit:]*

%%
[ \t\n]		{ echo (); }
";"		{ echo (); return new Token (TokenClass . SEMICOLON); }
"."		{ echo (); return new Token (TokenClass . PERIOD); }
","		{ echo (); return new Token (TokenClass . COMMA); }
"<"		{ echo (); return new Token (TokenClass . LT); }
"<="		{ echo (); return new Token (TokenClass . LE); }
">"		{ echo (); return new Token (TokenClass . GT); }
">="		{ echo (); return new Token (TokenClass . GE); }
"="		{ echo (); return new Token (TokenClass . EQ); }
"<>"		{ echo (); return new Token (TokenClass . NE); }
"("		{ echo (); return new Token (TokenClass . LPAREN); }
")"		{ echo (); return new Token (TokenClass . RPAREN); }
"+"		{ echo (); return new Token (TokenClass . PLUS); }
"-"		{ echo (); return new Token (TokenClass . MINUS); }
"*"		{ echo (); return new Token (TokenClass . TIMES); }
"/"		{ echo (); return new Token (TokenClass . SLASH); }
":="		{ echo (); return new Token (TokenClass . ASSIGN); }
begin		{ echo (); return new Token (TokenClass . BEGIN); }
call		{ echo (); return new Token (TokenClass . CALL); }
const		{ echo (); return new Token (TokenClass . CONST); }
do		{ echo (); return new Token (TokenClass . DO); }
end		{ echo (); return new Token (TokenClass . END); }
if		{ echo (); return new Token (TokenClass . IF); }
odd		{ echo (); return new Token (TokenClass . ODD); }
procedure	{ echo (); return new Token (TokenClass . PROC); }
then		{ echo (); return new Token (TokenClass . THEN); }
var		{ echo (); return new Token (TokenClass . VAR); }
while		{ echo (); return new Token (TokenClass . WHILE); }
{Integer}	{ echo (); return new Token (TokenClass . INTEGER, yytext ()); }
{Identifier}	{ echo (); return new Token (TokenClass . ID, yytext ()); }
.		{ echo (); ErrorMessage . print (yychar, "Illegal character"); }