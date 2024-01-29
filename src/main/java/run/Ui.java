package run;

import java.util.Scanner;

public class Ui {
    private Scanner sc;

    /**
     * Constructs Ui.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Read users input.
     *
     * @return String of users input.
     */
    public String readInput() {
        return sc.nextLine();
    }

    /**
     * Prints welcome message.
     */
    public void greet() {
        System.out.println("--------------------------");
        System.out.println("Welcome!! I'm Belle <3.");
        System.out.println("What can I do for you?");
        System.out.println("--------------------------");
    }

    /**
     * Prints goodbye message.
     */
    public void bye() {
        System.out.println("--------------------------");
        System.out.println("Till next time!! Goodbye.");
        System.out.println("--------------------------");
        this.sc.close();
    }
}


//let ui handle errors like loading errors