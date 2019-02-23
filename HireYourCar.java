import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.*;


public class HireYourCar extends Main{

    public HireYourCar(){
        super();
    }


    private static Stage window;
    private static TextField nameInput, nameInputMsg, addressInput, addressInputMsg, dateBoxMsg, monthBoxMsg,yearBoxMsg,timeBoxMsg, ampmBoxMsg, phnInput, phnInputMsg,wrVehivlenameMsg, vehicleQuantity, vehicleQuantityMsg;
    private static ComboBox<String> timeBox, ampmBox, dateBox,monthBox,yearBox, vehicleBox;
    private static ComboBox<Integer>quantityBox;
    static TableView<Vehicles> vehicleTable;
    private static Button submitButton ,tryButton;

    static MediaPlayer mediaPlayer1;
    static MediaPlayer mediaPlayer2;


    static void booking(String title) {
        window = new Stage();
        window.setTitle(title);

        Media clickFile = new Media("Sound/button3.mp3");
        mediaPlayer1 = new MediaPlayer(clickFile);

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        //Name Label
        Label availableCars = new Label("Available Cars for Hire with Price");
        GridPane.setConstraints(availableCars, 1, 0);

        //name column
        TableColumn<Vehicles, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.getStyleClass().add("table");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //price column
        TableColumn<Vehicles, String> priceColumn = new TableColumn<>("Price/hour");
        priceColumn.setMinWidth(200);
        priceColumn.getStyleClass().add("table");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        vehicleTable = new TableView<>();
        vehicleTable.setItems(getVehiclesInTable());
        vehicleTable.getColumns().addAll(nameColumn, priceColumn);
        GridPane.setConstraints(vehicleTable, 1, 1);

        //Name Label
        Label nameLabel = new Label("Full Name");
        GridPane.setConstraints(nameLabel, 0, 2);

        //Name Input
        nameInput = new TextField();
        nameInput.getStyleClass().add("textField");
        nameInput.setPromptText("Name");
        GridPane.setConstraints(nameInput, 1, 2);

        //Wrong name input Message
        nameInputMsg = new TextField();
        nameInputMsg.getStyleClass().add("textField-msg");
        nameInputMsg.setVisible(false);
        nameInputMsg.setEditable(false);
        GridPane.setConstraints(nameInputMsg,2,2);

        //Address Label
        Label addressLabel = new Label("Pick Up Address");
        GridPane.setConstraints(addressLabel, 0, 3);

        //Address Input
        addressInput = new TextField();
        addressInput.getStyleClass().add("textField");
        addressInput.setPromptText("Address");
        GridPane.setConstraints(addressInput, 1, 3);

        //Address msg
        addressInputMsg = new TextField();
        addressInputMsg.getStyleClass().add("textField-msg");
        addressInputMsg.setVisible(false);
        addressInputMsg.setEditable(false);
        GridPane.setConstraints(addressInputMsg,2,3);

        //Phone Number Label
        Label phnLabel = new Label("Your Phone Number");
        GridPane.setConstraints(phnLabel, 0, 4);

        //Phone Number Input massage
        phnInput = new TextField();
        phnInput.getStyleClass().add("textField");
        phnInput.setPromptText("Phone Number");
        GridPane.setConstraints(phnInput, 1, 4);

        //Phone Number Input
        phnInputMsg = new TextField();
        phnInputMsg.getStyleClass().add("textField-msg");
        phnInputMsg.setVisible(false);
        phnInputMsg.setEditable(false);
        GridPane.setConstraints(phnInputMsg, 2,4);

        //Pick Up Date Label
        Label pickupDateLabel = new Label("Pick Up Date");
        GridPane.setConstraints(pickupDateLabel, 0, 5);

        dateBox = new ComboBox<>();
        dateBox.setMinWidth(160);
        dateBox.getStyleClass().add("comboBox");
        dateBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31"

        );
        dateBox.setPromptText("Select Date");
        GridPane.setConstraints(dateBox, 1, 5);

        //Date Message
        dateBoxMsg = new TextField();
        dateBoxMsg.getStyleClass().add("textField-msg");
        dateBoxMsg.setVisible(false);
        dateBoxMsg.setEditable(false);
        GridPane.setConstraints(dateBoxMsg,2,5);

        //Pick Up Month Label
        Label pickupMonthLabel = new Label("Pick Up Month");
        GridPane.setConstraints(pickupMonthLabel, 0, 6);

        //Pick Up Month
        monthBox = new ComboBox<>();
        monthBox.setMinWidth(160);
        monthBox.getStyleClass().add("comboBox");
        monthBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
        monthBox.setPromptText("Select Month");
        GridPane.setConstraints(monthBox,1,6);

        //Month message
        monthBoxMsg = new TextField();
        monthBoxMsg.getStyleClass().add("textField-msg");
        monthBoxMsg.setVisible(false);
        monthBoxMsg.setEditable(false);
        GridPane.setConstraints(monthBoxMsg,2,6);

        //Pick Up Year Label
        Label pickupYearLabel = new Label("Pick Up Year");
        GridPane.setConstraints(pickupYearLabel, 0, 7);

        yearBox = new ComboBox<>();
        yearBox.setMinWidth(160);
        yearBox.getStyleClass().add("comboBox");
        yearBox.getItems().addAll(
                "2017",
                "2018",
                "2019",
                "2020",
                "2021"
        );
        yearBox.setPromptText("Select Year");
        GridPane.setConstraints(yearBox,1,7);

        //year message
        yearBoxMsg = new TextField();
        yearBoxMsg.getStyleClass().add("textField-msg");
        yearBoxMsg.setVisible(false);
        yearBoxMsg.setEditable(false);
        GridPane.setConstraints(yearBoxMsg,2,7);


        //Pick Up Time Label
        Label pickuptimeLabel = new Label("Pick Up Time");
        GridPane.setConstraints(pickuptimeLabel, 0, 8);

        //Pick Up time Input
        timeBox = new ComboBox<>();
        timeBox.setMinWidth(160);
        timeBox.getStyleClass().add("comboBox");
        timeBox.getItems().addAll(
                "12:00",
                "12:15",
                "12:30",
                "12:45",
                "1:00",
                "1:15",
                "1:30",
                "1:45",
                "2:00",
                "2:15",
                "2:30",
                "2:45",
                "3:00",
                "3:15",
                "3:30",
                "3:45",
                "4:00",
                "4:15",
                "4:30",
                "4:45",
                "5:00",
                "5:15",
                "5:30",
                "5:45",
                "6:00",
                "6:15",
                "6:30",
                "6:45",
                "7:00",
                "7:15",
                "7:30",
                "7:45",
                "8:00",
                "8:15",
                "8:30",
                "8:45",
                "9:00",
                "9:15",
                "9:30",
                "9:45",
                "10:00",
                "10:15",
                "10:30",
                "10:45",
                "11:00",
                "11:15",
                "11:30",
                "11:45"
        );
        timeBox.setPromptText("Select Time");
        GridPane.setConstraints(timeBox, 1, 8);


        //Wrong time input message
        timeBoxMsg = new TextField();
        timeBoxMsg.getStyleClass().add("textField-msg");
        timeBoxMsg.setVisible(false);
        timeBoxMsg.setEditable(false);
        GridPane.setConstraints(timeBoxMsg,2,8);

        //AM/Pm Label
        Label ampmLabel = new Label("Select AM/PM");
        GridPane.setConstraints(ampmLabel, 0, 9);

        //Choice Boxes AM/PM
        ampmBox = new ComboBox<>();
        ampmBox.setMinWidth(160);
        ampmBox.getStyleClass().add("comboBox");
        ampmBox.getItems().addAll(
                "AM",
                "PM"
        );
        ampmBox.setPromptText("Select AM/PM");
        GridPane.setConstraints(ampmBox, 1, 9);

        //Message for wrong input of am/pm
        ampmBoxMsg = new TextField();
        ampmBoxMsg.getStyleClass().add("textField-msg");
        ampmBoxMsg.setVisible(false);
        ampmBoxMsg.setEditable(false);
        GridPane.setConstraints(ampmBoxMsg,2,9);


        //Select Vehicle  Label
        Label vehicleLabel = new Label("Select Your Vehicle");
        GridPane.setConstraints(vehicleLabel, 0, 10);

        //Write vehicle name
        vehicleBox = new ComboBox<>();
        vehicleBox.setMinWidth(160);
        vehicleBox.getStyleClass().add("comboBox");
        vehicleBox.getItems().addAll(
                "Taxi Cab",
                "Toyota",
                "Nissan",
                "BMW",
                "AUDI",
                "Mercedes Benz",
                "Jaguar",
                "Bentley"
        );
        vehicleBox.setPromptText("Vehicle Name");
        GridPane.setConstraints(vehicleBox, 1, 10);

        //wrong vehicle input massage
        wrVehivlenameMsg = new TextField();
        wrVehivlenameMsg.getStyleClass().add("textField-msg");
        wrVehivlenameMsg.setVisible(false);
        wrVehivlenameMsg.setEditable(false);
        GridPane.setConstraints(wrVehivlenameMsg, 2, 10);

        //Select Vehicle  Label
        Label vehicleQuantityLabel = new Label("Select Vehicle Quantity");
        GridPane.setConstraints(vehicleQuantityLabel, 0, 11);

        //Write vehicle name
        quantityBox = new ComboBox<>();
        quantityBox.setMinWidth(160);
        quantityBox.getStyleClass().add("comboBox");
        quantityBox.getItems().addAll(
                1,
                2,
                3,
                4
        );
        quantityBox.setPromptText("Select Quantity");
        GridPane.setConstraints(quantityBox, 1, 11);

        //Wrong vehicle quantity input message
        vehicleQuantityMsg = new TextField();
        vehicleQuantityMsg.getStyleClass().add("textField-msg");
        vehicleQuantityMsg.setVisible(false);
        vehicleQuantityMsg.setEditable(false);
        GridPane.setConstraints(vehicleQuantityMsg,2,11);

        //Try Again Button
        tryButton = new Button("Try Again");
        tryButton.setMinWidth(120);
        tryButton.getStyleClass().add("button-red");
        tryButton.setVisible(false);
        GridPane.setConstraints(tryButton,1,14);

        //Submit hire
        submitButton = new Button("Submit Booking");
        submitButton.setMinWidth(120);
        submitButton.setOnAction(e -> {
            mediaPlayer1.play();
            addCustomerDetails();
        });
        GridPane.setConstraints(submitButton, 1, 16);

        Button homeButton =new Button("Homepage");
        homeButton.setMinWidth(120);
        homeButton.getStyleClass().add("button-home");
        homeButton.setOnAction(e->{
            mediaPlayer1.play();
            Main.mainframe("Happy Journey");
            window.close();
        });
        GridPane.setConstraints(homeButton, 1, 18);

        gridPane.getChildren().addAll(availableCars, vehicleTable, nameLabel, nameInput,nameInputMsg, addressLabel, addressInput,addressInputMsg, phnLabel, phnInput,phnInputMsg, pickupDateLabel,dateBox, dateBoxMsg,pickupMonthLabel,monthBox,monthBoxMsg,pickupYearLabel,yearBox,yearBoxMsg, pickuptimeLabel, timeBox,timeBoxMsg, ampmLabel, ampmBox,ampmBoxMsg,vehicleLabel, vehicleBox, wrVehivlenameMsg,  vehicleQuantityLabel, quantityBox,vehicleQuantityMsg,tryButton, submitButton,homeButton);
        Scene scene = new Scene(gridPane,1024,600);
        scene.getStylesheets().add("CSS%20Files/HireYourCar.css");
        window.setScene(scene);
        window.show();



    }

   private static void addCustomerDetails()  {

        String empty = "";

       Media clickFile = new Media("Sound/button3.mp3");
       mediaPlayer1 = new MediaPlayer(clickFile);

       Media warningFile = new Media("Sound/warning.mp3");
       mediaPlayer2 = new MediaPlayer(warningFile);

        //Sending Customer details

        if (empty.equals(nameInput.getText()) || nameInput.getText().contains("1") || nameInput.getText().contains("0") || nameInput.getText().contains("2") || nameInput.getText().contains("3") || nameInput.getText().contains("4") || nameInput.getText().contains("5") || nameInput.getText().contains("6") ||nameInput.getText().contains("7") ||nameInput.getText().contains("8") ||nameInput.getText().contains("9") ||nameInput.getText().contains("+") || nameInput.getText().contains("-") || nameInput.getText().contains("*") || nameInput.getText().contains("/") || nameInput.getText().contains(":") || nameInput.getText().contains("?") || nameInput.getText().contains("<") || nameInput.getText().contains(">") || nameInput.getText().contains(";") ){
            mediaPlayer2.play();
            nameInputMsg.setText("Write Your name");
            nameInputMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                nameInputMsg.clear();
                nameInputMsg.setVisible(false);
            });
        }else if (empty.equals(addressInput.getText())){
            mediaPlayer2.play();
            addressInputMsg.setText("Write Address");
            addressInputMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                addressInputMsg.clear();
                addressInputMsg.setVisible(false);
            });
        }else if (empty.equals(phnInput.getText()) || phnInput.getText().length() != 11 ){
            mediaPlayer2.play();
            phnInputMsg.setText("Write Phone Number");
            phnInputMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                phnInputMsg.clear();
                phnInputMsg.setVisible(false);
            });
        }else if ((dateBox.getValue()) == null){
            mediaPlayer2.play();
            dateBoxMsg.setText("Select Date");
            dateBoxMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                dateBoxMsg.clear();
                dateBoxMsg.setVisible(false);
            });
        }else if ((monthBox.getValue()) == null){
            mediaPlayer2.play();
            monthBoxMsg.setText("Select Month");
            monthBoxMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                monthBoxMsg.clear();
                monthBoxMsg.setVisible(false);
            });
        }else if ((yearBox.getValue()) == null){
            mediaPlayer2.play();
            yearBoxMsg.setText("Select Year");
            yearBoxMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                yearBoxMsg.clear();
                yearBoxMsg.setVisible(false);
            });
        }else if ((timeBox.getValue()) == null) {
            mediaPlayer2.play();
            timeBoxMsg.setText("Select Time");
            timeBoxMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                timeBoxMsg.clear();
                timeBoxMsg.setVisible(false);
            });
        }else if ((ampmBox.getValue()) == null) {
            mediaPlayer2.play();
            ampmBoxMsg.setText("Select Am/Pm");
            ampmBoxMsg.setVisible(true);
            ampmBoxMsg.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                ampmBoxMsg.clear();
                ampmBoxMsg.setVisible(false);
            });
        }else if ((vehicleBox.getValue()) == null){
            mediaPlayer2.play();
            wrVehivlenameMsg.setText("Write Vehicle Name");
            wrVehivlenameMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                wrVehivlenameMsg.clear();
                wrVehivlenameMsg.setVisible(false);
            });
        }else if ((quantityBox.getValue()) == null){
            mediaPlayer2.play();
            vehicleQuantityMsg.setText("Select Quantity");
            vehicleQuantityMsg.setVisible(true);
            tryButton.setVisible(true);
            tryButton.setOnAction(e ->{
                mediaPlayer1.play();
                vehicleQuantityMsg.clear();
                vehicleQuantityMsg.setVisible(false);
            });
        }else{
                try {
                    //inputs
                    BufferedWriter nameWriter = new BufferedWriter(new FileWriter("Text Files\\name.txt",true));
                    BufferedWriter addressWriter = new BufferedWriter(new FileWriter("Text Files\\address.txt",true));
                    BufferedWriter phnWriter = new BufferedWriter(new FileWriter("Text Files\\phone.txt",true));
                    BufferedWriter dateWriter = new BufferedWriter(new FileWriter("Text Files\\date.txt",true));
                    BufferedWriter monthWriter = new BufferedWriter(new FileWriter("Text Files\\month.txt",true));
                    BufferedWriter yearWriter = new BufferedWriter(new FileWriter("Text Files\\year.txt",true));
                    BufferedWriter timeWriter = new BufferedWriter(new FileWriter("Text Files\\time.txt",true));
                    BufferedWriter ampmWriter = new BufferedWriter(new FileWriter("Text Files\\ampm.txt",true));
                    BufferedWriter vehicleWriter = new BufferedWriter(new FileWriter("Text Files\\vehiclename.txt",true));
                    BufferedWriter quantityWriter = new BufferedWriter(new FileWriter("Text Files\\quantity.txt",true));


                    nameWriter.write(" " + nameInput.getText());
                    nameWriter.write("\n");
                    addressWriter.write(" " + addressInput.getText());
                    addressWriter.write("\n");
                    phnWriter.write(" " + phnInput.getText());
                    phnWriter.write("\n");
                    dateWriter.write(" " + dateBox.getValue());
                    dateWriter.write("\n");
                    monthWriter.write(" "+ monthBox.getValue());
                    monthWriter.write("\n");
                    yearWriter.write(" " + yearBox.getValue());
                    yearWriter.write("\n");
                    timeWriter.write(" " + timeBox.getValue());
                    timeWriter.write("\n");
                    ampmWriter.write(" " + ampmBox.getValue());
                    ampmWriter.write("\n");
                    vehicleWriter.write(" " + vehicleBox.getValue());
                    vehicleWriter.write("\n");
                    quantityWriter.write(" " + quantityBox.getValue());
                    quantityWriter.write("\n");

                    nameWriter.close();
                    addressWriter.close();
                    phnWriter.close();
                    dateWriter.close();
                    monthWriter.close();
                    yearWriter.close();
                    timeWriter.close();
                    ampmWriter.close();
                    vehicleWriter.close();
                    quantityWriter.close();


                    tryButton.setVisible(false);
                    nameInput.clear();
                    addressInput.clear();
                    phnInput.clear();
                    nameInputMsg.setVisible(false);
                    addressInputMsg.setVisible(false);
                    phnInputMsg.setVisible(false);

                    dateBox.getSelectionModel().clearSelection();
                    monthBox.getSelectionModel().clearSelection();
                    yearBox.getSelectionModel().clearSelection();
                    timeBox.getSelectionModel().clearSelection();
                    ampmBox.getSelectionModel().clearSelection();
                    vehicleBox.getSelectionModel().clearSelection();
                    quantityBox.getSelectionModel().clearSelection();

                    dateBoxMsg.clear();
                    dateBoxMsg.setVisible(false);
                    monthBoxMsg.clear();
                    monthBoxMsg.setVisible(false);
                    yearBoxMsg.clear();
                    yearBoxMsg.setVisible(false);
                    timeBoxMsg.clear();
                    timeBoxMsg.setVisible(false);
                    ampmBoxMsg.clear();
                    ampmBoxMsg.setVisible(false);
                    wrVehivlenameMsg.clear();
                    wrVehivlenameMsg.setVisible(false);
                    vehicleQuantityMsg.clear();
                    vehicleQuantityMsg.setVisible(false);

                }catch (IOException e) {
                    e.printStackTrace();
                }
        }
   }


    private static ObservableList<Vehicles> getVehiclesInTable(){
        ObservableList<Vehicles> vehicles = FXCollections.observableArrayList();
        vehicles.add(new Vehicles("Taxi Cab",300));
        vehicles.add(new Vehicles("Toyota",350));
        vehicles.add(new Vehicles("Nissan",370));
        vehicles.add(new Vehicles("BMW",600));
        vehicles.add(new Vehicles("AUDI",610));
        vehicles.add(new Vehicles("Mercedes Benz",620));
        vehicles.add(new Vehicles("Jaguar",630));
        vehicles.add(new Vehicles("Bentley",650));
        return vehicles;
    }



    private static void closeProgram(){
        boolean answer = ConfirmBox.display("Confirm Box","Want to close the Program?");
        if (answer){
            window.close();
        }
    }
}
