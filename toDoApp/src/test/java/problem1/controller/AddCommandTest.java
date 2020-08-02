package problem1.controller;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;
import problem1.view.CmdParser;

public class AddCommandTest {
  private AddCommand test;
  private AddCommandParameters addCommandParameters;
  private List<CmdOption> input;
  private ToDoItemsList list;

  @Before
  public void setUp() throws Exception {
    String[] args = {"--csv-file", "addcmdtest2.csv", "--add-todo",
        "--todo-text", "running exercises"};
    CmdParser parser = new CmdParser(args);
    input = parser.getCmdList();
    list = ToDoItemsList.buildToDoItemsList("addcmdtest2.csv");
    addCommandParameters = new AddCommandParameters(input, list);
    test = new AddCommand(addCommandParameters);
  }

  @Test
  public void execute() {
    // no exception
    test.Execute();
  }
  @Test
  public void testEquals() {
    assertTrue(test.equals(test));
    assertFalse(test.equals(null));
  }

  @Test
  public void testHashCode() {
    assertNotEquals(test.hashCode(), addCommandParameters.hashCode());
    assertEquals(test.hashCode(), test.hashCode());
  }
}