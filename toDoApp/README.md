# toDo App

In this assignment, we used Builder Pattern to build Commands. The Command factory method is quite complex, since we need to read in different type of parameters for each type of command, and need to read in csv file to build the ToDoItemList model. This Command Builder encapsulates the logic to determine which Command to build, and encapsulates specific parameters for different type of command.

We also used Command Pattern, we encapsulate all operations for ToDoItemList into different Commands and corresponding CommandParameters. In this way, we isolate the responsibility and validation logic into each small class, which makes it easy and clear to develop and maintain. Also by CommandPattern, we make it easy to extend to more Commands for future.

We also used MVC pattern. We treat CMD/Console as frontend UI(View), internal ToDoItemsList as Model, and all Commands as Controller. By this design, we clearly divided the responsibility into 3 parts: main&Console to interact with user; Commands operates the internal data model; and ToDoItemsList represents raw data, provides methods to operate data, it also hides the interaction with underlying "database file".
