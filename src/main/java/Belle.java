import java.io.IOException;
import java.util.ArrayList;

public class Belle {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private Parser parser;
    public Belle(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        tasks = new TaskList(new ArrayList<>());
        try {
            tasks = new TaskList(storage.loadList());
        } catch (BelleException e) {
            //ui.showLoadingError();
            System.out.println(e.getMessage());
            tasks = new TaskList(new ArrayList<>());
        } catch (IOException e) {
            System.out.println("IOException from storage from Belle.java");
        }
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String currInput = ui.readInput();
                Command com = parser.parse(currInput);
                com.execute(storage, tasks, ui);
                isExit = com.isExit();
            } catch (BelleException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        new Belle("src/main/data/belleList.txt").run();
    }
}