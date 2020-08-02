package problem1.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a ToDoItemReader class to get ToDoItems from given csv file.
 */
public class ToDoItemReader {

  /**
   * Generate a list of ToDoItem by given info.
   * @param filePath - the file needed to be read.
   * @return - a list of ToDoItems.
   */
  public static List<ToDoItem> ReadToDoItemFromFile(String filePath) {
    FileReader inputFile = null;
    List<ToDoItem> toDoItems = new ArrayList<>();

    try {
      inputFile = new FileReader(filePath);
      String line;
      BufferedReader bufferedReader = new BufferedReader(inputFile);
      bufferedReader.readLine(); //skip the column schema
      while ((line = bufferedReader.readLine()) != null) {
        toDoItems.add(parseToDoItemString(line));
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("A file was not found: " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Something went wrong :" + ioe.getMessage());
    } catch (InvalidToDoItemParameterException e) {
      System.out.println(e.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream");
        }
      }
    }
    return toDoItems;
  }

  /**
   * Parse input string of ToDoItem.
   * @param toDoItemStr - the string of the todoItem.
   * @return - new ToDoItem with formatted information.
   * @throws InvalidToDoItemParameterException - if the input is not valid.
   */
  private static ToDoItem parseToDoItemString(String toDoItemStr)
      throws InvalidToDoItemParameterException {
    // get rid of the first and last quotes and store a new String in subToDoItemStr
    String subToDoItemStr = toDoItemStr.substring(1, toDoItemStr.length() - 1);
    String[] toDoItemTokens = subToDoItemStr.split("\",\"");
    if (toDoItemTokens.length != 6) {
      throw new InvalidToDoItemParameterException("Invalid ToDoItem Parameters Numbers");
    }
    String ID = toDoItemTokens[0];
    String text = toDoItemTokens[1];
    String completed = toDoItemTokens[2];
    String dueDate = toDoItemTokens[3];
    String priority = toDoItemTokens[4];
    String category = toDoItemTokens[5];
    ToDoItem toDoItem = new ToDoItem(ID, text, completed, dueDate, priority, category);
    return toDoItem;
  }
}