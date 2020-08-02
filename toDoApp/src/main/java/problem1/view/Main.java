package problem1.view;

import java.util.List;
import problem1.controller.CmdOption;
import problem1.controller.Command;
import problem1.controller.InvalidCommandParametersException;
import problem1.model.InvalidToDoItemParameterException;

public class Main {

  public static void main(String[] args)
      throws InvalidToDoItemParameterException, InvalidCommandParametersException {
    // call parser to parse
    CmdParser cmdParser = new CmdParser(args);
    List<CmdOption> opts = cmdParser.getCmdList();

    // call Command Builder to build command list
    List<Command> commands = new Command.Builder().addCurToDoItems(cmdParser.getFilePath()).addCmdParameters(opts).build();

    // iterate Command List to execute commands
    for (Command cmd : commands) {
      cmd.Execute();
    }
  }
}
