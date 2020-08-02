package problem1.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.view.CmdParser;

public class CompleteCommandParametersTest {
  private CompleteCommandParameters test;
  private List<CmdOption> input;

  @Before
  public void setUp() throws Exception {
    String[] args = {"--csv-file", "todos.csv", "--complete-todo", "3"};
    CmdParser parser = new CmdParser(args);
    input = parser.getCmdList();
    test = new CompleteCommandParameters(3);
  }

  @Test
  public void getID() {
    assertEquals(3, (int) test.getID());
  }

  @Test
  public void buildCompleteCommandParameters1() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--complete-todo", "3"};
    CompleteCommandParameters test3 = new CompleteCommandParameters();
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    List<CompleteCommandParameters> test2 = new ArrayList<>();
    test2.add(new CompleteCommandParameters(3));
    assertEquals(test2.get(0).getID(), test3.buildCompleteCommandParameters(inputTest).get(0).getID());
  }

  @Test(expected = IllegalArgumentException.class)
  public void buildCompleteCommandParameters2() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--complete-todo"};
    CompleteCommandParameters test3 = new CompleteCommandParameters();
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    List<CompleteCommandParameters> test2 = test3.buildCompleteCommandParameters(inputTest);
  }
}