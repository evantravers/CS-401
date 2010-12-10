import java.util.*;
// Interpreter.java
// etravers@uab.edu CS 401

// Interpreter is a class to represent an interpreter for the MicroScala programming 
// language. It works by traversing the syntax tree constructed by the parser.

public class Interpreter {
    protected static Environment global;
	protected SyntaxTree tree;
	protected ArrayList<Integer> out = new ArrayList<Integer>();

	public Interpreter (Environment env) {
	    global = env;
	    FunctionDenot tmp = (FunctionDenot)global.access("main");
	    Environment store = tmp.environment();
	    tree = tmp.functionBody();
	    // run the interpreter
	    //System.out.println("BEFORE");
        //store.print("main");
	    C(tree, store);
	    
	    store.print("main");
	    System.out.println("===OUTFILE===");
	    System.out.println(out+"\n");
	}

	public void C (SyntaxTree tree, Environment store) {
		// D M | M
		M(tree, store);
	}
	
	public void M (SyntaxTree tree, Environment store) {
		// V S | S
		S(tree, store);
	}
	
	public void P (SyntaxTree tree, ArrayList<String> params, String name, Environment src, Environment dest) {
		// P1 Id : T | ε
		// get the parameter list from the store
        if (tree.root().equals(",")) {
            String tmp = params.get(0);
            Object val = E(tree.left(), src);
            // System.out.println(val);
            Type type;
			if (val instanceof ArrayList) {
			    type = new Type(Type.LIST);
			}
			else {
			    type = new Type(Type.INTEGER);
			}
			// System.out.println("updating " + tmp +" with " + tree.left() + "'s " + val);
			dest.updateVal(tmp, new ExpressibleValue(type, val));
			
			if (tree.middle()!=null) {
			    tmp = params.get(1);
                val = E(tree.middle(), src);
                // System.out.println(val);
    			if (val instanceof ArrayList) {
    			    type = new Type(Type.LIST);
    			}
    			else {
    			    type = new Type(Type.INTEGER);
    			}
                // System.out.println("updating " + tmp +" with " + tree.middle() + "'s " + val);
                dest.updateVal(tmp, new ExpressibleValue(type, val));
			}            
            // store.updateVal(name, new ExpressibleValue(new Type(Type.INTEGER), tmp));
        }
        else {
            String tmp = params.get(0);
            Object val = E(tree, src);
            Type type;
			if (val instanceof ArrayList) {
			    type = new Type(Type.LIST);
			}
			else {
			    type = new Type(Type.INTEGER);
			}
			// System.out.println("updating " + tmp +" with " + tree.left() + "'s " + val);
			dest.updateVal(tmp, new ExpressibleValue(type, val));
        }
	}
	
	public Object F (SyntaxTree tree, Environment store) {
		// V S return E | S return E | V return E | return E
        S(tree.left(), store);
        if (tree.middle().root().equals("return")) {
            return E(tree.middle().left(), store);
        }
        else {
            return 0;
        }
	}
	
	public void S (SyntaxTree tree, Environment store) {
		// S1 ; S2	| Vid = E | if E S | if E S1 else S2 |while E S | println E
        // store.print("main");
        // System.out.println(tree);
		if (tree.root().equals(";")) {
			S(tree.left(), store);
			S(tree.middle(), store);
		}
		else if (tree.root().equals("if")) {
			if ((Integer)E(tree.left(), store)==1) {
				S(tree.middle(), store);
			}
			else {
				if (tree.right()!=null) {
					S(tree.right(), store);
				}
			}
		}
		else if (tree.root().equals("while")) {
			// TODO examine this.
			if ((Integer)E(tree.left(), store)==1) {
				S(tree.middle(), store);
				S(tree, store);
			}
		}
		else if (tree.root().equals("println")) {
			// TODO implement outfile
			out.add((Integer)E(tree.left(), store));
		}
		else if (tree.root().equals("=")) {
			// TODO make the value on the left equal the variable on the right
			// System.out.println(tree.left() + " ~ " + tree.middle());
			// need to check to see if it's local, then global
			if (store.access(tree.left().root())!=null) {
                Type type;
    			Object tmp = E(tree.middle(), store);
    			if (tmp instanceof ArrayList) {
    			    type = new Type(Type.LIST);
    			}
    			else {
    			    type = new Type(Type.INTEGER);
    			}
                store.updateVal(tree.left().root(), new ExpressibleValue(type, tmp));
			}
			else {
			    if (global.access(tree.left().root())!=null) {
                    Type type;
        			Object tmp = E(tree.middle(), global);
        			if (tmp instanceof ArrayList) {
        			    type = new Type(Type.LIST);
        			}
        			else {
        			    type = new Type(Type.INTEGER);
        			}
                    global.updateVal(tree.left().root(), new ExpressibleValue(type, tmp));
                    // store.print("main");
                    
    			}
                Type type;
    			Object tmp = E(tree.middle(), store);
    			if (tmp instanceof ArrayList) {
    			    type = new Type(Type.LIST);
    			}
    			else {
    			    type = new Type(Type.INTEGER);
    			}
                store.update(tree.left().root(), new ExpressibleValue(type, tmp));
			}
		}
	}
	
	public Object E (SyntaxTree tree, Environment store) {
		// TODO finish implementing E
		// E1 || E2	| E1 && E2 | E1 <E2 |E1 <=E2 |E1 >E2 |E1 >=E2 |E1 ==E2 |E1 !=E2 | +E | -E | E1 + E2 | E1 -E2 |E1 *E2 |E1 /E2 | E1 :: E2 | E.head | E.tail | E.isEmpty | Vid | Fid A | L
		if (tree.root().equals("||")) {
			// OR
			if ((Integer)E(tree.left(), store)==1||(Integer)E(tree.middle(), store)==1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("&&")) {
			// AND
			if ((Integer)E(tree.left(), store)==1&&(Integer)E(tree.middle(), store)==1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("==")) {
			if ((Integer)E(tree.left(), store)==(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("!")) {
		    if ((Integer)E(tree.left(), store)==1) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if (tree.root().equals("!=")) {
			if ((Integer)E(tree.left(), store)!=(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals(">=")) {
			if ((Integer)E(tree.left(), store)>=(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("<=")) {
			if ((Integer)E(tree.left(), store)<=(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals(">")) {
			if ((Integer)E(tree.left(), store)>(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("<")) {
			if ((Integer)E(tree.left(), store)<(Integer)E(tree.middle(), store)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (tree.root().equals("+")) {
			return (Integer)E(tree.left(), store) + (Integer)E(tree.middle(), store);
		}
		else if (tree.root().equals("-")) {
			return (Integer)E(tree.left(), store) - (Integer)E(tree.middle(), store);
		}
		else if (tree.root().equals("*")) {
			return (Integer)E(tree.left(), store) * (Integer)E(tree.middle(), store);
		}
		else if (tree.root().equals("/")) {
			return (Integer)E(tree.left(), store) / (Integer)E(tree.middle(), store);
		}
		else if (tree.root().equals("::")) {
		    // get the two items, if one isn't a list, make it a list, and combine the two.
		    ArrayList<Integer> a, b;
            if (E(tree.left(), store) instanceof ArrayList) {
                a = (ArrayList)E(tree.left(), store);
            }
            else {
                a = new ArrayList<Integer>();
                a.add((Integer)E(tree.left(), store));
            }
            if (E(tree.middle(), store) instanceof ArrayList) {
                b = (ArrayList)E(tree.middle(), store);
            }
            else {
                b = new ArrayList<Integer>();
                b.add((Integer)E(tree.middle(), store));
            }
            ArrayList<Integer> c = new ArrayList<Integer>();
            // System.arraycopy(a, 0, c, 0, a.length-1);
            //             System.arraycopy(b, 0, c, a.length-1, c.length-1);
            c.addAll(a);
            c.addAll(b);
            // System.out.println("a::b = " + c);
            return c;
		}
		else if (tree.root().equals("head")) {
		    // System.out.println("what did we find " + E(tree.left()));
		    ArrayList<Integer> tmp = (ArrayList) E(tree.left(), store);
		    Object x=tmp.get(0);
		    // System.out.println("HEAD: " + x);
		    return x;
		}
		else if (tree.root().equals("tail")) {
		    ArrayList<Integer> tmp = (ArrayList) E(tree.left(), store);
		    tmp.remove(0);
		    // System.out.println("TAIL: " + tmp);
		    return tmp;
		}
		else if (tree.root().equals("isEmpty")) {
		    ExpressibleValue tmp = (ExpressibleValue)store.access(tree.root());
		    if (tmp==null) {
		        return 1;
		    }
		    else {
		        return 0;
		    }
		}
		else if (tree.root().equals("apply")) {
		    // time to run a program
		    String funcID = tree.left().root();
		    FunctionDenot tmp = (FunctionDenot)global.access(funcID);
		    
		    // get all the parts out of it
		    ArrayList<String> params = tmp.parameterList();
		    SyntaxTree varTree = tmp.functionBody();
		    Environment varStore = tmp.environment();
		    Type varType = tmp.type();
            P(tree.middle(), params, funcID, store, varStore);
            // TODO might need to disable this
            // global.updateVal(funcID, new FunctionDenot(params, varType, varStore, varTree));
            
		    // need to update the varStore with the values it intends to use. 
		    Object result = F(varTree, varStore);
		    return result;
		}
		else if (tree.root().matches("[_[a-zA-Z]]+.*")) {
            // System.out.println("ID finds this: " + tree.varLoc());
            ExpressibleValue tmp = (ExpressibleValue)store.access(tree.root());
            if (tmp!=null) {
    			return tmp.value();
            }
            else {
                // try the global
                tmp = (ExpressibleValue)global.access(tree.root());
                if (tmp!=null) {
        			return tmp.value();
                }
                else {
                    return 0;
                }
            }
		}
		else {
			return L(tree, store);
		}
	}
	
	public void A (SyntaxTree tree, Environment store) {
		// A E | ε
        if (tree.root().equals("arg")) {
            
        }
	}
	
	public int L (SyntaxTree tree, Environment store) {
		// N | Nil
		if (tree.root().equals("nil")) {
			return 0;
		}
		else {
			return Integer.parseInt(tree.root().toString());
		}
	}
}

