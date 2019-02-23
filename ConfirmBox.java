import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;
    static MediaPlayer mediaPlayer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(350);
        Label label = new Label();
        label.setText(message);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer = new MediaPlayer(clickFile);

        Button yesButton = new Button(" Yes ");
        yesButton.getStyleClass().add("yes-button");
        yesButton.setOnAction(e ->{
            mediaPlayer.play();
            answer = true;
            window.close();
        });

        Button noButton = new Button(" No ");
        noButton.getStyleClass().add("no-button");
        noButton.setOnAction(e ->{
            mediaPlayer.play();
            answer = false;
            window.close();
        });

        VBox layout = new VBox();
        layout.setSpacing(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("CSS%20Files/ConfirmBox.css");
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }
}
