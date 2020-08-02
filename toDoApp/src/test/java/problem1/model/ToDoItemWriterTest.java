package problem1.model;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ToDoItemWriterTest {

  ToDoItem toDoItem;
  ToDoItem toDoItem2;
  List<ToDoItem> list;
  ToDoItemWriter toDoItemWriter;
  ToDoItemsList toDoItemsList;
  String testFilePath = "todostest.csv";

  @Before
  public void setUp() throws Exception {
    toDoItem = new ToDoItem("1","Finish HW9","?","3/22/2020","1","school");
    toDoItem2 = new ToDoItem("2","Mail passport application, photo",null,"2/28/2020","?","?");
    list = new ArrayList<>();
    list.add(toDoItem);
    list.add(toDoItem2);
    toDoItemWriter = new ToDoItemWriter();
  }

  @Test
  public void writeToLocalStorage() throws Exception{
    toDoItemsList = toDoItemsList.buildToDoItemsList(testFilePath);
    toDoItemsList.addItem(toDoItem);
    toDoItemsList.addItem(toDoItem2);
    toDoItemWriter.WriteToLocalStorage(testFilePath, toDoItemsList);
    BufferedReader reader = new BufferedReader(new FileReader(testFilePath));
    String line = reader.readLine();
    assertEquals("\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"",line);
    line = reader.readLine();
    assertEquals("\"1\",\"Finish HW9\",\"false\",\"3/22/2020\",\"1\",\"school\"", line);

  }
}