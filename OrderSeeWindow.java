import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class OrderSeeWindow extends Main{

    public OrderSeeWindow(){
        super();
    }

    private static Stage window;
    private static TextField order,viewNumofVcle;
    static MediaPlayer mediaPlayer;


    static void Orders(String title) {
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

        //Button for Customer Details
        Button adminButton = new Button("Customer Details");
        adminButton.getStyleClass().add("button-admin");
        adminButton.setOnAction(e ->{
            mediaPlayer.play();
            CustomerDetails.showCustomerDetails("Customer Details");
            window.close();
        });

        //Button for vehicle search individually
        Button viewVehicle = new Button("Search by Vehicle");
        viewVehicle.getStyleClass().add("button-admin");
        viewVehicle.setOnAction(e ->{
            mediaPlayer.play();
            Search.vehicleSearch("Search");
            window.close();
        });

        //Button for Feedback window
        //Button to watch feedback
        Button feedBackButton = new Button("Feedback Messages");
        feedBackButton.getStyleClass().add("button-admin");
        feedBackButton.setOnAction(e ->{
            mediaPlayer.play();
            FeedBackWindow.seeFeedback("Feedback Messages");
            window.close();
        } );

        //Button for home
        Button homeButton = new Button("Homepage");
        homeButton.getStyleClass().add("button-admin");
        homeButton.setOnAction(e ->{
            mediaPlayer.play();
            Main.mainframe("Happy Journey");
            window.close();
        });

        HBox layout = new HBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(adminButton,viewVehicle,feedBackButton,homeButton);
        GridPane.setConstraints(layout,0,0);


        //label for see order
        Label seeOrder = new Label("Total Number of Order for Hire: ");
        GridPane.setConstraints(seeOrder,0,1);

        //TextField for see the orders
        order = new TextField();
        order.setMinSize(300,50);
        order.setEditable(false);
        order.appendText("Total Number of Customer: " + " "+ String.valueOf(name.size()));
        order.getStyleClass().add("textField");
        GridPane.setConstraints(order,0,3);

        //Label for See ordered vehicle
        Label carNumber = new Label("Total Number of Cars Ordered:");
        GridPane.setConstraints(carNumber,0,5);

        viewNumofVcle = new TextField();
        viewNumofVcle.setMinSize(300,50);
        viewNumofVcle.setEditable(false);
        int count = 0;
        for(int i = 0; i < quantity.size(); i++){
            count = count + (quantity.get(i)) ;
        }
        viewNumofVcle.appendText(String.valueOf("Total Number of Car Ordered: " + " " +count));
        viewNumofVcle.getStyleClass().add("textField");
        GridPane.setConstraints(viewNumofVcle,0,7);

        gridPane.getChildren().addAll(layout,seeOrder,order,carNumber,viewNumofVcle);
        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("file:////C:/Users/USER/IdeaProjects/Rent%20A%20Car/src/CSS%20Files/OrderSeeWindow.css");
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
