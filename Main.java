import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application {

    static Stage window;

    static MediaPlayer mediaPlayer , mediaPlayer2;

    public static ArrayList<String> name;
    public static ArrayList<String> address;
    public static ArrayList<String> phone ;
    public static ArrayList<String> date;
    public static ArrayList<String> month;
    public static ArrayList<String> year;
    public static ArrayList<String> time;
    public static ArrayList<String> ampm;
    public static ArrayList<String> vehicleName;
    public static ArrayList<Integer> quantity;


    static void mainframe(String title) {
        window = new Stage();
        window.setTitle(title);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer = new MediaPlayer(clickFile);

        Media warningFile = new Media("Sound/warning.mp3");
        mediaPlayer2 = new MediaPlayer(warningFile);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        name = new ArrayList<String>();
        address = new ArrayList<String>();
        phone = new ArrayList<String>();
        date = new ArrayList<String>();
        month = new ArrayList<String>();
        year = new ArrayList<String>();
        time = new ArrayList<String>();
        ampm = new ArrayList<String>();
        vehicleName = new ArrayList<String>();
        quantity = new ArrayList<Integer>();

        try{

            Scanner s = new Scanner(new File("Text Files\\name.txt"));
            Scanner s1 = new Scanner(new File("Text Files\\address.txt"));
            Scanner s2 = new Scanner(new File("Text Files\\phone.txt"));
            Scanner s3 = new Scanner(new File("Text Files\\date.txt"));
            Scanner s4 = new Scanner(new File("Text Files\\month.txt"));
            Scanner s5 = new Scanner(new File("Text Files\\year.txt"));
            Scanner s6 = new Scanner(new File("Text Files\\time.txt"));
            Scanner s7 = new Scanner(new File("Text Files\\ampm.txt"));
            Scanner s8 = new Scanner(new File("Text Files\\vehiclename.txt"));
            Scanner s9 = new Scanner(new File("Text Files\\quantity.txt"));

            while(s.hasNext()){
                name.add(s.nextLine());
                address.add(s1.nextLine());
                phone.add(s2.nextLine());
                date.add(s3.nextLine());
                month.add(s4.nextLine());
                year.add(s5.nextLine());
                time.add(s6.nextLine());
                ampm.add(s7.nextLine());
                vehicleName.add(s8.nextLine());
                quantity.add(s9.nextInt());
            }
            s.close();
            s1.close();
            s2.close();
            s3.close();
            s4.close();
            s5.close();
            s6.close();
            s7.close();
            s8.close();
            s9.close();

        }catch(Exception e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }


        //Direct Hire Button
        Button hireButton = new Button("Booking");
        hireButton.setMinWidth(110);
        hireButton.setOnAction(e -> {
            mediaPlayer.play();
            HireYourCar.booking("Hire Your Car");
            window.close();
        });
        GridPane.setConstraints(hireButton,1,8);


        //Gallery Button
        Button galleryButton = new Button("Gallery");
        galleryButton.setMinWidth(110);
        galleryButton.setOnAction(e ->{
            mediaPlayer.play();
            ImageGallery.imageFrame("Gallery");
        });
        GridPane.setConstraints(galleryButton,1,10);

        //admin Button
        Button adminButton = new Button("Admin");
        adminButton.getStyleClass().add("button-admin");
        adminButton.setMinWidth(110);
        adminButton.setOnAction(e -> {
            mediaPlayer.play();
            SignIn.signIn("Administrator");
            window.close();
        });
        GridPane.setConstraints(adminButton,1,12);


        //label for feedback
        Label fedLabel = new Label("Give us Some Feedback");
        GridPane.setConstraints(fedLabel,1,17);

        //TextField for name
        TextField nameField = new TextField();
        nameField.setPromptText("Write your name");
        GridPane.setConstraints(nameField,1,18);

        //Text field for empty name
        TextField nameMSG = new TextField();
        nameMSG.setEditable(false);
        nameMSG.getStyleClass().add("messageField");
        nameMSG.setVisible(false);
        GridPane.setConstraints(nameMSG,2,18);

        //Text filed for getting feedback
        TextField feedBack = new TextField();
        feedBack.getStyleClass().add("textField");
        feedBack.setMinWidth(300);
        feedBack.setMinHeight(50);
        feedBack.setPromptText("Write your Feedback here");
        GridPane.setConstraints(feedBack,1,19);

        //Textfield for empty feedback
        TextField feedBackMSG = new TextField();
        feedBackMSG.setVisible(false);
        feedBackMSG.getStyleClass().add("messageField");
        feedBackMSG.setEditable(false);
        GridPane.setConstraints(feedBackMSG,2,19);

        //Button for sending feedback to file
        Button feedButton = new Button("Send Feedback");
        feedButton.getStyleClass().add("button-feedback");
        feedButton.setMinWidth(110);
        feedButton.setOnAction(e ->{
            mediaPlayer.play();
            String empty = "";
            if (empty.equals(nameField.getText())){
                mediaPlayer2.play();
                nameMSG.setText("Write your name");
                nameMSG.setVisible(true);
            }else if (empty.equals(feedBack.getText())){
                mediaPlayer2.play();
                feedBackMSG.setText("Please write something");
                feedBackMSG.setVisible(true);
            }else{
                try{
                    BufferedWriter nameWriter = new BufferedWriter(new FileWriter("Text Files\\FeedBackName.txt",true));
                    BufferedWriter feedWriter = new BufferedWriter(new FileWriter("Text Files\\feedbackSMS.txt",true));
                    nameWriter.write(" " + nameField.getText());
                    nameWriter.write("\n");
                    feedWriter.write( ""+feedBack.getText());
                    feedWriter.write("\n");
                    nameWriter.close();
                    feedWriter.close();

                    nameField.clear();
                    feedBack.clear();
                    nameMSG.setVisible(false);
                    feedBackMSG.setVisible(false);

                }catch(IOException e1){
                 e1.printStackTrace();
                }
            }
        });
        GridPane.setConstraints(feedButton,1,20);

        gridPane.getChildren().addAll(hireButton,galleryButton,adminButton,fedLabel,nameField,nameMSG,feedBack,feedBackMSG,feedButton);

        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("CSS%20Files/Main.css");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception{
        Main.mainframe("Happy Journey");
    }

    private static void closeProgram(){
        boolean answer = ConfirmBox.display("Confirm Box","Want to close the Program?");
        if (answer){
            window.close();
        }
    }

}
