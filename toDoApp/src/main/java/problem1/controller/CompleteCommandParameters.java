package problem1.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Create CompleteCommandParameter class for CompleteCommand to store information.
 */
public class CompleteCommandParameters extends CommandParameters {
  private Integer ID;

  /**
   * Construct a CompleteCommandParameters class.
   */
  public CompleteCommandParameters() {
  }

  /**
   * Overload a constructor to build a CompleteCommandParameters class by given information.
   * @param ID - the ID of the item the user wants to completed.
   */
  public CompleteCommandParameters(Integer ID) {
    this.ID = ID;
  }

  /**
   * Get the id of the item the user wants to complete.
   * @return - the id number of the item.
   */
  public Integer getID() {
    return ID;
  }

  /**
   * Build a list of CompleteCommandParameters by given input.
   * @param optionList - a list containing all command options
   * @return -  a list containing all CompleteCommandParameters
   * @throws InvalidCommandParametersException - if the input is invalid.
   */
  public List<CompleteCommandParameters> buildCompleteCommandParameters(List<CmdOption> optionList) throws InvalidCommandParametersException {
    List<CompleteCommandParameters> parametersList = new ArrayList<>();

    for (CmdOption opt : optionList) {
      if (opt.getName() == "--complete-todo") {
        try {
          parametersList.add(new CompleteCommandParameters(Integer.valueOf(opt.getValue())));
        } catch (Exception e) {
          System.out.println("Please provide id to complete ToDoItem.");
          throw new InvalidCommandParametersException("No id provided for complete.");
        }
      }
    }

    return parametersList;
  }
}
