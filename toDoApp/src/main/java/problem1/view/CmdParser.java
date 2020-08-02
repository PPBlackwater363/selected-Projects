package problem1.view;

//import apple.laf.JRSUIConstants.SegmentLeadingSeparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import problem1.controller.CmdOption;

/**
 * Build a commandLine parser to parse input information.
 */
public class CmdParser {
  private String[] args;
  private List<CmdOption> cmdList;

  /**
   * Construct a cmdParser to parse input arguments.
   * @param args - input command arguments.
   */
  public CmdParser(String[] args) {
    this.args = args;
    if (!this.validLength())
      throw new IllegalArgumentException("Please enter at least 2 arguments.");
    else if (!this.checkRequired())
      throw new IllegalArgumentException("--csv-file is required.");
    else
      cmdList = this.processArgs();
  }

  /**
   * Private helper function to check if the length of the input command is valid.
   * @return - true if the input is valid.
   */
  private boolean validLength() {
    return this.args.length >= 2;
  }

  /**
   * Helper function to check if the input has the required --csv-file command.
   * @return - true if the input included the required command.
   */
  private boolean checkRequired() {
    for (String s : this.args) {
      if (s.equals("--csv-file"))
        return true;
    }
    return false;
  }

  /**
   * Validate and build a list of CmdOptions.
   * @return - a list of valid CmdOptions.
   */
  public List<CmdOption> processArgs() {
    List<CmdOption> res = new ArrayList<>();
    int i = 0;

    while (i < this.args.length) {
      String curr = this.args[i];

      switch (curr) {
        // create csv option with csv file;
        case "--csv-file":
          int j = i + 1;
          if (j >= this.args.length || this.isDefinedCmd(this.args[j]))
            throw new IllegalArgumentException("--csv-file provided, but no file name is given.");
          else {
            CmdOption csvOption = new CmdOption("--csv-file", this.args[j]);
            cmdList = res;
            this.cmdList.add(csvOption);
          }
          i = j + 1;
          break;
        // create --add option;
        case "--add-todo":
          CmdOption addOption = new CmdOption("--add-todo", null);
          this.cmdList.add(addOption);
          i++;
          break;
        // create --text option;
        case "--todo-text":
          int a = i + 1;
          if (a >= this.args.length || this.isDefinedCmd(this.args[a]))
            throw new IllegalArgumentException("--todo-text provided, but no text is given.");
          else {
            CmdOption textOption = new CmdOption("--todo-text", this.args[a]);
            this.cmdList.add(textOption);
          }
          i = a + 1;
          break;
        // create --completed option;
        case "--completed":
          CmdOption completedOption = new CmdOption("--completed", "true");
          this.cmdList.add(completedOption);
          i++;
          break;
        // create --due option;
        case "--due":
          int b = i + 1;
          if (b >= this.args.length || this.isDefinedCmd(this.args[b]))
            throw new IllegalArgumentException("--due provided, but no date is given.");
          else {
            CmdOption dueOption = new CmdOption("--due", this.args[b]);
            this.cmdList.add(dueOption);
          }
          i = b + 1;
          break;
        // create --priority option
        case "--priority":
          int c = i + 1;
          if (c >= this.args.length || this.isDefinedCmd(this.args[c]) ||
              Integer.parseInt(this.args[c]) > 3 || Integer.parseInt(this.args[c]) < 1) {
            CmdOption priorityOption = new CmdOption("--priority", String.valueOf(3));
            this.cmdList.add(priorityOption);
          }
          else {
            CmdOption priorityOption = new CmdOption("--priority", this.args[c]);
            this.cmdList.add(priorityOption);
          }
          i = c + 1;
          break;
        // create --category option
        case "--category":
          int d = i + 1;
          if (d >= this.args.length || this.isDefinedCmd(this.args[d])) {
            throw new IllegalArgumentException("--category provided, but no category is given.");
          }
          else {
            CmdOption categoryOption = new CmdOption("--category", this.args[d]);
            this.cmdList.add(categoryOption);
          }
          i = d + 1;
          break;
        // create --complete option
        case "--complete-todo":
          int e = i + 1;
          if (e >= this.args.length || this.isDefinedCmd(this.args[e])) {
            throw new IllegalArgumentException("--complete-todo provided, but no ID is given.");
          }
          else {
            CmdOption completeOption = new CmdOption("--complete-todo", this.args[e]);
            this.cmdList.add(completeOption);
          }
          i = e + 1;
          break;
        // create --display option
        case "--display":
          CmdOption displayOption = new CmdOption("--display", null);
          this.cmdList.add(displayOption);
          i++;
          break;
        // create --show-incomplete option
        case "--show-incomplete":
          CmdOption showOption = new CmdOption("--show-incomplete", null);
          this.cmdList.add(showOption);
          i++;
          break;
        // create --show-category option
        case "--show-category":
          int valueIndex = i + 1;
          if (valueIndex >= this.args.length || this.isDefinedCmd(this.args[valueIndex])) {
            throw new IllegalArgumentException("--show-category provided, but no category is given.");
          }
          CmdOption showCategoryOption = new CmdOption("--show-category", this.args[valueIndex]);
          this.cmdList.add(showCategoryOption);
          i += 2;
          break;
        // create --sort-by-date option
        case "--sort-by-date":
          CmdOption sortDateOption = new CmdOption("--sort-by-date", null);
          this.cmdList.add(sortDateOption);
          i++;
          break;
        // create --sort-by-priority option
        case "--sort-by-priority":
          CmdOption sortPriorityOption = new CmdOption("--sort-by-priority", null);
          this.cmdList.add(sortPriorityOption);
          i++;
          break;
        // throw IllegalArgumentException
        default:
          throw new IllegalArgumentException("Please enter valid command.");
      }
    }
    return this.cmdList;
  }

  /**
   * Helper function to check if the input equals on of those defined commands.
   * @param s - input string to be checked.
   * @return - true if the input equals one of those defined commands.
   */
  private boolean isDefinedCmd(String s) {
    return s.equals("--csv-file") ||
        s.equals("--add-todo") ||
        s.equals("--todo-text") ||
        s.equals("--due") ||
        s.equals("--priority") ||
        s.equals("--category") ||
        s.equals("--complete-todo") ||
        s.equals("--display") ||
        s.equals("--show-incomplete") ||
        s.equals("--show-category") ||
        s.equals("--sort-by-date") ||
        s.equals("--sort-by-priority");
  }

  /**
   * Get the list of input arguments.
   * @return - the list of input arguments.
   */
  public String[] getArgs() {
    return args;
  }

  /**
   * Get the file path for csv reading.
   * @return - the file path.
   */
  public String getFilePath() {
    int j = 0;
    for (int i = 0; i < this.getCmdList().size(); i++) {
      if (this.cmdList.get(i).getName().equals("--csv-file")) {
        j = i;
        break;
      }
    }
    return this.cmdList.get(j).getValue();
  }

  /**
   * Get the list of CmdOption.
   * @return - the list of CmdOption.
   */
  public List<CmdOption> getCmdList() {
    return cmdList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CmdParser)) {
      return false;
    }
    CmdParser cmdParser = (CmdParser) o;
    return Arrays.equals(args, cmdParser.args) &&
        Objects.equals(cmdList, cmdParser.cmdList);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(cmdList);
    result = 31 * result + Arrays.hashCode(args);
    return result;
  }

  @Override
  public String toString() {
    return "CmdParser{" +
        "args=" + Arrays.toString(args) +
        ", cmdList=" + cmdList +
        '}';
  }
}
