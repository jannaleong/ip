package belle;

import belle.run.Ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Belle belle;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image belleImage = new Image(this.getClass().getResourceAsStream("/images/DaBelle.png"));

    /**
     * Initialises the Belle program with a greeting.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        greetUser();
    }

    public void setBelle(Belle d) {
        belle = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Belle's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = belle.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getBelleDialog(response, belleImage)
        );
        userInput.clear();

        Ui ui = new Ui();
        if (response.equals(ui.bye())) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                System.exit(0);
            }));
            timeline.play();
        }
    }

    /**
     * Creates a dialogue box to greet the user the instant
     * they enter the program.
     */
    @FXML
    private void greetUser() {
        Ui ui = new Ui();
        dialogContainer.getChildren().addAll(
                DialogBox.getBelleDialog(
                        ui.greet(),
                        belleImage
                )
        );
    }
}
