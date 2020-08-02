package problem1.model;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ToDoItemReaderTest {
  private ToDoItemReader toDoItemReader;

  @Before
  public void setUp() throws Exception {
    toDoItemReader = new ToDoItemReader();
  }

  @Test
  public void readToDoItemFromFile() {
    String testFilePath = "todos.csv";
    List<ToDoItem> testSupporterInfos
        = this.toDoItemReader.ReadToDoItemFromFile(testFilePath);
  }

  @Test (expected = Exception.class)
  public void readToDoItemFromFileException() throws Exception{
    String testFilePath = "wrong.csv";
    List<ToDoItem> testSupporterInfos
        = this.toDoItemReader.ReadToDoItemFromFile(testFilePath);
    assertEquals("Finish HW9", testSupporterInfos.get(0).getText());
  }
}