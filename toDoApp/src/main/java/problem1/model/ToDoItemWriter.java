package problem1.model;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Build a ToDoItemWriter class to write new file and save it.
 */
public class ToDoItemWriter {

  /**
   * A method to write a new local file with given info.
   * @param filePath - the path used to store csv file.
   * @param toDoItems - the list containing information which is needed to be written.
   */
  public static void WriteToLocalStorage(String filePath, ToDoItemsList toDoItems) {
    StringBuffer inputBuffer = new StringBuffer();
    final String header = "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"\n";
    inputBuffer.append(header);

    String line;
    for (ToDoItem toDoItem : toDoItems.getToDoItems()) {
      line = String.format(
          "\"%d\",\"%s\",\"%b\",\"%s\",\"%s\",\"%s\"",
          toDoItem.getID(),
          toDoItem.getText(),
          toDoItem.getCompleted(),
          toDoItem.getDueDate() == null ? "?" : toDoItem.getDueDate(),
          toDoItem.getPriority() == null ? "?" : Integer.toString(toDoItem.getPriority()),
          toDoItem.getCategory() == null ? "?" : toDoItem.getCategory());
      inputBuffer.append(line + "\n");
    }

    try {
      FileOutputStream fileOut = new FileOutputStream(filePath);
      fileOut.write(inputBuffer.toString().getBytes());
      fileOut.close();
    } catch (Exception e) {
      System.out.println("Failed to write result to file.");
    }
  }

}
