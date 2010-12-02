// Interpreter.java

// Interpreter is a class to represent an interpreter for the MicroScala programming 
// language. It works by traversing the syntax tree constructed by the parser.

public class Interpreter {

	protected Store store;			// memory store

	public Interpreter (int numStackFrames, int mainProgramSize) {
		store = new Store (numStackFrames, mainProgramSize);
	}

	public Store store () { return store; }

	public void C (SyntaxTree syntaxTree) {
		// D M | M
		M(syntaxTree);
	}
	
	public void M (SyntaxTree syntaxTree) {
		// V S | S
		S(syntaxTree);
	}
	
	public void D (SyntaxTree syntaxTree) {
		// D1 ; D2 | Fid ( P ) : T = F | V
		
	}
	
	public void V (SyntaxTree syntaxTree) {
		// V1 ; V2 | Vid : T = L
		
	}
	
	public void T (SyntaxTree syntaxTree) {
		// Int | List
		
	}
	
	public void P (SyntaxTree syntaxTree) {
		// P1 Id : T | ε

	}
	
	public void F (SyntaxTree syntaxTree) {
		// V S return E | S return E | V return E | return E

	}
	
	public void S (SyntaxTree syntaxTree) {
		// S1 ; S2	| Vid = E | if E S | if E S1	else S2	|while E S | println E
		System.out.println("current: " + syntaxTree);
		if (syntaxTree.root().equals(";")) {
			S(syntaxTree.left());
			S(syntaxTree.middle());
		}
		else if (syntaxTree.root().equals("IF")) {
			if (E(syntaxTree.left())==1) {
				S(syntaxTree.middle());
			}
			else {
				if (syntaxTree.middle()!=null) {
					S(syntaxTree.middle());
				}
			}
		}
		else if (syntaxTree.root().equals("WHILE")) {
			// TODO examine this.
			if (E(syntaxTree.left())==1) {
				S(syntaxTree.middle());
				S(syntaxTree);
			}
		}
		else if (syntaxTree.root().equals("PRINTLN")) {
			// TODO implement outfile
		}
		else if (syntaxTree.root().equals("=")) {
			// TODO make the value on the left equal the variable on the right
			System.out.println(syntaxTree.left().left()+"="+E(syntaxTree.middle()));
			// store.update(syntaxTree.left().location(), E(syntaxTree.middle()));
		}
		else {
			ErrorMessage.print("PAAAANTS");
		}
	}
	
	public int E (SyntaxTree syntaxTree) {
		// TODO finish implementing E
		// E1 || E2	| E1 && E2 | E1 <E2 |E1 <=E2 |E1 >E2 |E1 >=E2 |E1 ==E2 |E1 !=E2 | +E | -E | E1 + E2 | E1 -E2 |E1 *E2 |E1 /E2 | E1 :: E2 | E.head | E.tail | E.isEmpty | Vid | Fid A | L
		if (syntaxTree.root().equals("||")) {
			// OR
			if (E(syntaxTree.left())==1||E(syntaxTree.middle())==1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (syntaxTree.root().equals("&&")) {
			// AND
			if (E(syntaxTree.left())==1&&E(syntaxTree.middle())==1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (syntaxTree.root().equals("ID")) {
			System.out.println("FOUND A FRAKKIN ID");
		}
		else {
			return L(syntaxTree);
		}
		return 0;
	}
	
	public void A (SyntaxTree syntaxTree) {
		// A E | ε

	}
	
	public int L (SyntaxTree syntaxTree) {
		// N | Nil
		if (syntaxTree.root().equals("NIL")) {
			return 0;
		}
		else {
			return Integer.parseInt(syntaxTree.root());
		}
	}
}

