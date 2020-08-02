package problem1.controller;

import java.util.Objects;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;

/**
 * Build an AddCommand to store information and to be executed.
 */
public class AddCommand extends Command{

  private ToDoItem toDoItem;
  private ToDoItemsList toDoItemsList;

  /**
   * Construct an AddCommand by given input.
   * @param parameters - an AddCommandParameter which containing information to be added.
   */
  public AddCommand(AddCommandParameters parameters) {
    this.toDoItem = parameters.getToDoItem();
    this.toDoItemsList = parameters.getToDoItemsList();
  }

  /**
   * Execute the add function by calling function from toDoItemsList.
   */
  @Override
  public void Execute() {
    // need to call add function to write a file
    this.toDoItemsList.addItem(this.toDoItem);
    this.toDoItemsList.storeToDoItemsList();
  }

  /**
   * Create an equals method should return true if and only if two AddCommand
   * have same given fields.
   *
   * @param o - an object o
   * @return - true if the two two PhoneValidator have same fields,
   * return false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AddCommand)) {
      return false;
    }
    AddCommand that = (AddCommand) o;
    return Objects.equals(this.toDoItem, that.toDoItem) &&
        Objects.equals(this.toDoItemsList, that.toDoItemsList);
  }

  /**
   * Create a hashCode method of AddCommand.
   * @return a result of hashCode, expressed as an int.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.toDoItem);
  }

  /**
   * Create a toString method of AddCommand.
   * @return the string expression of AddCommand.
   */
  @Override
  public String toString() {
    return "AddCommand{" +
        "toDoItem=" + this.toDoItem +
        ", toDoItemsList='" + this.toDoItemsList + '\'' +
        '}';
  }
}
