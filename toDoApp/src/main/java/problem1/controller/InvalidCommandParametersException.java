package problem1.controller;

/**
 * Creates InvalidToDoItemParameterException.
 */
public class InvalidCommandParametersException extends Exception {

  /**
   * Constructs a new exception with msg as its detailed message.
   * @param msg - The detailed message caused the exception.
   */
  public InvalidCommandParametersException(String msg) {
    super(msg);
  }
}
