package problem1.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.controller.CmdOption;

public class CmdParserTest {
  private CmdParser test;
  String[] testArgs = {"--csv-file", "todos.csv", "--display"};

  @Before
  public void setUp() throws Exception {
    test = new CmdParser(testArgs);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsInvalidLength() {
    String[] testInput = {"--csv-file"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsWithoutRequiredCmd() {
    String[] testInput = {"--complete-todo", "3", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsNoCsvFilePath() {
    String[] testInput = {"--csv-file", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsNoCsvFilePath2() {
    String[] testInput = {"--display", "--complete-todo"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsTestAddCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--add-todo"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption displayOption = new CmdOption("--add-todo", null);
    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(displayOption);
    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsToDoText() {
    String[] testInput = {"--csv-file", "todos.csv", "--add-todo", "--todo-text"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsToDoText2() {
    String[] testInput = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsToDoText3() {
    String[] testInput = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "NEU"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption displayOption = new CmdOption("--add-todo", null);
    CmdOption toDoTextOption = new CmdOption("--todo-text", "NEU");
    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(displayOption);
    curr.add(toDoTextOption);
    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsCompletedCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "NEU", "--completed"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption displayOption = new CmdOption("--add-todo", null);
    CmdOption toDoTextOption = new CmdOption("--todo-text", "NEU");
    CmdOption completedOption = new CmdOption("--completed", "true");
    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(displayOption);
    curr.add(toDoTextOption);
    curr.add(completedOption);
    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsDueCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--due", "04072020"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption dueOption = new CmdOption("--due", "04072020");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(dueOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsDueCmdNoDate() {
    String[] testInput = {"--csv-file", "todos.csv", "--due"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsDueCmdNoDate2() {
    String[] testInput = {"--csv-file", "todos.csv", "--due", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsPriorityCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--priority", "1"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption priorityOption = new CmdOption("--priority", "1");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(priorityOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsPriorityCmd2() {
    String[] testInput = {"--csv-file", "todos.csv", "--priority", "0"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption priorityOption = new CmdOption("--priority", "3");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(priorityOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsPriorityCmd3() {
    String[] testInput = {"--csv-file", "todos.csv", "--priority", "4"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption priorityOption = new CmdOption("--priority", "3");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(priorityOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsPriorityCmd4() {
    String[] testInput = {"--csv-file", "todos.csv", "--priority", "--display"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption priorityOption = new CmdOption("--priority", "3");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(priorityOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsPriorityCmd5() {
    String[] testInput = {"--csv-file", "todos.csv", "--priority"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption priorityOption = new CmdOption("--priority", "3");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(priorityOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsCategoryCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--category", "work"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption categoryOption = new CmdOption("--category", "work");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(categoryOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsCategoryCmd2() {
    String[] testInput = {"--csv-file", "todos.csv", "--category"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsCategoryCmd3() {
    String[] testInput = {"--csv-file", "todos.csv", "--category", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsCompletedCmd2() {
    String[] testInput = {"--csv-file", "todos.csv", "--complete-todo", "6"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption completedOption = new CmdOption("--complete-todo", "6");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(completedOption);

    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsCompletedCmdNoID() {
    String[] testInput = {"--csv-file", "todos.csv", "--complete-todo", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsCompletedCmdNoID2() {
    String[] testInput = {"--csv-file", "todos.csv", "--complete-todo"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsShowIncompletedCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--show-incomplete"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption Option = new CmdOption("--show-incomplete", null);

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(Option);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsShowCategoryCmd() {
    String[] testInput = {"--csv-file", "todos.csv", "--show-category", "work"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption Option = new CmdOption("--show-category", "work");

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(Option);

    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsShowCategoryCmd2() {
    String[] testInput = {"--csv-file", "todos.csv", "--show-category"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsShowCategoryCmd3() {
    String[] testInput = {"--csv-file", "todos.csv", "--show-category", "--display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void processArgsSortCmd1() {
    String[] testInput = {"--csv-file", "todos.csv", "--sort-by-date"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption Option = new CmdOption("--sort-by-date", null);

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(Option);

    assertEquals(curr, test1.getCmdList());
  }

  @Test
  public void processArgsSortCmd2() {
    String[] testInput = {"--csv-file", "todos.csv", "--sort-by-priority"};
    CmdParser test1 = new CmdParser(testInput);

    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption Option = new CmdOption("--sort-by-priority", null);

    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(Option);

    assertEquals(curr, test1.getCmdList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void processArgsInvalidInput() {
    String[] testInput = {"--csv-file", "todos.csv", "display"};
    CmdParser test1 = new CmdParser(testInput);
  }

  @Test
  public void getArgs() {
    String[] s = {"--csv-file", "todos.csv", "--display"};
    assertEquals(s, test.getArgs());
  }

  @Test
  public void getFilePath() {
    assertEquals("todos.csv", test.getFilePath());
  }

  @Test
  public void getCmdList() {
    CmdOption csvOption = new CmdOption("--csv-file", "todos.csv");
    CmdOption displayOption = new CmdOption("--display", null);
    List<CmdOption> curr = new ArrayList<>();
    curr.add(csvOption);
    curr.add(displayOption);
    assertEquals(curr, test.getCmdList());
  }

  @Test
  public void testEquals() {
    assertEquals(test, test);
  }

  @Test
  public void testEquals2() {
    assertNotEquals(test, null);
  }

  @Test
  public void testEquals3() {
    String s = "test";
    assertNotEquals(test, s);
  }

  @Test
  public void testEquals4() {
    String[] testArgs = {"--csv-file", "todos.csv", "--display"};
    CmdParser test2 = new CmdParser(testArgs);
    assertEquals(test, test2);
  }

  @Test
  public void testEquals5() {
    String[] testArgs = {"--csv-file", "todos.csv", "--priority"};
    CmdParser test2 = new CmdParser(testArgs);
    assertNotEquals(test, test2);
  }

  @Test
  public void testHashCode() {
    assertEquals(335729123, test.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CmdParser{args=[--csv-file, todos.csv, --display], "
        + "cmdList=[CmdOption{name='--csv-file', value='todos.csv'}, CmdOption{name='--display', "
        + "value='null'}]}", test.toString());
  }
}