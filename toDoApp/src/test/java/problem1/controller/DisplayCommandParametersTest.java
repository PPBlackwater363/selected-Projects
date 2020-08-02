package problem1.controller;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.view.CmdParser;

public class DisplayCommandParametersTest {
  private DisplayCommandParameters test;
  private List<CmdOption> input;

  @Before
  public void setUp() throws Exception {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-category", "work"};
    CmdParser parser = new CmdParser(args);
    input = parser.getCmdList();
    test = new DisplayCommandParameters(input);
  }

  @Test (expected = InvalidCommandParametersException.class)
  public void displayCmdTest() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-category", "work", "--display"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
  }

  @Test (expected = InvalidCommandParametersException.class)
  public void displayCmdTest2() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-incomplete", "--show-incomplete"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
  }

  @Test
  public void displayCmdTest3() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-incomplete"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
    assertTrue(test1.getShowIncomplete());
  }

  @Test (expected = InvalidCommandParametersException.class)
  public void displayCmdTest4() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-category", "work",
        "--show-category", "school"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
  }

  @Test
  public void displayCmdTest5() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--show-category", "work"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
    assertEquals("work", test1.getShowCategory());
  }

  @Test (expected = InvalidCommandParametersException.class)
  public void displayCmdTest6() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--sort-by-date", "--sort-by-priority"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
  }

  @Test
  public void displayCmdTest7() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--sort-by-date"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
    assertEquals(test1.getSortedBy(), SortedBy.Date);
  }

  @Test
  public void displayCmdTest8() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--display", "--sort-by-priority"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
    assertEquals(test1.getSortedBy(), SortedBy.Priority);
  }

  @Test (expected = InvalidCommandParametersException.class)
  public void displayCmdTest9() throws InvalidCommandParametersException {
    String[] args = {"--csv-file", "todos.csv", "--sort-by-date"};
    CmdParser parser = new CmdParser(args);
    List<CmdOption> inputTest = parser.getCmdList();
    DisplayCommandParameters test1 = new DisplayCommandParameters(inputTest);
  }

  @Test
  public void getShowIncomplete() {
  }

  @Test
  public void getShowCategory() {
  }

  @Test
  public void getSortedBy() {
  }
}