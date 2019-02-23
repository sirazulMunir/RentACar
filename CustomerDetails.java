import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class CustomerDetails extends Main{


    public CustomerDetails()
    {
        super();
    }

    private static TextArea fileOpen;
    private static Stage window;
    static MediaPlayer mediaPlayer;

    private static String nm;
    private static String addr;
    private static String phnN;
    private static String dte;
    private static String mnth;
    private static String yer;
    private static String tme;
    private static String AMPM;
    private static String vname;
    private static Integer qntt;

    static void showCustomerDetails(String title) {

        window = new Stage();
        window.setTitle(title);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer = new MediaPlayer(clickFile);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        //Button for vehicle search individually
        Button searchVehicleButton = new Button("Search by Vehicle");
        searchVehicleButton.setMinWidth(110);
        searchVehicleButton.getStyleClass().add("button-new");
        searchVehicleButton.setOnAction(e ->{
            mediaPlayer.play();
            Search.vehicleSearch("Search");
            window.close();
        });

        //Button for see orders
        Button orderButton = new Button("Number of Orders");
        orderButton.setMinWidth(110);
        orderButton.getStyleClass().add("button-new");
        orderButton.setOnAction(e ->{
            mediaPlayer.play();
            OrderSeeWindow.Orders("Orders");
            window.close();
        });

        //Button to watch feedback
        Button feedBackButton = new Button("Feedback Messages");
        feedBackButton.setMinWidth(110);
        feedBackButton.getStyleClass().add("button-new");
        feedBackButton.setOnAction(e ->{
            mediaPlayer.play();
            FeedBackWindow.seeFeedback("Feedback Messages");
            window.close();
        } );

        //button for home
        Button homeButton =new Button("Homepage");
        homeButton.setMinWidth(110);
        homeButton.getStyleClass().add("button-new");
        homeButton.setOnAction(e->{
            mediaPlayer.play();
            Main.mainframe("Happy Journey");
            window.close();
        });

        HBox layout = new HBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(searchVehicleButton,orderButton,feedBackButton,homeButton);
        GridPane.setConstraints(layout,0,0);

        //Label for customer details
        Label cusDetails = new Label("Customer Details: ");
        GridPane.setConstraints(cusDetails,0,1);

        //Text Area for Customer details
        fileOpen = new TextArea();
        fileOpen.getStyleClass().add("textArea");
        for ( int i = 0; i < name.size(); i++){
            nm = name.get(i);
            addr = address.get(i);
            phnN = phone.get(i);
            dte = date.get(i);
            mnth = month.get(i);
            yer = year.get(i);
            tme = time.get(i);
            AMPM = ampm.get(i);
            vname = vehicleName.get(i);
            qntt = quantity.get(i);

            fileOpen.appendText("Name: " + nm + "\nAddress: " + addr + "\nPhone Number: " + phnN + "\nDate: " + dte + " " + mnth + " " + yer + "\nTime: " + tme + " " + AMPM + "\nVehicle:  " + vname + "\nQuantity: " + qntt + "\n" + "\n");
        }
        fileOpen.setEditable(false);
        fileOpen.setMinSize(200,480);
        GridPane.setConstraints(fileOpen,0,3);

        gridPane.getChildren().addAll(layout,cusDetails,fileOpen);
        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("CSS%20Files/CustomerDetails.css");
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
