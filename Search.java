import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Search extends Main{

    public Search(){
        super();
    }

    private static Stage window;
    private static TextArea result;
    private static TextField vehicleSearch;
    static MediaPlayer mediaPlayer;

    private static String nm;
    private static String addr;
    private static String phnN;
    private static String dte;
    private static String mnth;
    private static String yer;
    private static String tme;
    private static String AMPM;
    private static Integer qntt;

    static void vehicleSearch(String title){
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


        //Button for see orders
        Button orderButton = new Button("Number of Orders");
        orderButton.setMinWidth(110);
        orderButton.getStyleClass().add("button-admin");
        orderButton.setOnAction(e ->{
            mediaPlayer.play();
            OrderSeeWindow.Orders("Orders");
            window.close();
        });

        //Button for Customer Details
        Button customerDetailsButton = new Button("Customer Details");
        customerDetailsButton.setMinWidth(110);
        customerDetailsButton.getStyleClass().add("button-admin");
        customerDetailsButton.setOnAction(e ->{
            mediaPlayer.play();
            CustomerDetails.showCustomerDetails("Customer Details");
            window.close();
        });

        //Button to watch feedback
        Button feedBackButton = new Button("Feedback Messages");
        feedBackButton.setMinWidth(110);
        feedBackButton.getStyleClass().add("button-admin");
        feedBackButton.setOnAction(e ->{
            mediaPlayer.play();
            FeedBackWindow.seeFeedback("Feedback Messages");
            window.close();
        } );

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
        layout.getChildren().addAll(orderButton,customerDetailsButton,feedBackButton,homeButton);
        GridPane.setConstraints(layout,0,0);

        //Label for Vehicle name
        Label nameVcl = new Label("Write Vehicle Name");
        GridPane.setConstraints(nameVcl,0,1);

        //textFiled for Searching vehicle
        vehicleSearch = new TextField();
        vehicleSearch.setPromptText("Vehicle Name");
        GridPane.setConstraints(vehicleSearch,0,2);

        //Button for search
        Button search = new Button("Search");
        search.setOnAction(e ->{
            mediaPlayer.play();
            if (vehicleSearch.getText().equals("")){
                result.appendText("Please Write Vehicle name first!!\n\n");
            }else if (!vehicleSearch.getText().equals("")) {
                for (int i = 0; i < vehicleName.size(); i++) {
                    if (vehicleName.get(i).contains(vehicleSearch.getText())) {
                        nm = name.get(i);
                        addr = address.get(i);
                        phnN = phone.get(i);
                        dte = date.get(i);
                        mnth = month.get(i);
                        yer = year.get(i);
                        tme = time.get(i);
                        AMPM = ampm.get(i);
                        qntt = quantity.get(i);

                        result.appendText("\nName: " + nm + "\nAddress: " + addr + "\nPhone Number: " + phnN + "\nDate: " + dte + " " + mnth + " " + yer + "\nTime: " + tme + " " + AMPM + "\nQuantity: " + qntt + "\n" + "\n");
                    }
                }
            }else{
                result.appendText(vehicleSearch.getText() + " " + " is not Hired\n");
            }
        });
        GridPane.setConstraints(search,0,3);

        //TextArea for result
        result = new TextArea();
        result.setMinSize(200,300);
        result.setEditable(false);
        result.getStyleClass().add("textArea");
        GridPane.setConstraints(result,0,4);

        //Button for clear
        Button resultClear = new Button("Clear Search");
        resultClear.setOnAction(e -> {
            mediaPlayer.play();
            result.clear();
            vehicleSearch.clear();
        });
        GridPane.setConstraints(resultClear,0,5);


        gridPane.getChildren().addAll(layout,nameVcl,vehicleSearch,search,result, resultClear);
        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("CSS%20Files/Search.css");
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
