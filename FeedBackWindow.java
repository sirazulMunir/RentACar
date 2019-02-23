import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FeedBackWindow extends Main {

    public FeedBackWindow(){
        super();
    }

    public static Stage window;
    private static TextArea feedbackArea;
    static MediaPlayer mediaPlayer;

    public static ArrayList<String> feedbackName;
    public static ArrayList<String> message;


    public static void seeFeedback(String title){

        window = new Stage();
        window.setTitle(title);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer = new MediaPlayer(clickFile);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        message = new ArrayList<String>();
        feedbackName = new ArrayList<String>();

        try {
            Scanner sc1 = new Scanner(new File("Text Files\\FeedBackName.txt"));
            Scanner sc = new Scanner(new File("Text Files\\feedbackSMS.txt"));
            while(sc1.hasNext()){
                feedbackName.add(sc1.nextLine());
                message.add(sc.nextLine());
            }
            sc1.close();
            sc.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        //Button for see orders
        Button orderButton = new Button("Number of Orders");
        orderButton.setMinWidth(110);
        orderButton.getStyleClass().add("button-admin");
        orderButton.setOnAction(e ->{
            mediaPlayer.play();
            OrderSeeWindow.Orders("Orders");
            window.close();
        });

        //Button for adminpanel
        Button adminButton = new Button("Customer Details");
        adminButton.setMinWidth(110);
        adminButton.getStyleClass().add("button-admin");
        adminButton.setOnAction(e ->{
            mediaPlayer.play();
            CustomerDetails.showCustomerDetails("Customer Details");
            window.close();
        });

        //Button for vehicle search individually
        Button viewVehicle = new Button("Search by Vehicle");
        viewVehicle.setMinWidth(110);
        viewVehicle.getStyleClass().add("button-admin");
        viewVehicle.setOnAction(e ->{
            mediaPlayer.play();
            Search.vehicleSearch("Search");
            window.close();
        });

        //Button for home
        Button homeButton = new Button("Homepage");
        homeButton.setMinWidth(110);
        homeButton.getStyleClass().add("button-admin");
        homeButton.setOnAction(e ->{
            mediaPlayer.play();
            Main.mainframe("Happy Journey");
            window.close();
        });

        HBox layout = new HBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(orderButton,adminButton,viewVehicle,homeButton);
        GridPane.setConstraints(layout,0,0);

        //Label for feedback messages
        Label feedBackLabel = new Label("Feedback Messages: ");
        GridPane.setConstraints(feedBackLabel,0,1);

        //textArea for feedback messages
        feedbackArea = new TextArea();
        feedbackArea.setEditable(false);
        feedbackArea.setMinSize(300,450);
        for ( int i = 0; i < message.size(); i++){
            feedbackArea.appendText("Name: "+ " " + feedbackName.get(i) +"\n" + " * " + " " +message.get(i) + "\n"+ "\n");
        }
        feedbackArea.getStyleClass().add("textArea");
        GridPane.setConstraints(feedbackArea,0,3);


        gridPane.getChildren().addAll(layout,feedBackLabel,feedbackArea);
        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("CSS%20Files/FeedBackWindow.css");
        window.setScene(scene);
        window.show();

    }

    private static void closeProgram(){
        boolean answer = ConfirmBox.display("Confirm Box","Want to close the Program?");
        if (answer){
            window.close();
        }
    }
}
