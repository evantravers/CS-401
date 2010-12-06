import java.io.IOException;

class SyntaxAnalyzer
{
  protected MicroScalaLexer lexer;
  protected Token token;

  public SyntaxAnalyzer()
    throws IOException
  {
    this.lexer = new MicroScalaLexer(System.in);
    getToken();
  }

  private void getToken() throws IOException {
    this.token = this.lexer.nextToken();
  }

  public void constDeclaration() throws IOException {
    if (this.token.symbol() == 11) {
      getToken();
      if (this.token.symbol() == 61) {
        getToken();
        if (this.token.symbol() == 12)
          getToken();
        else
          ErrorMessage.print(this.lexer.position(), "Integer expected");
      } else {
        ErrorMessage.print(this.lexer.position(), "= expected");
      }
    } else {
      ErrorMessage.print(this.lexer.position(), "id expected");
    }
  }

  public void varDeclaration() throws IOException {
    if (this.token.symbol() == 11)
      getToken();
    else
      ErrorMessage.print(this.lexer.position(), "ID EXPECTED");
  }

  public void factor() throws IOException {
    if (this.token.symbol() == 11) {
      getToken();
    } else if (this.token.symbol() == 12) {
      getToken();
    } else if (this.token.symbol() == 40) {
      getToken();
      expression();
      if (this.token.symbol() == 41)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "MISSING )");
    } else {
      ErrorMessage.print(this.lexer.position(), "UNRECOGNIZABLE SYMBOL");
    }
  }

  public void term() throws IOException {
    factor();

    while ((this.token.symbol() == 42) || (this.token.symbol() == 47)) {
      getToken();
      factor();
    }
  }

  public void expression() throws IOException {
    if ((this.token.symbol() == 43) || (this.token.symbol() == 45))
    {
      getToken();
      term();
    }
    else {
      term();
    }
    while ((this.token.symbol() == 43) || (this.token.symbol() == 45)) {
      getToken();
      term();
    }
  }

  public void condition() throws IOException {
    if (this.token.symbol() == 6) {
      getToken();
      expression();
    }
    else {
      expression();
      switch (this.token.symbol()) {
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
        getToken();
        expression();
        break;
      default:
        ErrorMessage.print(this.lexer.position(), "RELATIONAL OPERATOR EXPECTED");
      }
    }
  }

  public void statement() throws IOException
  {
    switch (this.token.symbol()) {
    case 11:
      getToken();
      if (this.token.symbol() == 13)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), ":= EXPECTED");
      expression();
      break;
    case 1:
      getToken();
      if (this.token.symbol() != 11)
        ErrorMessage.print(this.lexer.position(), "ID EXPECTED");
      else
        getToken();
      break;
    case 5:
      getToken();
      condition();
      if (this.token.symbol() == 8)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "THEN EXPECTED");
      statement();
      break;
    case 0:
      getToken();
      statement();
      while (this.token.symbol() == 59) {
        getToken();
        statement();
      }
      if (this.token.symbol() == 4)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "END OR ; EXPECTED");
      break;
    case 10:
      getToken();
      condition();
      if (this.token.symbol() == 3)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "DO EXPECTED");
      statement();
    case 2:
    case 3:
    case 4:
    case 6:
    case 7:
    case 8:
    case 9: }  } 
  public void block() throws IOException { if (this.token.symbol() == 2) {
      getToken();
      constDeclaration();
      while (this.token.symbol() == 44) {
        getToken();
        constDeclaration();
      }
      if (this.token.symbol() == 59)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), ", OR ; EXPECTED");
    }
    if (this.token.symbol() == 9) {
      getToken();
      varDeclaration();
      while (this.token.symbol() == 44) {
        getToken();
        varDeclaration();
      }
      if (this.token.symbol() == 59)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), ", OR ; EXPECTED");
    }
    while (this.token.symbol() == 7) {
      getToken();
      if (this.token.symbol() == 11)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "ID EXPECTED");
      if (this.token.symbol() == 59)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "; EXPECTED");
      block();
      if (this.token.symbol() == 59)
        getToken();
      else
        ErrorMessage.print(this.lexer.position(), "; EXPECTED");
    }
    statement(); }

  public void program() throws IOException
  {
    block();
    if (this.token.symbol() != 46)
      ErrorMessage.print(this.lexer.position(), ". EXPECTED");
  }
}

