package problem1.controller;

import java.util.Objects;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;

/**
 * Create a DisplayCommand class to store information about display option.
 */
public class DisplayCommand extends Command {
  private Boolean showIncomplete;
  private String showCategory;
  private SortedBy sortedBy;
  private ToDoItemsList toDoItems;

  /**
   * Build a displayCommand by given info.
   * @param parameters - the DisplayCommandParameter containing information about display.
   * @param toDoItems - the list of todoItems.
   */
  public DisplayCommand(DisplayCommandParameters parameters, ToDoItemsList toDoItems) {
    this.showIncomplete = parameters.getShowIncomplete() == null ? false : parameters.getShowIncomplete();
    this.showCategory = parameters.getShowCategory() == null ? null : parameters.getShowCategory();
    this.sortedBy = parameters.getSortedBy() == null ? SortedBy.None : parameters.getSortedBy();
    this.toDoItems = toDoItems;
  }

  /**
   * Execute the completing function by calling function from ToDoItemsList.
   */
  @Override
  public void Execute() {
    ToDoItemsList itemsToDisplay = toDoItems.filterItemsByIncomplete(showIncomplete).filterItemsByCategory(showCategory).sortItemsBy(sortedBy);

    System.out.println(this.getSchemaString());
    for (ToDoItem item : itemsToDisplay.getToDoItems()) {
      System.out.println(ConvertToDoItemToFormattedString(item));
    }
  }

  /**
   * Formatting the output string.
   * @return - a formatted string.
   */
  private String getSchemaString() {
    return String.format("%5s %50s %15s %20s %15s %15s", "ID", "Text", "Completed", "Due Date", "Priority", "Category");
  }

  /**
   * Convert ToDoItem to formatted string.
   * @param item - the ToDoItem needed to be converted.
   * @return - a formatted string of the item.
   */
  private String ConvertToDoItemToFormattedString(ToDoItem item) {
    return String.format("%5s %50s %15s %20s %15s %15s", item.getID(), item.getText(), item.getCompleted(), item.getDueDate(), item.getPriority(), item.getCategory());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DisplayCommand)) {
      return false;
    }
    DisplayCommand that = (DisplayCommand) o;
    return showIncomplete.equals(that.showIncomplete) &&
        showCategory.equals(that.showCategory) &&
        sortedBy == that.sortedBy &&
        toDoItems.equals(that.toDoItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(showIncomplete, showCategory, sortedBy, toDoItems);
  }

  @Override
  public String toString() {
    return "DisplayCommand{" +
        "showIncomplete=" + showIncomplete +
        ", showCategory='" + showCategory + '\'' +
        ", sortedBy=" + sortedBy +
        ", toDoItems=" + toDoItems +
        '}';
  }
}
