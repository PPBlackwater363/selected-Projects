package problem1.controller;

import java.util.Objects;
import problem1.model.ToDoItemsList;

/**
 * Create a CompleteCommand class to store information about complete option.
 */
public class CompleteCommand extends Command {

  private Integer ID;
  private ToDoItemsList toDoItems;

  /**
   * Build CompleteCommand by given input.
   * @param parameters - a CompleteCommandParameters storing information about completing.
   * @param toDoItems - a list of toDoItems which is needed to be updated.
   */
  public CompleteCommand(CompleteCommandParameters parameters, ToDoItemsList toDoItems) {
    this.ID = parameters.getID();
    this.toDoItems = toDoItems;
  }

  /**
   * Execute the completing function by calling function from ToDoItemsList.
   */
  @Override
  public void Execute() {
    this.toDoItems.completeItem(this.ID);
    this.toDoItems.storeToDoItemsList();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CompleteCommand)) {
      return false;
    }
    CompleteCommand that = (CompleteCommand) o;
    return ID.equals(that.ID) &&
        toDoItems.equals(that.toDoItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, toDoItems);
  }

  @Override
  public String toString() {
    return "CompleteCommand{" +
        "ID=" + ID +
        ", toDoItems=" + toDoItems +
        '}';
  }
}
