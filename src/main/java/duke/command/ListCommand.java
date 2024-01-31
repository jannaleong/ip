package duke.command;

import duke.run.Storage;
import duke.run.TaskList;
import duke.run.Ui;

/**
 * Lists out all items in the tasklist.
 */
public class ListCommand extends Command {

    /**
     * Constructs ListCommand.
     */
    public ListCommand() {
    }

    @Override
    public void execute(Storage s, TaskList t, Ui u) {
        System.out.println("--------------------------");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < t.getSize(); i++) {
            System.out.println(String.valueOf(i+1) + "." + t.getTask(i).toString());
        }
        System.out.println("--------------------------");

    }
    @Override
    public boolean isExit() {
        return false;
    }
}