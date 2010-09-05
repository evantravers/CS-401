import java.io.FileReader;

public class Assign2 {

    private static final int MAX_TOKENS = 1000;

    public static void main(String args[]) throws java.io.IOException {

        // Added FileReader object so filenames can be entered as arguments
        for (String file : args) {
            FileReader reader = new FileReader(file);
            int i, n;
            Token[] token = new Token[MAX_TOKENS];
            ScalaLexer lexer = new ScalaLexer(reader);

            System.out.println("Source Program");
            System.out.println("--------------");
            System.out.println();

            n = -1;
            do {
                if (n < MAX_TOKENS) {
                    token[++n] = lexer.nextToken();
                } else {
                    ErrorMessage.print(0, "Maximum number of tokens exceeded");
                }
            } while (token[n].symbol() != TokenClass.EOF);

            System.out.println("\n");
            System.out.println("List of Tokens");
            System.out.println("--------------");
            System.out.println();
            for (i = 0; i < n; i++) {
                System.out.println(token[i]);
            }
            System.out.println();
        }
    }
}
