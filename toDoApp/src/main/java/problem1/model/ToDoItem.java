package problem1.model;

import java.util.Objects;
import java.text.SimpleDateFormat;

/**
 * Create a ToDoItem class to store information from command line.
 */
public class ToDoItem {
  private Integer ID;
  private String text;
  private String dueDate;
  private Boolean completed;
  private Integer priority;
  private String category;

  /**
   * Construct a ToDoItem by given information.
   * @param ID - the ID of the item.
   * @param text - the text of the item.
   * @param completed - the completed value of the item.
   * @param dueDate - the duedate of the item.
   * @param priority - the priority of the item.
   * @param category - the category of the item.
   * @throws InvalidToDoItemParameterException - if the input is not valid.
   */
  public ToDoItem(String ID, String text, String completed, String dueDate, String priority, String category)
      throws InvalidToDoItemParameterException {
    this.ID = Integer.valueOf(ID); //  this will throw exception if ID is not Integer

    this.text = text;

    if (!isCompleteStatusValid(completed))
      throw new InvalidToDoItemParameterException("Invalid completed status!");
    this.completed = completed == null || "?".equals(completed) ?
        false : Boolean.parseBoolean(completed);

    if (!isDueDateValid(dueDate))
      throw new InvalidToDoItemParameterException("Invalid due date!");
    this.dueDate = "?".equals(dueDate) ? null : dueDate;


    if (!isPriorityValid(priority))
      throw new InvalidToDoItemParameterException("Invalid priority!");
    this.priority = priority == null || "?".equals(priority) ? null : Integer.valueOf(priority);

    this.category = category == null || "?".equals(category) ? null : category;
  }

  /**
   * Helper function to check if the input due date is valid.
   * @param dueDate - the input due date.
   * @return - true if the due date is valid.
   */
  private Boolean isDueDateValid(String dueDate) {
    if (dueDate == null || "?".equals(dueDate))
      return true;
    SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
    sdf.setLenient(false);
    try {
      //if not valid, it will throw ParseException
      sdf.parse(dueDate);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Helper function to check if the item has been completed.
   * @param completedStatus - the input info of the item.
   * @return - true if the input item has been completed.
   */
  private Boolean isCompleteStatusValid(String completedStatus) {
    if (completedStatus == null || "?".equals(completedStatus))
      return true;

    if (completedStatus.toLowerCase().equals("true")
        || completedStatus.toLowerCase().equals("false"))
      return true;

    return false;
  }

  /**
   * Helper function to check if the priority info is valid.
   * @param priority - the priority info of the item.
   * @return - true if the info is valid.
   */
  private Boolean isPriorityValid(String priority) {
    if (priority == null || "?".equals(priority))
      return true;

    if (Integer.valueOf(priority).equals(1) || Integer.valueOf(priority).equals(2)
        || Integer.valueOf(priority).equals(3))
      return true;

    return false;
  }

  /**
   * Get the ID of the item.
   * @return - the ID of the item.
   */
  public Integer getID() {
    return ID;
  }

  /**
   * Get the text of the item.
   * @return - the text of the item.
   */
  public String getText() {
    return text;
  }

  /**
   * Get due date of the item.
   * @return - the due date of the item.
   */
  public String getDueDate() {
    return dueDate;
  }

  /**
   * Get the value of if the item has been completed.
   * @return - true if the item has been completed.
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Get the priority of the item.
   * @return - the priority of the item.
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Get the category of the item.
   * @return - the category of the item.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Set the completed condition of the item.
   */
  public void setCompleted() {
    this.completed = true; //  this can only be mark as completed which means "true"
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ToDoItem)) {
      return false;
    }
    ToDoItem toDoItem = (ToDoItem) o;
    return Objects.equals(ID, toDoItem.ID) &&
        Objects.equals(text, toDoItem.text) &&
        Objects.equals(dueDate, toDoItem.dueDate) &&
        Objects.equals(completed, toDoItem.completed) &&
        Objects.equals(priority, toDoItem.priority) &&
        Objects.equals(category, toDoItem.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, text, dueDate, completed, priority, category);
  }

  @Override
  public String toString() {
    return "ToDoItem{" +
        "ID=" + ID +
        ", text='" + text + '\'' +
        ", dueDate='" + dueDate + '\'' +
        ", completed=" + completed +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
  }
}
