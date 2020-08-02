package problem1.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import problem1.controller.SortedBy;

public class ToDoItemsListTest {
  ToDoItem newItem;
  ToDoItem toDoItem2;
  List<ToDoItem> list;

  ToDoItemsList testTodoItemList;
  ToDoItemsList copy;

  @Before
  public void setUp() throws Exception {
    newItem = new ToDoItem("1","a new task!","false","3/22/2020","1","school");

    // list made equal to the content in test todos.csv
    list = new ArrayList<>();
    list.add(new ToDoItem("1","Finish HW9","false","3/22/2020","1","school"));
    list.add(new ToDoItem("2","Mail passport","true","2/28/2020","?","?"));
    list.add(new ToDoItem("3","Study for finals","false","?","2","school"));
    list.add(new ToDoItem("4","Clean the house","false","3/22/2020","3","home"));
    list.add(new ToDoItem("5","Buy yarn for blanket, stuffed toy","true","?","?","home"));

    testTodoItemList = ToDoItemsList.buildToDoItemsList("todos.csv");
    copy =ToDoItemsList.buildToDoItemsList("todos.csv");
  }

  @After
  public void cleanUp() throws Exception {
    copy.storeToDoItemsList();
  }



  @Test
  public void generateNewItemID() {
    // test csv contain 5 items
    Integer expected = 6;
    assertEquals(expected, testTodoItemList.generateNewItemID());
  }

  @Test
  public void getToDoItems() {
    assertEquals(testTodoItemList.getToDoItems(), list);
  }

  @Test
  public void addItem() {
    testTodoItemList.addItem(newItem);
    list.add(newItem);
    assertEquals(testTodoItemList.getToDoItems(), list);
  }

  @Test
  public void completeItem() {
    testTodoItemList.completeItem(1);
    assertNotEquals(testTodoItemList.getToDoItems(), list);
    list.get(0).setCompleted();
    assertEquals(testTodoItemList.getToDoItems(), list);
  }

  @Test
  public void sortItemsByDate() throws InvalidToDoItemParameterException {
    list = new ArrayList<>();
    list.add(new ToDoItem("2","Mail passport","true","2/28/2020","?","?"));
    list.add(new ToDoItem("1","Finish HW9","false","3/22/2020","1","school"));
    list.add(new ToDoItem("4","Clean the house","false","3/22/2020","3","home"));
    list.add(new ToDoItem("3","Study for finals","false","?","2","school"));
    list.add(new ToDoItem("5","Buy yarn for blanket, stuffed toy","true","?","?","home"));

    List<ToDoItem> actualList = testTodoItemList.sortItemsBy(SortedBy.Date).getToDoItems();
    assertEquals(list, actualList);
  }

  @Test
  public void sortItemsByPriority() throws InvalidToDoItemParameterException {
    list = new ArrayList<>();
    list.add(new ToDoItem("1","Finish HW9","false","3/22/2020","1","school"));
    list.add(new ToDoItem("3","Study for finals","false","?","2","school"));
    list.add(new ToDoItem("4","Clean the house","false","3/22/2020","3","home"));
    list.add(new ToDoItem("2","Mail passport","true","2/28/2020","?","?"));
    list.add(new ToDoItem("5","Buy yarn for blanket, stuffed toy","true","?","?","home"));

    List<ToDoItem> actualList = testTodoItemList.sortItemsBy(SortedBy.Priority).getToDoItems();
    assertEquals(list, actualList);
  }

  @Test
  public void filterItemsByIncomplete() throws Exception{
    list = new ArrayList<>();
    list.add(new ToDoItem("1","Finish HW9","false","3/22/2020","1","school"));
    list.add(new ToDoItem("3","Study for finals","false","?","2","school"));
    list.add(new ToDoItem("4","Clean the house","false","3/22/2020","3","home"));

    List<ToDoItem> actualList = testTodoItemList.filterItemsByIncomplete(true).getToDoItems();
    assertEquals(list, actualList);

  }

  @Test
  public void filterItemsByCategory() throws Exception{
    list = new ArrayList<>();
    list.add(new ToDoItem("1","Finish HW9","false","3/22/2020","1","school"));
    list.add(new ToDoItem("3","Study for finals","false","?","2","school"));
    List<ToDoItem> actualList = testTodoItemList.filterItemsByCategory("school").getToDoItems();
    assertEquals(list, actualList);
  }

  @Test
  public void testClone() {
    ToDoItemsList cloned = testTodoItemList.clone();
    assertEquals(cloned.getToDoItems(), testTodoItemList.getToDoItems());
    assertFalse(cloned == testTodoItemList);
  }
}
