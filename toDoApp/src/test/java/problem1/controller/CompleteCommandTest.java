package problem1.controller;

import org.junit.Before;
import org.junit.Test;
import problem1.model.ToDoItem;
import problem1.model.ToDoItemsList;

public class CompleteCommandTest {
  private CompleteCommand test;

  @Before
  public void setUp() throws Exception {
    ToDoItem toDoItem = new ToDoItem("1","Finish HW9","?","3/22/2020","1","school");
    ToDoItem toDoItem2 = new ToDoItem("2","Mail passport application, photo",null,"2/28/2020","?","?");
    ToDoItemsList toDoItemsList = ToDoItemsList.buildToDoItemsList("todosForCompleteTest.csv");
    CompleteCommandParameters testParam = new CompleteCommandParameters(4);
    test = new CompleteCommand(testParam, toDoItemsList);
  }

  @Test
  public void execute() {
    test.Execute();
  }
}