package duke.command;

import duke.others.BelleException;
import duke.run.Storage;
import duke.run.TaskList;
import duke.run.Ui;
import duke.tasks.Task;

/**
 * Deletes item from list.
 */
public class DeleteCommand extends Command {
    private String index;

    /**
     * Constructs DeleteCommand.
     *
     * @param index The index of item to delete.
     */
    public DeleteCommand(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public String execute(Storage s, TaskList t, Ui u) throws BelleException {
        try {
            String printStatement;
            Task deletetask = t.getTask(Integer.valueOf(index) - 1);
            t.removeTask(Integer.parseInt(index) - 1);
            printStatement = "--------------------------" + "\n"
                    + "Noted. I've removed this task:" + "\n"
                    + deletetask.toString() + "\n" + "Now you have "
                    + t.getSize() + " tasks in the list." + "\n"
                    + "--------------------------";
            s.save(t.getList());
            return printStatement;
        } catch (IndexOutOfBoundsException e) {
            throw new BelleException("This is not a valid number in my task list :(");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}