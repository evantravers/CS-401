/* The following code was generated by JFlex 1.4.3 on 9/6/10 6:29 PM */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 9/6/10 6:29 PM from the specification file
 * <tt>/Users/evan/Projects/CS401/Scala.jflex</tt>
 */
class ScalaLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\6\25\0\1\4\1\51\4\0\1\52\1\0\1\43"+
    "\1\44\1\42\1\40\1\57\1\41\1\60\1\5\12\1\1\61\1\62"+
    "\1\55\1\54\1\56\2\0\10\2\1\30\2\2\1\31\6\2\1\27"+
    "\7\2\1\45\1\0\1\46\1\0\1\3\1\0\1\20\1\10\1\13"+
    "\1\15\1\12\1\16\1\24\1\35\1\21\1\11\1\2\1\33\1\17"+
    "\1\22\1\7\1\36\1\2\1\23\1\25\1\14\1\37\1\32\1\34"+
    "\1\2\1\26\1\2\1\47\1\53\1\50\54\0\1\2\12\0\1\2"+
    "\4\0\1\2\5\0\27\2\1\0\37\2\1\0\u013f\2\31\0\162\2"+
    "\4\0\14\2\16\0\5\2\11\0\1\2\213\0\1\2\13\0\1\2"+
    "\1\0\3\2\1\0\1\2\1\0\24\2\1\0\54\2\1\0\46\2"+
    "\1\0\5\2\4\0\202\2\10\0\105\2\1\0\46\2\2\0\2\2"+
    "\6\0\20\2\41\0\46\2\2\0\1\2\7\0\47\2\110\0\33\2"+
    "\5\0\3\2\56\0\32\2\5\0\13\2\25\0\12\1\4\0\2\2"+
    "\1\0\143\2\1\0\1\2\17\0\2\2\7\0\2\2\12\1\3\2"+
    "\2\0\1\2\20\0\1\2\1\0\36\2\35\0\3\2\60\0\46\2"+
    "\13\0\1\2\u0152\0\66\2\3\0\1\2\22\0\1\2\7\0\12\2"+
    "\4\0\12\1\25\0\10\2\2\0\2\2\2\0\26\2\1\0\7\2"+
    "\1\0\1\2\3\0\4\2\3\0\1\2\36\0\2\2\1\0\3\2"+
    "\4\0\12\1\2\2\23\0\6\2\4\0\2\2\2\0\26\2\1\0"+
    "\7\2\1\0\2\2\1\0\2\2\1\0\2\2\37\0\4\2\1\0"+
    "\1\2\7\0\12\1\2\0\3\2\20\0\11\2\1\0\3\2\1\0"+
    "\26\2\1\0\7\2\1\0\2\2\1\0\5\2\3\0\1\2\22\0"+
    "\1\2\17\0\2\2\4\0\12\1\25\0\10\2\2\0\2\2\2\0"+
    "\26\2\1\0\7\2\1\0\2\2\1\0\5\2\3\0\1\2\36\0"+
    "\2\2\1\0\3\2\4\0\12\1\1\0\1\2\21\0\1\2\1\0"+
    "\6\2\3\0\3\2\1\0\4\2\3\0\2\2\1\0\1\2\1\0"+
    "\2\2\3\0\2\2\3\0\3\2\3\0\10\2\1\0\3\2\55\0"+
    "\11\1\25\0\10\2\1\0\3\2\1\0\27\2\1\0\12\2\1\0"+
    "\5\2\46\0\2\2\4\0\12\1\25\0\10\2\1\0\3\2\1\0"+
    "\27\2\1\0\12\2\1\0\5\2\3\0\1\2\40\0\1\2\1\0"+
    "\2\2\4\0\12\1\25\0\10\2\1\0\3\2\1\0\27\2\1\0"+
    "\20\2\46\0\2\2\4\0\12\1\25\0\22\2\3\0\30\2\1\0"+
    "\11\2\1\0\1\2\2\0\7\2\72\0\60\2\1\0\2\2\14\0"+
    "\7\2\11\0\12\1\47\0\2\2\1\0\1\2\2\0\2\2\1\0"+
    "\1\2\2\0\1\2\6\0\4\2\1\0\7\2\1\0\3\2\1\0"+
    "\1\2\1\0\1\2\2\0\2\2\1\0\4\2\1\0\2\2\11\0"+
    "\1\2\2\0\5\2\1\0\1\2\11\0\12\1\2\0\2\2\42\0"+
    "\1\2\37\0\12\1\26\0\10\2\1\0\42\2\35\0\4\2\164\0"+
    "\42\2\1\0\5\2\1\0\2\2\25\0\12\1\6\0\6\2\112\0"+
    "\46\2\12\0\51\2\7\0\132\2\5\0\104\2\5\0\122\2\6\0"+
    "\7\2\1\0\77\2\1\0\1\2\1\0\4\2\2\0\7\2\1\0"+
    "\1\2\1\0\4\2\2\0\47\2\1\0\1\2\1\0\4\2\2\0"+
    "\37\2\1\0\1\2\1\0\4\2\2\0\7\2\1\0\1\2\1\0"+
    "\4\2\2\0\7\2\1\0\7\2\1\0\27\2\1\0\37\2\1\0"+
    "\1\2\1\0\4\2\2\0\7\2\1\0\47\2\1\0\23\2\16\0"+
    "\11\1\56\0\125\2\14\0\u026c\2\2\0\10\2\12\0\32\2\5\0"+
    "\113\2\25\0\15\2\1\0\4\2\16\0\22\2\16\0\22\2\16\0"+
    "\15\2\1\0\3\2\17\0\64\2\43\0\1\2\4\0\1\2\3\0"+
    "\12\1\46\0\12\1\6\0\130\2\10\0\51\2\127\0\35\2\51\0"+
    "\12\1\36\2\2\0\5\2\u038b\0\154\2\224\0\234\2\4\0\132\2"+
    "\6\0\26\2\2\0\6\2\2\0\46\2\2\0\6\2\2\0\10\2"+
    "\1\0\1\2\1\0\1\2\1\0\1\2\1\0\37\2\2\0\65\2"+
    "\1\0\7\2\1\0\1\2\3\0\3\2\1\0\7\2\3\0\4\2"+
    "\2\0\6\2\4\0\15\2\5\0\3\2\1\0\7\2\164\0\1\2"+
    "\15\0\1\2\202\0\1\2\4\0\1\2\2\0\12\2\1\0\1\2"+
    "\3\0\5\2\6\0\1\2\1\0\1\2\1\0\1\2\1\0\4\2"+
    "\1\0\3\2\1\0\7\2\3\0\3\2\5\0\5\2\u0ebb\0\2\2"+
    "\52\0\5\2\5\0\2\2\4\0\126\2\6\0\3\2\1\0\132\2"+
    "\1\0\4\2\5\0\50\2\4\0\136\2\21\0\30\2\70\0\20\2"+
    "\u0200\0\u19b6\2\112\0\u51a6\2\132\0\u048d\2\u0773\0\u2ba4\2\u215c\0\u012e\2"+
    "\2\0\73\2\225\0\7\2\14\0\5\2\5\0\1\2\1\0\12\2"+
    "\1\0\15\2\1\0\5\2\1\0\1\2\1\0\2\2\1\0\2\2"+
    "\1\0\154\2\41\0\u016b\2\22\0\100\2\2\0\66\2\50\0\14\2"+
    "\164\0\5\2\1\0\207\2\23\0\12\1\7\0\32\2\6\0\32\2"+
    "\13\0\131\2\3\0\6\2\2\0\6\2\2\0\6\2\2\0\3\2"+
    "\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\15\3\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\2\1\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\0\1\4\5\3\1\27\7\3\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\2\3\1\36\5\3\1\37"+
    "\1\3\1\40\3\3\1\41\1\42\1\3\1\43\2\3"+
    "\1\44\3\3\1\45\2\3\1\46\1\3\1\47\1\50"+
    "\1\51\1\3\1\52";

  private static int [] zzUnpackAction() {
    int [] result = new int[93];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\63\0\314\0\377\0\u0132"+
    "\0\u0165\0\u0198\0\u01cb\0\u01fe\0\u0231\0\u0264\0\u0297\0\u02ca"+
    "\0\u02fd\0\u0330\0\u0363\0\63\0\63\0\63\0\63\0\63"+
    "\0\63\0\63\0\63\0\63\0\u0396\0\u03c9\0\u03fc\0\u042f"+
    "\0\u0462\0\u0495\0\63\0\63\0\63\0\63\0\u04c8\0\u04fb"+
    "\0\u052e\0\u0561\0\u0594\0\u05c7\0\u05fa\0\231\0\u062d\0\u0660"+
    "\0\u0693\0\u06c6\0\u06f9\0\u072c\0\u075f\0\63\0\63\0\63"+
    "\0\63\0\63\0\63\0\u0792\0\u07c5\0\231\0\u07f8\0\u082b"+
    "\0\u085e\0\u0891\0\u08c4\0\231\0\u08f7\0\231\0\u092a\0\u095d"+
    "\0\u0990\0\231\0\231\0\u09c3\0\231\0\u09f6\0\u0a29\0\231"+
    "\0\u0a5c\0\u0a8f\0\u0ac2\0\231\0\u0af5\0\u0b28\0\231\0\u0b5b"+
    "\0\231\0\231\0\231\0\u0b8e\0\231";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[93];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\5\1\7"+
    "\2\4\1\10\2\4\1\11\1\4\1\12\1\13\1\14"+
    "\1\4\1\15\3\4\1\16\1\17\1\20\1\21\1\4"+
    "\1\22\1\4\1\23\1\4\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\64\0"+
    "\1\3\62\0\2\4\1\47\3\0\31\4\30\0\1\50"+
    "\56\0\2\4\1\47\3\0\1\4\1\51\27\4\24\0"+
    "\2\4\1\47\3\0\24\4\1\52\4\4\24\0\2\4"+
    "\1\47\3\0\3\4\1\53\25\4\24\0\2\4\1\47"+
    "\3\0\11\4\1\54\17\4\24\0\2\4\1\47\3\0"+
    "\14\4\1\55\14\4\24\0\2\4\1\47\3\0\7\4"+
    "\1\56\21\4\24\0\2\4\1\47\3\0\3\4\1\57"+
    "\25\4\24\0\2\4\1\47\3\0\5\4\1\60\23\4"+
    "\24\0\2\4\1\47\3\0\13\4\1\61\15\4\24\0"+
    "\2\4\1\47\3\0\12\4\1\62\16\4\24\0\2\4"+
    "\1\47\3\0\11\4\1\63\17\4\24\0\2\4\1\47"+
    "\3\0\26\4\1\64\2\4\24\0\2\4\1\47\3\0"+
    "\14\4\1\65\14\4\77\0\1\66\60\0\1\67\63\0"+
    "\1\70\63\0\1\71\62\0\1\72\62\0\1\73\7\0"+
    "\2\4\4\0\31\4\23\0\6\50\1\0\54\50\1\0"+
    "\2\4\1\47\3\0\2\4\1\74\26\4\24\0\2\4"+
    "\1\47\3\0\16\4\1\75\12\4\24\0\2\4\1\47"+
    "\3\0\7\4\1\76\21\4\24\0\2\4\1\47\3\0"+
    "\12\4\1\77\16\4\24\0\2\4\1\47\3\0\14\4"+
    "\1\100\1\101\13\4\24\0\2\4\1\47\3\0\5\4"+
    "\1\102\23\4\24\0\2\4\1\47\3\0\14\4\1\103"+
    "\14\4\24\0\2\4\1\47\3\0\5\4\1\104\23\4"+
    "\24\0\2\4\1\47\3\0\16\4\1\105\12\4\24\0"+
    "\2\4\1\47\3\0\14\4\1\106\14\4\24\0\2\4"+
    "\1\47\3\0\12\4\1\107\16\4\24\0\2\4\1\47"+
    "\3\0\12\4\1\110\16\4\24\0\2\4\1\47\3\0"+
    "\3\4\1\111\25\4\24\0\2\4\1\47\3\0\3\4"+
    "\1\112\25\4\24\0\2\4\1\47\3\0\13\4\1\113"+
    "\15\4\24\0\2\4\1\47\3\0\11\4\1\114\17\4"+
    "\24\0\2\4\1\47\3\0\16\4\1\115\12\4\24\0"+
    "\2\4\1\47\3\0\30\4\1\116\24\0\2\4\1\47"+
    "\3\0\12\4\1\117\16\4\24\0\2\4\1\47\3\0"+
    "\5\4\1\120\23\4\24\0\2\4\1\47\3\0\24\4"+
    "\1\121\4\4\24\0\2\4\1\47\3\0\13\4\1\122"+
    "\15\4\24\0\2\4\1\47\3\0\4\4\1\123\24\4"+
    "\24\0\2\4\1\47\3\0\17\4\1\124\11\4\24\0"+
    "\2\4\1\47\3\0\14\4\1\125\14\4\24\0\2\4"+
    "\1\47\3\0\13\4\1\126\15\4\24\0\2\4\1\47"+
    "\3\0\3\4\1\127\25\4\24\0\2\4\1\47\3\0"+
    "\5\4\1\130\23\4\24\0\2\4\1\47\3\0\5\4"+
    "\1\131\23\4\24\0\2\4\1\47\3\0\13\4\1\132"+
    "\15\4\24\0\2\4\1\47\3\0\15\4\1\133\13\4"+
    "\24\0\2\4\1\47\3\0\24\4\1\134\4\4\24\0"+
    "\2\4\1\47\3\0\13\4\1\135\15\4\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3009];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\16\1\11\11\6\1\4\11"+
    "\1\0\16\1\6\11\42\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[93];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private void echo () { System . out . print (yytext ()); }

  public int position () { return yycolumn; }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ScalaLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  ScalaLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1302) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { echo(); return new Token (TokenClass.PLUS);
          }
        case 43: break;
        case 39: 
          { echo(); return new Token (TokenClass.OBJECT);
          }
        case 44: break;
        case 31: 
          { echo(); return new Token (TokenClass.INT);
          }
        case 45: break;
        case 22: 
          { echo(); return new Token (TokenClass.SEMICOLON);
          }
        case 46: break;
        case 13: 
          { echo(); return new Token (TokenClass.LCURL);
          }
        case 47: break;
        case 5: 
          { echo(); return new Token (TokenClass.SLASH);
          }
        case 48: break;
        case 15: 
          { echo(); return new Token (TokenClass.NOT);
          }
        case 49: break;
        case 25: 
          { echo(); return new Token (TokenClass.AND);
          }
        case 50: break;
        case 14: 
          { echo(); return new Token (TokenClass.RCURL);
          }
        case 51: break;
        case 34: 
          { echo(); return new Token (TokenClass.MAIN);
          }
        case 52: break;
        case 29: 
          { echo(); return new Token (TokenClass.GE);
          }
        case 53: break;
        case 33: 
          { echo(); return new Token (TokenClass.ELSE);
          }
        case 54: break;
        case 37: 
          { echo(); return new Token (TokenClass.ARRAY);
          }
        case 55: break;
        case 9: 
          { echo(); return new Token (TokenClass.LPAREN);
          }
        case 56: break;
        case 28: 
          { echo(); return new Token (TokenClass.LE);
          }
        case 57: break;
        case 2: 
          { echo (); return new Token (TokenClass . LITERAL, yytext ());
          }
        case 58: break;
        case 8: 
          { echo(); return new Token (TokenClass.TIMES);
          }
        case 59: break;
        case 21: 
          { echo(); return new Token (TokenClass.COLON);
          }
        case 60: break;
        case 27: 
          { echo(); return new Token (TokenClass.EQU);
          }
        case 61: break;
        case 3: 
          { echo (); return new Token (TokenClass . IDENTIFIER, yytext ());
          }
        case 62: break;
        case 38: 
          { echo(); return new Token (TokenClass.WHILE);
          }
        case 63: break;
        case 30: 
          { echo(); return new Token (TokenClass.DEF);
          }
        case 64: break;
        case 1: 
          { echo (); ErrorMessage . print (yychar, "Illegal character");
          }
        case 65: break;
        case 18: 
          { echo(); return new Token (TokenClass.GT);
          }
        case 66: break;
        case 32: 
          { echo(); return new Token (TokenClass.VAR);
          }
        case 67: break;
        case 17: 
          { echo(); return new Token (TokenClass.LT);
          }
        case 68: break;
        case 41: 
          { echo(); return new Token (TokenClass.STRING);
          }
        case 69: break;
        case 11: 
          { echo(); return new Token (TokenClass.LBRAC);
          }
        case 70: break;
        case 12: 
          { echo(); return new Token (TokenClass.RBRAC);
          }
        case 71: break;
        case 7: 
          { echo(); return new Token (TokenClass.MINUS);
          }
        case 72: break;
        case 42: 
          { echo(); return new Token (TokenClass.PRINT);
          }
        case 73: break;
        case 10: 
          { echo(); return new Token (TokenClass.RPAREN);
          }
        case 74: break;
        case 19: 
          { echo(); return new Token (TokenClass.COMMA);
          }
        case 75: break;
        case 36: 
          { echo(); return new Token (TokenClass.LIST);
          }
        case 76: break;
        case 23: 
          { echo(); return new Token (TokenClass.IF);
          }
        case 77: break;
        case 35: 
          { echo(); return new Token (TokenClass.ARGS);
          }
        case 78: break;
        case 26: 
          { echo(); return new Token (TokenClass.OR);
          }
        case 79: break;
        case 40: 
          { echo(); return new Token (TokenClass.RETURN);
          }
        case 80: break;
        case 16: 
          { echo(); return new Token (TokenClass.EQ);
          }
        case 81: break;
        case 20: 
          { echo(); return new Token (TokenClass.PERIOD);
          }
        case 82: break;
        case 4: 
          { echo ();
          }
        case 83: break;
        case 24: 
          { echo(); return new Token (TokenClass.NE);
          }
        case 84: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {   { return new Token (TokenClass . EOF); }
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}