import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SignIn {

    private static Stage window;

    static MediaPlayer mediaPlayer1,mediaPlayer2;

    static void signIn(String title){
        window = new Stage();
        window.setTitle(title);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer1 = new MediaPlayer(clickFile);

        Media warningFile = new Media("Sound/warning.mp3");
        mediaPlayer2 = new MediaPlayer(warningFile);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(10);
        grid.setHgap(10);

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        //Email Label
        Label email = new Label("Email");
        GridPane.setConstraints(email,3,5);

        //Email Input
        TextField mailInput = new TextField();
        mailInput.setPromptText("Email Address");
        GridPane.setConstraints(mailInput, 4, 5);

        //wrong mail msg
        TextField msg1 = new TextField();
        msg1.setVisible(false);
        msg1.setEditable(false);
        GridPane.setConstraints(msg1,5,5);


        //PassWord Label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel,3,6);

        //Password Input
        /*TextField passInput = new TextField();
        passInput.setPromptText("Password");
        passInput.setSkin(new PasswordFieldSkin(passInput));
        GridPane.setConstraints(passInput, 4, 6);*/

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        passInput.setSkin(new PasswordFieldSkin(passInput));
        GridPane.setConstraints(passInput, 4, 6);

        //wrong password msg
        TextField msg2 = new TextField();
        msg2.setVisible(false);
        msg2.setEditable(false);
        GridPane.setConstraints(msg2,5,6);

        Button reSingIn = new Button("Try Again");
        reSingIn.setMinWidth(80);
        reSingIn.getStyleClass().add("button-red");
        reSingIn.setVisible(false);
        GridPane.setConstraints(reSingIn,5,7);

        Button signIn= new Button("SIGN IN");
        signIn.setMinWidth(80);
        signIn.setOnAction(e ->{
            mediaPlayer1.play();
            try{
                FileReader nm = new FileReader("Text Files\\mail.txt");
                BufferedReader bmn = new BufferedReader(nm);
                FileReader ps = new FileReader("Text Files\\pass.txt");
                BufferedReader bps = new BufferedReader(ps);
                String nameData = bmn.readLine();
                String passData = bps.readLine();
                String nameInput = mailInput.getText();
                String paInput = passInput.getText();
                if (!nameData.equals(nameInput)) {
                    mediaPlayer2.play();
                    msg1.getStyleClass().add("textField-msg");
                    msg1.setText("Wrong Email");
                    msg1.setVisible(true);
                    reSingIn.setVisible(true);
                    reSingIn.setOnAction(e2 ->{
                        mediaPlayer1.play();
                        msg1.clear();
                        msg1.setVisible(false);
                    });
                }
                else if (!passData.equals(paInput)){
                    mediaPlayer2.play();
                    msg2.getStyleClass().add("textField-msg");
                    msg2.setText("Wrong Password");
                    msg2.setVisible(true);
                    reSingIn.setVisible(true);
                    reSingIn.setOnAction(e2 ->{
                        mediaPlayer1.play();
                        msg2.clear();
                        msg2.setVisible(false);
                    });
                }else{
                    mediaPlayer1.play();
                    msg1.setText("Log IN Success");
                    msg1.setVisible(true);
                    //CustomerDetails.showCustomerDetails("Customer Details");
                    OrderSeeWindow.Orders("Orders");
                    mailInput.clear();
                    passInput.clear();
                    bmn.close();
                    bps.close();
                    window.close();
                }

            }catch (FileNotFoundException e1){
                e1.getMessage();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        GridPane.setConstraints(signIn, 4,7);

        Button homeButton = new Button("Homepage");
        homeButton.setMinWidth(80);
        homeButton.getStyleClass().add("button-home");
        homeButton.setOnAction(e ->{
            mediaPlayer1.play();
            Main.mainframe("Happy Journey");
            window.close();
        });
        GridPane.setConstraints(homeButton,4,8);

        grid.getChildren().addAll(email,mailInput, msg1,passLabel,passInput,msg2,reSingIn,signIn,homeButton);

        Scene scene = new Scene(grid,1024,600);
        scene.getStylesheets().add("CSS%20Files/SignIn.css");
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
