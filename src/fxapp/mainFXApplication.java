package fxapp;

import controller.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import controller.welcomeScreenController;
import java.io.IOException;
import model.*;
import javafx.scene.control.Alert;




public class mainFXApplication extends Application{

    private Stage mainScreen;
    private Pane rootLayout;
    private User currentUser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/welcomeScreen.fxml"));
        mainScreen = primaryStage;
        showWelcomeScreen();
    }

//
//    @Override
//    public void handle(ActionEvent event) {
//        if(event.getSource()== button){
//            System.out.println("clicked");
//        }
//    }

    public void showMainApplicationScreen(){

    }

    public void showWelcomeScreen(){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainFXApplication.class.getResource("../view/welcomeScreen.fxml"));
            rootLayout = loader.load();
            // Give the controller access to the main app.
            welcomeScreenController controller = loader.getController();
            controller.setMainApp(this);

            // Set the Main App title
            mainScreen.setTitle("Supermarket POS System");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void showRegistrationScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainFXApplication.class.getResource("../view/registrationScreen.fxml"));
            Pane MainAppPane = loader.load();

            registrationScreenController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(MainAppPane);
            mainScreen.setTitle("Registration");
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showPOSScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainFXApplication.class.getResource("../view/POSScreenController.fxml"));
            Pane MainAppPane = loader.load();

            POSScreenController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(MainAppPane);
            mainScreen.setTitle("Registration");
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showInventoryScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainFXApplication.class.getResource("../view/inventoryScreen.fxml"));
            Pane MainAppPane = loader.load();

            inventoryScreenController controller = loader.getController();
            controller.setMainApp(this);
            controller.initialize();

            Scene scene = new Scene(MainAppPane);
            mainScreen.setTitle("Registration");
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showEmployeeMainApplicationScreen(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainFXApplication.class.getResource("../view/employeeMainApplicationScreen.fxml"));
            Pane MainAppPane = loader.load();

            employeeMainApplicationScreenController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(MainAppPane);
            mainScreen.setTitle("Registration");
            mainScreen.setScene(scene);
            mainScreen.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Stage getStage(){
        return mainScreen;
    }

    public void showDatabaseError(){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
