/* The following code was generated by JFlex 1.4.3 on 9/12/10 1:38 PM */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 9/12/10 1:38 PM from the specification file
 * <tt>/Users/evan/Projects/CS401/hw2/MicroScala.jflex</tt>
 */
class MicroScalaLexer {

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
    "\11\0\1\4\1\6\25\0\1\4\1\21\4\0\1\20\1\0\1\25"+
    "\1\26\1\31\1\27\1\12\1\30\1\11\1\5\12\3\1\10\1\7"+
    "\1\22\1\23\1\24\2\0\1\36\3\1\1\51\3\1\1\46\2\1"+
    "\1\54\1\1\1\55\4\1\1\63\7\1\1\15\1\0\1\16\1\0"+
    "\1\2\1\0\1\32\1\57\1\61\1\40\1\41\1\42\1\34\1\44"+
    "\1\45\1\60\1\1\1\43\1\52\1\47\1\56\1\53\1\1\1\33"+
    "\1\35\1\50\1\62\1\64\1\65\1\1\1\37\1\1\1\13\1\17"+
    "\1\14\54\0\1\1\12\0\1\1\4\0\1\1\5\0\27\1\1\0"+
    "\37\1\1\0\u013f\1\31\0\162\1\4\0\14\1\16\0\5\1\11\0"+
    "\1\1\213\0\1\1\13\0\1\1\1\0\3\1\1\0\1\1\1\0"+
    "\24\1\1\0\54\1\1\0\46\1\1\0\5\1\4\0\202\1\10\0"+
    "\105\1\1\0\46\1\2\0\2\1\6\0\20\1\41\0\46\1\2\0"+
    "\1\1\7\0\47\1\110\0\33\1\5\0\3\1\56\0\32\1\5\0"+
    "\13\1\25\0\12\3\4\0\2\1\1\0\143\1\1\0\1\1\17\0"+
    "\2\1\7\0\2\1\12\3\3\1\2\0\1\1\20\0\1\1\1\0"+
    "\36\1\35\0\3\1\60\0\46\1\13\0\1\1\u0152\0\66\1\3\0"+
    "\1\1\22\0\1\1\7\0\12\1\4\0\12\3\25\0\10\1\2\0"+
    "\2\1\2\0\26\1\1\0\7\1\1\0\1\1\3\0\4\1\3\0"+
    "\1\1\36\0\2\1\1\0\3\1\4\0\12\3\2\1\23\0\6\1"+
    "\4\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0\2\1"+
    "\1\0\2\1\37\0\4\1\1\0\1\1\7\0\12\3\2\0\3\1"+
    "\20\0\11\1\1\0\3\1\1\0\26\1\1\0\7\1\1\0\2\1"+
    "\1\0\5\1\3\0\1\1\22\0\1\1\17\0\2\1\4\0\12\3"+
    "\25\0\10\1\2\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1"+
    "\1\0\5\1\3\0\1\1\36\0\2\1\1\0\3\1\4\0\12\3"+
    "\1\0\1\1\21\0\1\1\1\0\6\1\3\0\3\1\1\0\4\1"+
    "\3\0\2\1\1\0\1\1\1\0\2\1\3\0\2\1\3\0\3\1"+
    "\3\0\10\1\1\0\3\1\55\0\11\3\25\0\10\1\1\0\3\1"+
    "\1\0\27\1\1\0\12\1\1\0\5\1\46\0\2\1\4\0\12\3"+
    "\25\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0\5\1"+
    "\3\0\1\1\40\0\1\1\1\0\2\1\4\0\12\3\25\0\10\1"+
    "\1\0\3\1\1\0\27\1\1\0\20\1\46\0\2\1\4\0\12\3"+
    "\25\0\22\1\3\0\30\1\1\0\11\1\1\0\1\1\2\0\7\1"+
    "\72\0\60\1\1\0\2\1\14\0\7\1\11\0\12\3\47\0\2\1"+
    "\1\0\1\1\2\0\2\1\1\0\1\1\2\0\1\1\6\0\4\1"+
    "\1\0\7\1\1\0\3\1\1\0\1\1\1\0\1\1\2\0\2\1"+
    "\1\0\4\1\1\0\2\1\11\0\1\1\2\0\5\1\1\0\1\1"+
    "\11\0\12\3\2\0\2\1\42\0\1\1\37\0\12\3\26\0\10\1"+
    "\1\0\42\1\35\0\4\1\164\0\42\1\1\0\5\1\1\0\2\1"+
    "\25\0\12\3\6\0\6\1\112\0\46\1\12\0\51\1\7\0\132\1"+
    "\5\0\104\1\5\0\122\1\6\0\7\1\1\0\77\1\1\0\1\1"+
    "\1\0\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\47\1"+
    "\1\0\1\1\1\0\4\1\2\0\37\1\1\0\1\1\1\0\4\1"+
    "\2\0\7\1\1\0\1\1\1\0\4\1\2\0\7\1\1\0\7\1"+
    "\1\0\27\1\1\0\37\1\1\0\1\1\1\0\4\1\2\0\7\1"+
    "\1\0\47\1\1\0\23\1\16\0\11\3\56\0\125\1\14\0\u026c\1"+
    "\2\0\10\1\12\0\32\1\5\0\113\1\25\0\15\1\1\0\4\1"+
    "\16\0\22\1\16\0\22\1\16\0\15\1\1\0\3\1\17\0\64\1"+
    "\43\0\1\1\4\0\1\1\3\0\12\3\46\0\12\3\6\0\130\1"+
    "\10\0\51\1\127\0\35\1\51\0\12\3\36\1\2\0\5\1\u038b\0"+
    "\154\1\224\0\234\1\4\0\132\1\6\0\26\1\2\0\6\1\2\0"+
    "\46\1\2\0\6\1\2\0\10\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\37\1\2\0\65\1\1\0\7\1\1\0\1\1\3\0"+
    "\3\1\1\0\7\1\3\0\4\1\2\0\6\1\4\0\15\1\5\0"+
    "\3\1\1\0\7\1\164\0\1\1\15\0\1\1\202\0\1\1\4\0"+
    "\1\1\2\0\12\1\1\0\1\1\3\0\5\1\6\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\4\1\1\0\3\1\1\0\7\1\3\0"+
    "\3\1\5\0\5\1\u0ebb\0\2\1\52\0\5\1\5\0\2\1\4\0"+
    "\126\1\6\0\3\1\1\0\132\1\1\0\4\1\5\0\50\1\4\0"+
    "\136\1\21\0\30\1\70\0\20\1\u0200\0\u19b6\1\112\0\u51a6\1\132\0"+
    "\u048d\1\u0773\0\u2ba4\1\u215c\0\u012e\1\2\0\73\1\225\0\7\1\14\0"+
    "\5\1\5\0\1\1\1\0\12\1\1\0\15\1\1\0\5\1\1\0"+
    "\1\1\1\0\2\1\1\0\2\1\1\0\154\1\41\0\u016b\1\22\0"+
    "\100\1\2\0\66\1\50\0\14\1\164\0\5\1\1\0\207\1\23\0"+
    "\12\3\7\0\32\1\6\0\32\1\13\0\131\1\3\0\6\1\2\0"+
    "\6\1\2\0\6\1\2\0\3\1\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\2\1\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\21\2\1\0\1\4\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\7\2\1\36\15\2\1\37\3\2\1\40"+
    "\4\2\1\41\2\2\1\42\1\2\1\43\2\2\1\44"+
    "\1\45\1\2\1\46\1\47\1\2\1\50\4\2\1\51"+
    "\4\2\1\52\1\53\2\2\1\54\1\55\1\56\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[113];
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
    "\0\0\0\66\0\154\0\242\0\66\0\330\0\66\0\u010e"+
    "\0\66\0\66\0\66\0\66\0\66\0\66\0\u0144\0\u017a"+
    "\0\u01b0\0\u01e6\0\u021c\0\u0252\0\66\0\66\0\66\0\66"+
    "\0\66\0\u0288\0\u02be\0\u02f4\0\u032a\0\u0360\0\u0396\0\u03cc"+
    "\0\u0402\0\u0438\0\u046e\0\u04a4\0\u04da\0\u0510\0\u0546\0\u057c"+
    "\0\u05b2\0\u05e8\0\u061e\0\u0654\0\66\0\66\0\66\0\66"+
    "\0\66\0\66\0\66\0\u068a\0\u06c0\0\u06f6\0\u072c\0\u0762"+
    "\0\u0798\0\u07ce\0\154\0\u0804\0\u083a\0\u0870\0\u08a6\0\u08dc"+
    "\0\u0912\0\u0948\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u0a56\0\u0a8c"+
    "\0\154\0\u0ac2\0\u0af8\0\u0b2e\0\154\0\u0b64\0\u0b9a\0\u0bd0"+
    "\0\u0c06\0\154\0\u0c3c\0\u0c72\0\154\0\u0ca8\0\154\0\u0cde"+
    "\0\u0d14\0\154\0\154\0\u0d4a\0\154\0\154\0\u0d80\0\154"+
    "\0\u0db6\0\u0dec\0\u0e22\0\u0e58\0\154\0\u0e8e\0\u0ec4\0\u0efa"+
    "\0\u0f30\0\154\0\154\0\u0f66\0\u0f9c\0\154\0\154\0\154"+
    "\0\154";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[113];
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
    "\1\2\1\3\1\2\1\4\1\5\1\6\1\5\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\2\3\1\34\1\3\1\35"+
    "\1\36\2\3\1\37\1\40\1\41\1\3\1\42\1\3"+
    "\1\43\1\44\1\45\1\46\1\47\4\3\1\50\1\51"+
    "\1\52\67\0\1\3\1\53\1\3\26\0\34\3\3\0"+
    "\1\4\67\0\1\54\70\0\1\55\74\0\1\56\66\0"+
    "\1\57\70\0\1\60\65\0\1\61\65\0\1\62\65\0"+
    "\1\63\43\0\1\3\1\53\1\3\26\0\1\3\1\64"+
    "\32\3\1\0\1\3\1\53\1\3\26\0\7\3\1\65"+
    "\24\3\1\0\1\3\1\53\1\3\26\0\1\3\1\66"+
    "\32\3\1\0\1\3\1\53\1\3\26\0\7\3\1\67"+
    "\24\3\1\0\1\3\1\53\1\3\26\0\11\3\1\70"+
    "\22\3\1\0\1\3\1\53\1\3\26\0\7\3\1\71"+
    "\24\3\1\0\1\3\1\53\1\3\26\0\3\3\1\72"+
    "\4\3\1\73\23\3\1\0\1\3\1\53\1\3\26\0"+
    "\15\3\1\74\16\3\1\0\1\3\1\53\1\3\26\0"+
    "\1\75\33\3\1\0\1\3\1\53\1\3\26\0\1\76"+
    "\33\3\1\0\1\3\1\53\1\3\26\0\1\3\1\77"+
    "\32\3\1\0\1\3\1\53\1\3\26\0\13\3\1\100"+
    "\20\3\1\0\1\3\1\53\1\3\26\0\13\3\1\101"+
    "\20\3\1\0\1\3\1\53\1\3\26\0\25\3\1\102"+
    "\6\3\1\0\1\3\1\53\1\3\26\0\16\3\1\103"+
    "\15\3\1\0\1\3\1\53\1\3\26\0\1\104\33\3"+
    "\1\0\1\3\1\53\1\3\26\0\12\3\1\105\21\3"+
    "\1\0\1\3\1\0\1\3\26\0\34\3\6\54\1\0"+
    "\57\54\1\0\1\3\1\53\1\3\26\0\2\3\1\106"+
    "\31\3\1\0\1\3\1\53\1\3\26\0\16\3\1\107"+
    "\15\3\1\0\1\3\1\53\1\3\26\0\1\3\1\110"+
    "\32\3\1\0\1\3\1\53\1\3\26\0\10\3\1\111"+
    "\23\3\1\0\1\3\1\53\1\3\26\0\3\3\1\112"+
    "\30\3\1\0\1\3\1\53\1\3\26\0\1\113\33\3"+
    "\1\0\1\3\1\53\1\3\26\0\17\3\1\114\14\3"+
    "\1\0\1\3\1\53\1\3\26\0\16\3\1\115\15\3"+
    "\1\0\1\3\1\53\1\3\26\0\13\3\1\116\20\3"+
    "\1\0\1\3\1\53\1\3\26\0\13\3\1\117\20\3"+
    "\1\0\1\3\1\53\1\3\26\0\13\3\1\120\20\3"+
    "\1\0\1\3\1\53\1\3\26\0\3\3\1\121\30\3"+
    "\1\0\1\3\1\53\1\3\26\0\11\3\1\122\22\3"+
    "\1\0\1\3\1\53\1\3\26\0\26\3\1\123\5\3"+
    "\1\0\1\3\1\53\1\3\26\0\1\3\1\124\32\3"+
    "\1\0\1\3\1\53\1\3\26\0\1\3\1\125\32\3"+
    "\1\0\1\3\1\53\1\3\26\0\13\3\1\126\20\3"+
    "\1\0\1\3\1\53\1\3\26\0\3\3\1\127\30\3"+
    "\1\0\1\3\1\53\1\3\26\0\30\3\1\130\3\3"+
    "\1\0\1\3\1\53\1\3\26\0\1\131\33\3\1\0"+
    "\1\3\1\53\1\3\26\0\7\3\1\132\24\3\1\0"+
    "\1\3\1\53\1\3\26\0\6\3\1\133\25\3\1\0"+
    "\1\3\1\53\1\3\26\0\20\3\1\134\13\3\1\0"+
    "\1\3\1\53\1\3\26\0\11\3\1\135\22\3\1\0"+
    "\1\3\1\53\1\3\26\0\15\3\1\136\16\3\1\0"+
    "\1\3\1\53\1\3\26\0\15\3\1\137\16\3\1\0"+
    "\1\3\1\53\1\3\26\0\16\3\1\140\15\3\1\0"+
    "\1\3\1\53\1\3\26\0\7\3\1\141\24\3\1\0"+
    "\1\3\1\53\1\3\26\0\13\3\1\142\20\3\1\0"+
    "\1\3\1\53\1\3\26\0\11\3\1\143\22\3\1\0"+
    "\1\3\1\53\1\3\26\0\1\3\1\144\32\3\1\0"+
    "\1\3\1\53\1\3\26\0\5\3\1\145\26\3\1\0"+
    "\1\3\1\53\1\3\26\0\21\3\1\146\12\3\1\0"+
    "\1\3\1\53\1\3\26\0\16\3\1\147\15\3\1\0"+
    "\1\3\1\53\1\3\26\0\27\3\1\150\4\3\1\0"+
    "\1\3\1\53\1\3\26\0\15\3\1\151\16\3\1\0"+
    "\1\3\1\53\1\3\26\0\7\3\1\152\24\3\1\0"+
    "\1\3\1\53\1\3\26\0\15\3\1\153\16\3\1\0"+
    "\1\3\1\53\1\3\26\0\16\3\1\154\15\3\1\0"+
    "\1\3\1\53\1\3\26\0\11\3\1\155\22\3\1\0"+
    "\1\3\1\53\1\3\26\0\16\3\1\156\15\3\1\0"+
    "\1\3\1\53\1\3\26\0\2\3\1\157\31\3\1\0"+
    "\1\3\1\53\1\3\26\0\5\3\1\160\26\3\1\0"+
    "\1\3\1\53\1\3\26\0\15\3\1\161\16\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4050];
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
    "\1\0\1\11\2\1\1\11\1\1\1\11\1\1\6\11"+
    "\6\1\5\11\21\1\1\0\1\1\7\11\76\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[113];
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
  MicroScalaLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  MicroScalaLexer(java.io.InputStream in) {
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
    while (i < 1312) {
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
        case 17: 
          { echo (); return new Token (TokenClass . RELOP, ">");
          }
        case 48: break;
        case 35: 
          { echo (); return new Token (TokenClass . ARGS);
          }
        case 49: break;
        case 41: 
          { echo (); return new Token (TokenClass . ARRAY);
          }
        case 50: break;
        case 16: 
          { echo (); return new Token (TokenClass . ASSIGN);
          }
        case 51: break;
        case 43: 
          { echo (); return new Token (TokenClass . RETURN);
          }
        case 52: break;
        case 8: 
          { echo (); return new Token (TokenClass . PERIOD);
          }
        case 53: break;
        case 15: 
          { echo (); return new Token (TokenClass . RELOP, "<");
          }
        case 54: break;
        case 7: 
          { echo (); return new Token (TokenClass . COLON);
          }
        case 55: break;
        case 12: 
          { echo (); return new Token (TokenClass . LEFTBRACKET);
          }
        case 56: break;
        case 28: 
          { echo (); return new Token (TokenClass . RELOP, "==");
          }
        case 57: break;
        case 18: 
          { echo (); return new Token (TokenClass . LEFTPAREN);
          }
        case 58: break;
        case 44: 
          { echo (); return new Token (TokenClass . OBJECT);
          }
        case 59: break;
        case 32: 
          { echo (); return new Token (TokenClass . INT);
          }
        case 60: break;
        case 42: 
          { echo (); return new Token (TokenClass . WHILE);
          }
        case 61: break;
        case 39: 
          { echo (); return new Token (TokenClass . MAIN);
          }
        case 62: break;
        case 36: 
          { echo (); return new Token (TokenClass . ELSE);
          }
        case 63: break;
        case 14: 
          { echo (); return new Token (TokenClass . NOT);
          }
        case 64: break;
        case 25: 
          { echo (); return new Token (TokenClass . AND);
          }
        case 65: break;
        case 2: 
          { echo (); return new Token (TokenClass . ID, yytext ());
          }
        case 66: break;
        case 22: 
          { echo (); return new Token (TokenClass . MULTOP, "*");
          }
        case 67: break;
        case 1: 
          { echo (); ErrorMessage . print (yychar, "Illegal character");
          }
        case 68: break;
        case 6: 
          { echo (); return new Token (TokenClass . SEMICOLON);
          }
        case 69: break;
        case 5: 
          { echo (); return new Token (TokenClass . MULTOP, "/");
          }
        case 70: break;
        case 11: 
          { echo (); return new Token (TokenClass . RIGHTBRACE);
          }
        case 71: break;
        case 27: 
          { echo (); return new Token (TokenClass . RELOP, "<=");
          }
        case 72: break;
        case 31: 
          { echo (); return new Token (TokenClass . DEF);
          }
        case 73: break;
        case 13: 
          { echo (); return new Token (TokenClass . RIGHTBRACKET);
          }
        case 74: break;
        case 34: 
          { echo (); return new Token (TokenClass . VAR);
          }
        case 75: break;
        case 9: 
          { echo (); return new Token (TokenClass . COMMA);
          }
        case 76: break;
        case 30: 
          { echo (); return new Token (TokenClass . IF);
          }
        case 77: break;
        case 45: 
          { echo (); return new Token (TokenClass . STRING);
          }
        case 78: break;
        case 3: 
          { echo (); return new Token (TokenClass . INTEGER, yytext ());
          }
        case 79: break;
        case 24: 
          { echo (); return new Token (TokenClass . OR);
          }
        case 80: break;
        case 21: 
          { echo (); return new Token (TokenClass . ADDOP, "-");
          }
        case 81: break;
        case 33: 
          { echo (); return new Token (TokenClass . NIL);
          }
        case 82: break;
        case 23: 
          { echo (); return new Token (TokenClass . CONS);
          }
        case 83: break;
        case 46: 
          { echo (); return new Token (TokenClass . LISTOP, "isEmpty");
          }
        case 84: break;
        case 19: 
          { echo (); return new Token (TokenClass . RIGHTPAREN);
          }
        case 85: break;
        case 10: 
          { echo (); return new Token (TokenClass . LEFTBRACE);
          }
        case 86: break;
        case 26: 
          { echo (); return new Token (TokenClass . RELOP, "!=");
          }
        case 87: break;
        case 37: 
          { echo (); return new Token (TokenClass . LISTOP, "head");
          }
        case 88: break;
        case 20: 
          { echo (); return new Token (TokenClass . ADDOP, "+");
          }
        case 89: break;
        case 4: 
          { echo ();
          }
        case 90: break;
        case 29: 
          { echo (); return new Token (TokenClass . RELOP, ">=");
          }
        case 91: break;
        case 47: 
          { echo (); return new Token (TokenClass . PRINTLN);
          }
        case 92: break;
        case 40: 
          { echo (); return new Token (TokenClass . LIST);
          }
        case 93: break;
        case 38: 
          { echo (); return new Token (TokenClass . LISTOP, "tail");
          }
        case 94: break;
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