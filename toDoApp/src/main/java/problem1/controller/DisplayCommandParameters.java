package problem1.controller;

import java.util.List;

/**
 * Create DisplayCommandParameter class for displayCommand to store information.
 */

public class DisplayCommandParameters extends CommandParameters {
  private Boolean showIncomplete = null; // set to null if not provided
  private String showCategory = null; // set to null if not provided
  private SortedBy sortedBy = null; // set to SortedBy.None if not provided

  /**
   * Construct DisplayCommandParameters by given information.
   * @param optionList - a list containing all command options
   * @throws InvalidCommandParametersException - when the input list is illegal.
   */
  public DisplayCommandParameters(List<CmdOption> optionList) throws InvalidCommandParametersException {
    int numDisplay = 0;
    for (CmdOption opt : optionList) {
      if (opt.getName() == "--display") {
        numDisplay++;
        if (numDisplay > 1)
          throw new InvalidCommandParametersException("Only 1 display is allowed, exit...");
      }
      if (opt.getName() == "--show-incomplete") {
        if (this.showIncomplete != null)
          throw new InvalidCommandParametersException("Only 1 --show-incomplete is allowed, exit...");
        this.showIncomplete = true;
      }
      if (opt.getName() == "--show-category") {
        if (this.showCategory != null)
          throw new InvalidCommandParametersException("Only 1 --show-category is allowed, exit...");
        this.showCategory = opt.getValue();
      }
      if (opt.getName() == "--sort-by-date" || opt.getName() == "--sort-by-priority") {
        if (this.sortedBy != null) //  Invalid set sortby twice
          throw new InvalidCommandParametersException("Only 1 SortBy is allowed, exit...");
        this.sortedBy = opt.getName() == "--sort-by-date" ? SortedBy.Date : SortedBy.Priority;
      }
    }

    if (numDisplay == 0)
      throw new InvalidCommandParametersException("You must provide at least 1 --display to build display command, exit...");
  }

  /**
   * Get DisplayCommandParameters's value of showing in-completed items.
   * @return - true if the user wants to show in-completed items.
   */
  public Boolean getShowIncomplete() {
    return showIncomplete;
  }

  /**
   * Get the category the user wants to display.
   * @return - the category the user wants to display.
   */
  public String getShowCategory() {
    return showCategory;
  }

  /**
   * Get the sorted type.
   * @return - the sorted type the user wants to use.
   */
  public SortedBy getSortedBy() {
    return sortedBy;
  }

}
