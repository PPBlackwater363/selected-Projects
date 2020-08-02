package problem1.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CmdOptionTest {

  private CmdOption cmdOption;

  @Before
  public void setUp() throws Exception {
    cmdOption = new CmdOption("--completed", "true");
  }

  @Test
  public void getName() {
    assertEquals("--completed", cmdOption.getName());
  }

  @Test
  public void getValue() {
    assertEquals("true", cmdOption.getValue());
  }

  @Test
  public void setName() {
    cmdOption.setName("--priority");
    assertEquals("--priority", cmdOption.getName());
  }

  @Test
  public void setValue() {
    cmdOption.setValue("false");
    assertEquals("false", cmdOption.getValue());
  }

  @Test
  public void testEquals() {
    int a = 5;
    CmdOption test = new CmdOption("--completed", "true");
    CmdOption test2 = new CmdOption("--completed", "false");
    assertEquals(test, cmdOption);
    assertNotEquals(test, test2);
    assertEquals(test, test);
    assertNotEquals(a, test);
    assertNotEquals(a, cmdOption);
  }

  @Test
  public void testHashCode() {
    CmdOption test = new CmdOption("--completed", "true");
    int hc1 = test.hashCode();
    int hc2 = cmdOption.hashCode();
    assertEquals(test.hashCode(), hc1);
    assertEquals(cmdOption.hashCode(), hc2);
    assertEquals(hc1, hc1);
  }

  @Test
  public void testToString() {
    assertEquals("CmdOption{name='--completed', value='true'}", cmdOption.toString());
  }
}