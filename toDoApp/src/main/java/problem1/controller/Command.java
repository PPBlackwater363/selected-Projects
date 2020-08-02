package problem1.controller;

import java.util.ArrayList;
import java.util.List;
import problem1.model.InvalidToDoItemParameterException;
import problem1.model.ToDoItemsList;

/**
 * Build an abstract of Command.
 */
public abstract class Command {

  public abstract void Execute();

  /**
   * Create a nested Builder class to use build pattern to construct different command.
   */
  public static class Builder {

    private Builder builder;
    private ToDoItemsList toDoItems;
    private List<CommandParameters> cmdParametersList;

    public Builder() {
    }

    /**
     * Add CmdParameters by given input.
     * @param opts - a list of CmdOptions.
     * @return - a Builder with new CmdParameters.
     * @throws InvalidToDoItemParameterException - if the todoItemList is invalid.
     * @throws InvalidCommandParametersException - if the CommandParameter is in valid.
     */
    public Builder addCmdParameters(List<CmdOption> opts/*pass in opts*/)
        throws InvalidToDoItemParameterException, InvalidCommandParametersException {
      List<CommandParameters> curr = new ArrayList<>();
      List<CompleteCommandParameters> currComplete = new ArrayList<>();
      for (CmdOption opt : opts) {
        String s = opt.getName();
        switch(s) {
          case "--add-todo":
            curr.add(new AddCommandParameters(opts, this.toDoItems));
            break;
          case "--display":
            curr.add(new DisplayCommandParameters(opts));
          case "--complete-todo":
            currComplete = new CompleteCommandParameters().buildCompleteCommandParameters(opts);
            break;
          default:
            break;
        }
      }
      curr.addAll(currComplete);
      this.cmdParametersList = curr;

      return this;
    }

    /**
     * Add todoItems read from the csv file to the list of the builder.
     * @param filePath - the file path of the csv file.
     * @return - a new Builder with updated toDoItems.
     */
    public Builder addCurToDoItems(String filePath/*pass in file path*/) {
      this.toDoItems = ToDoItemsList.buildToDoItemsList(filePath);
      return this;
    }

    /**
     * Generate a list of Command by using build pattern.
     * @return - a list of Command.
     */
    public List<Command> build() {
      // Construct commands here
      List<Command> commands = new ArrayList<>();

      for (CommandParameters cmdParams : this.cmdParametersList) {
        if (cmdParams instanceof  AddCommandParameters)
          commands.add(new AddCommand((AddCommandParameters)cmdParams));
        if (cmdParams instanceof CompleteCommandParameters)
          commands.add(new CompleteCommand((CompleteCommandParameters)cmdParams, this.toDoItems));
        if (cmdParams instanceof DisplayCommandParameters)
          commands.add(new DisplayCommand((DisplayCommandParameters)cmdParams, this.toDoItems));
      }

      return commands;
    }
  }
}
