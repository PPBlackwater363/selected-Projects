package problem1.controller;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.model.InvalidToDoItemParameterException;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;
import problem1.view.CmdParser;

public class AddCommandParametersTest {
  private AddCommandParameters test;
  private List<CmdOption> input;
  private ToDoItemsList list;

  @Before
  public void setUp() throws Exception {
    String[] args = {"--csv-file", "addcmdtest.csv", "--add-todo", "--todo-text", "running exercises"};
    CmdParser parser = new CmdParser(args);
    input = parser.getCmdList();
    list = ToDoItemsList.buildToDoItemsList("addcmdtest.csv");
    test = new AddCommandParameters(input, list);
  }

  @Test
  public void getToDoItem() throws InvalidToDoItemParameterException {
    ToDoItem toDoItem = new ToDoItem("6","running exercises","?","?","?","?");
    assertTrue(test.getToDoItem().equals(toDoItem));
  }

  @Test
  public void getToDoItemsList() {
    assertTrue(list.equals(test.getToDoItemsList()));
  }
}