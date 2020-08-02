package problem1.controller;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;
import problem1.view.CmdParser;

public class DisplayCommandTest {

  ToDoItem toDoItem;
  ToDoItem toDoItem2;
  List<ToDoItem> list;
  DisplayCommand displayCommand;
  private DisplayCommandParameters test;
  private List<CmdOption> input;
  ToDoItemsList toDoItemsList;
  String testFilePath = "todostest22.csv";

  @Before
  public void setUp() throws Exception {
    toDoItem = new ToDoItem("1","Finish HW9","?","3/22/2020","1","school");
    toDoItem2 = new ToDoItem("2","Mail passport application, photo",null,"2/28/2020","?","?");
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-category", "work"};
    CmdParser parser = new CmdParser(args);
    input = parser.getCmdList();
    test = new DisplayCommandParameters(input);
    toDoItemsList = toDoItemsList.buildToDoItemsList(testFilePath);
    toDoItemsList.addItem(toDoItem);
    toDoItemsList.addItem(toDoItem2);
    displayCommand = new DisplayCommand(test, toDoItemsList);
  }

  @Test
  public void execute() {
    displayCommand.Execute();
  }

  @Test
  public void testEquals() {
    assertTrue(displayCommand.equals(displayCommand));
    assertFalse(displayCommand.equals(null));
  }

  @Test
  public void testHashCode() {
    assertNotEquals(test.hashCode(), displayCommand.hashCode());
    assertEquals(displayCommand.hashCode(), displayCommand.hashCode());
  }

  @Test
  public void testToString() {
    System.out.println(displayCommand.toString());
  }
}