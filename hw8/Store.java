// Store.java

// Store is a class to model the memory store of MicroScala programs.

public class Store {

  protected int display [];
  private final int maxStackSize = 1000;
  protected int mainProgSize;
  protected int stackPointer;
  protected int word [];

  public static final int UNDEFINED = -32768;

  public Store (int numStackFrames, int mainProgSize) {
    display = new int [numStackFrames];
    word = new int [maxStackSize];
    this . mainProgSize = mainProgSize;
    stackPointer = 0;
  }

  public void createStackFrame (Location maxLoc) {
    // save current display stack pointer
    word [stackPointer++] = display [maxLoc . stackFrame ()]; 
    // set new display stack pointer and stack frame
    display [maxLoc . stackFrame ()] = stackPointer;
    stackPointer = stackPointer + maxLoc . offset ();
    for (int i = display [maxLoc . stackFrame ()] = stackPointer; 
         i < stackPointer;
         i++)
      word [i] = UNDEFINED;
  }

  public void restoreStackFrame (Location maxLoc) {
    stackPointer = stackPointer - maxLoc . offset ();
    // restore current display stack pointer
    display [maxLoc . stackFrame ()] = stackPointer--;
  }

  public int access (Location location) { 
    return word [display [location . stackFrame ()] + location . offset ()]; 
  }

  public void update (Location location, int n) { 
    word [display [location . stackFrame ()] + location . offset ()] = n; } 

  public String toString () {
    String printString = "";
    printString = printString + "Current Memory Store\n";
    printString = printString + "--------------------\n";
    printString = printString + "\n";
    printString = printString + "Location               Value\n";
    printString = printString + "--------               -----\n";
    for (int i = 0; i < Math . max (stackPointer, mainProgSize); i++) {
      if (i < 10) 
	printString = printString + "    ";
      else if (i < 100)
	printString = printString + "   "; 
      else if (i < 1000)
        printString = printString + "  ";
      else
        printString = printString + " ";
      printString = printString + i + "                  ";
      if (word [i] < 10) 
        printString = printString + "    ";
      else if (word [i] < 100)
        printString = printString + "   "; 
      else if (word [i] < 1000) 
        printString = printString + "  ";
      else 
        printString = printString + " ";
      printString = printString + word [i] + "\n";
    }
    return printString;
  }
  
}
