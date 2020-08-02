package problem1.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.model.InvalidToDoItemParameterException;
import problem1.model.ToDoItem;

public class ToDoItemTest {
  ToDoItem toDoItem;
  ToDoItem toDoItem2;

  @Before
  public void setUp() throws Exception {
    toDoItem = new ToDoItem("1","Finish HW9","?","3/22/2020","1","school");
    toDoItem2 = new ToDoItem("2","Mail passport application, photo",null,"2/28/2020","?","?");
  }

  @Test (expected = InvalidToDoItemParameterException.class)
  public void constructorException() throws InvalidToDoItemParameterException{
    ToDoItem test = new ToDoItem("1","Finish HW9","1","3/22/2020","1","school");
  }

  @Test (expected = InvalidToDoItemParameterException.class)
  public void constructorException2() throws InvalidToDoItemParameterException{
    ToDoItem test = new ToDoItem("1","Finish HW9","true","test","1","school");
  }

  @Test (expected = InvalidToDoItemParameterException.class)
  public void constructorException5() throws InvalidToDoItemParameterException{
    ToDoItem test = new ToDoItem("1","Finish HW9","true","20191101","1","school");
  }

  @Test (expected = InvalidToDoItemParameterException.class)
  public void constructorException3() throws InvalidToDoItemParameterException{
    ToDoItem test = new ToDoItem("1","Finish HW9","true","3/22/2020","5","school");
  }

  @Test (expected = InvalidToDoItemParameterException.class)
  public void constructorException4() throws InvalidToDoItemParameterException{
    ToDoItem test = new ToDoItem("1","Finish HW9","true","1","test","school");
  }

  @Test
  public void getID() {
    assertEquals(Integer.valueOf(1), toDoItem.getID());
    assertEquals(Integer.valueOf(2), toDoItem2.getID());
  }

  @Test
  public void getText() {
    assertEquals("Finish HW9", toDoItem.getText());
  }

  @Test
  public void getDueDate() {
    assertEquals("3/22/2020", toDoItem.getDueDate());
  }

  @Test
  public void getCompleted() {
    assertFalse(toDoItem.getCompleted());
  }

  @Test
  public void getPriority() {
    assertEquals(Integer.valueOf(1), toDoItem.getPriority());

  }

  @Test
  public void getCategory() {
    assertEquals("school", toDoItem.getCategory());
  }

  @Test
  public void setCompleted() {
    toDoItem.setCompleted();
    assertTrue(toDoItem.getCompleted());
  }

  @Test
  public void testEquals() throws Exception{
    int a = 5;
    ToDoItem test = new ToDoItem("1","Finish HW9","false","3/22/2020","1","school");
    assertEquals(test, toDoItem);
    assertNotEquals(test, toDoItem2);
    assertEquals(test, test);
    assertNotEquals(a, test);
    assertNotEquals(a, toDoItem);
  }

  @Test
  public void testHashCode() throws Exception{
    ToDoItem test = new ToDoItem("2","Finish HW9","false","3/22/2020","1","school");
    int hc1 = test.hashCode();
    int hc2 = toDoItem.hashCode();
    assertEquals(test.hashCode(), hc1);
    assertEquals(toDoItem.hashCode(), hc2);
    assertEquals(hc1, hc1);
  }

  @Test
  public void testToString() {
    assertEquals("ToDoItem{ID=1, text='Finish HW9', dueDate='3/22/2020', completed=false, priority=1, category='school'}",toDoItem.toString());
  }
}