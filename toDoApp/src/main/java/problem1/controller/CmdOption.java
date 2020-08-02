package problem1.controller;

import java.util.Objects;

/**
 * Build a CmdOption class to store information by given input.
 */
public class CmdOption {
  private String name;
  private String value;

  /**
   * Construct a CmdOption by given information.
   * @param name - the name of the CmdOption.
   * @param value - the value of the CmdOption.
   */
  public CmdOption(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Get the name of the CmdOption.
   * @return - the name of the CmdOption.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the value of the CmdOption.
   * @return - the value of the CmdOption.
   */
  public String getValue() {
    return value;
  }

  /**
   * Set the name of the CmdOption.
   * @param name - the new name of the CmdOption.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set the value of the CmdOption.
   * @param value - the new value of the CmdOption.
   */
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CmdOption)) {
      return false;
    }
    CmdOption cmdOption = (CmdOption) o;
    return Objects.equals(name, cmdOption.name) &&
        Objects.equals(value, cmdOption.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  @Override
  public String toString() {
    return "CmdOption{" +
        "name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}