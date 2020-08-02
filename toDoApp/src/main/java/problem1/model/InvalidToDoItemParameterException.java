package problem1.model;

/**
 * Creates InvalidToDoItemParameterException.
 */
public class InvalidToDoItemParameterException extends Exception {

  /**
   * Constructs a new exception with msg as its detailed message.
   * @param msg - The detailed message caused the exception.
   */
  public InvalidToDoItemParameterException(String msg) {
    super(msg);
  }
}
