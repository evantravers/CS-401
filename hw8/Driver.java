public class Driver {
    public static void main(String[] args) throws java.io.IOException {
        ParserWithSymbolTable parser = new ParserWithSymbolTable();
        Environment tmp = parser.program();
        Interpreter inter = new Interpreter(tmp);        
    }
}