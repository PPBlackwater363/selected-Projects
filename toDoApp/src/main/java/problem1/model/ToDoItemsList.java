package problem1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import problem1.controller.SortedBy;

/**
 * Create a ToDoItemsList class to store ToDoItems.
 */
public class ToDoItemsList {
  private List<ToDoItem> toDoItems;
  private String storagePath;

  /**
   * Construct a new ToDoItemsList.
   */
  public ToDoItemsList() {
  }

  /**
   * Build a ToDoItemsList by given input.
   * @param toDoItemsFile - a string of toDoItems.
   * @return - a new ToDoItemsList class.
   */
  public static ToDoItemsList buildToDoItemsList(String toDoItemsFile) {
    ToDoItemsList toDoItemsList = new ToDoItemsList();
    toDoItemsList.toDoItems = ToDoItemReader.ReadToDoItemFromFile(toDoItemsFile);
    toDoItemsList.storagePath = toDoItemsFile;
    return toDoItemsList;
  }

  /**
   * Generate new id of the item.
   * @return - the new ID of the item.
   */
  public Integer generateNewItemID() {
    return toDoItems.size() + 1;
  }

  /**
   * Add new item to the list.
   * @param item - the item needed to be added.
   */
  public void addItem(ToDoItem item) {
    this.toDoItems.add(item);
  }

  /**
   * Complete the item which has the same id.
   * @param ID - the id number of the item which is needed to be completed.
   */
  public void completeItem(Integer ID) {
    // find the item
    for (ToDoItem item : this.toDoItems) {
      if (ID.equals(item.getID()))
        item.setCompleted();
    }
  }

  /**
   * Get the list of ToDoItems.
   * @return - the list of ToDoItems.
   */
  public List<ToDoItem> getToDoItems() {
    return this.toDoItems;
  }

  /**
   * Sort the list by input info.
   * @param sortBy - the type of sort.
   * @return - a sorted list of items.
   */
  public ToDoItemsList sortItemsBy(SortedBy sortBy) {
    if (sortBy == SortedBy.None)
      return this;

    ToDoItemsList sortedList = this.clone();
    Comparator<ToDoItem> comparator;
    if (sortBy == SortedBy.Priority) {
      comparator = new Comparator<ToDoItem>() {
        public int compare(ToDoItem lhs, ToDoItem rhs) {
          Integer p1 = lhs.getPriority();
          Integer p2 = rhs.getPriority();
          if (p1 == p2)
            return 0;
          if (p1 == null)
            return 1;
          if (p2 == null)
            return -1;
          return lhs.getPriority() < rhs.getPriority() ? -1 : 1;
        }
      };
    } else {
      comparator = new Comparator<ToDoItem>() {
        public int compare(ToDoItem lhs, ToDoItem rhs) {
          String d1 = lhs.getDueDate();
          String d2 = rhs.getDueDate();
          if (d1 == d2)
            return 0;
          if (d1 == null)
            return 1;
          if (d2 == null)
            return -1;
          return lhs.getDueDate().compareTo(rhs.getDueDate());
        }
      };
    }

    Collections.sort(sortedList.toDoItems, comparator);
    return sortedList;
  }

  /**
   * Build a list with all in-completed items.
   * @param filterByIncomplete - a boolean value to determine if to do the sort.
   * @return - a new list of items.
   */
  public ToDoItemsList filterItemsByIncomplete(Boolean filterByIncomplete /* false means filter by incomplete*/) {
    if (filterByIncomplete == null)
      return this;

    ToDoItemsList filteredList = this.clone();
    if (filterByIncomplete)
      filteredList.toDoItems.removeIf(toDoItem -> toDoItem.getCompleted());

    return filteredList;
  }

  /**
   * Build a list with all items with given category.
   * @param category - the category needed to be returned.
   * @return - a new list of items.
   */
  public ToDoItemsList filterItemsByCategory(String category) {
    if (category == null)
      return this;

    ToDoItemsList filteredList = this.clone();
    filteredList.toDoItems.removeIf(toDoItem -> !category.equals(toDoItem.getCategory()));

    return filteredList;
  }

  /**
   * call writer to write the list back to file.
   */
  public void storeToDoItemsList() {
    ToDoItemWriter.WriteToLocalStorage(this.storagePath, this);
  }

  /**
   * Override the clone method to copy the ToDoItemList.
   * @return - new cloned ToDoItemsList.
   */
  @Override
  protected ToDoItemsList clone() {
    ToDoItemsList newList = new ToDoItemsList();
    newList.storagePath = this.storagePath;
    newList.toDoItems = new ArrayList<>(this.toDoItems);
    return newList;
  }
}
