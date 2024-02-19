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

    /**
     * Runs the command to delete tasks from tasklist.
     *
     * @param s Storage containing data of
     *          previous program.
     * @param t Tasklist of program.
     * @param u Ui that handles user interactions.
     * @return Delete print statement.
     */
    @Override
    public String execute(Storage s, TaskList t, Ui u) throws BelleException {
        try {
            assert (Integer.valueOf(index) > 0) : "index cannot be negative";
            assert (Integer.valueOf(this.index) >= 0) : "this index is negative";
            assert (Integer.valueOf(this.index) <= t.getSize()) : "this index is too big";

            Task deleteTask = t.getTask(Integer.valueOf(index) - 1);
            t.removeTask(Integer.parseInt(index) - 1);
            s.save(t.getList());
            return generateDeleteStatement(deleteTask, t);
        } catch (IndexOutOfBoundsException e) {
            throw new BelleException("This is not a valid number in my task list :(");
        }
    }

    /**
     * Generates delete print statement.
     *
     * @param deleteTask Task to be deleted.
     * @param t Tasklist of program.
     * @return Print statement for deleted task.
     */
    public String generateDeleteStatement(Task deleteTask, TaskList t) {
        return "--------------------------" + "\n"
                + "Noted. I've removed this task:" + "\n"
                + deleteTask.toString() + "\n" + "Now you have "
                + t.getSize() + " tasks in the list." + "\n"
                + "--------------------------";
    }
}
