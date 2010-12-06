public class Location
{
  private int stackFrame;
  private int offset;
  private static int mainProgSize = 0;
  private static int maxStackFrame = 0;

  public Location() { this(0, 0); }

  public Location(int paramInt1, int paramInt2) {
    this.stackFrame = paramInt1;
    this.offset = paramInt2;
  }
  public int stackFrame() {
    return this.stackFrame;
  }
  public int offset() { return this.offset; } 
  public static int mainProgSize() {
    return mainProgSize;
  }
  public static int stackFrameSize() { return maxStackFrame + 1; }

  public Location nextLocation() {
    Location localLocation = new Location(this.stackFrame, this.offset);
    this.offset += 1;
    if (this.stackFrame == 0)
      mainProgSize = this.offset;
    return localLocation;
  }

  public Location nextStackFrame() {
    this.stackFrame += 1;
    if (this.stackFrame > maxStackFrame)
      maxStackFrame = this.stackFrame;
    return new Location(this.stackFrame, 0);
  }

  public String toString() {
    return this.stackFrame + ", " + this.offset;
  }
}