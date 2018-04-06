package controller;

import fxapp.mainFXApplication;
import javafx.scene.control.PasswordField;
import model.UserTypeEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.User;
import javafx.scene.control.Alert;

import java.sql.*;

/**
 * Created by ajspsp on 04/04/18.
 */
public class registrationScreenController {

    private mainFXApplication mainFXApplication;

    public void setMainApp(mainFXApplication main) {
        mainFXApplication = main;
    }

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailTextField;

    @FXML
    private ComboBox<UserTypeEnum> usertypeField;

//    @FXML
//    private void initialize() {
//        usertypeField.getItems().clear();
//        usertypeField.setItems((ObservableList<UserTypeEnum>) FXCollections.observableArrayList(UserTypeEnum.values()));
//        usertypeField.setValue(FXCollections.observableArrayList(UserTypeEnum.values()).get(0));
//    }

    @FXML
    private void backPressed() {
        mainFXApplication.showWelcomeScreen();
    }

    @FXML
    private void registerPressed() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:8888/bitsplease", "bitsplease", "bitsplease");
            stmt = conn.createStatement();
            String sql = "SELECT username FROM USER WHERE username = '" + emailTextField.getText().trim() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainFXApplication.getStage());
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("There is already a registered user with this username");
                alert.setContentText("Kindly use something else!");
                alert.showAndWait();
            } else if (emailTextField.getText() == null || passwordField.getText() == null || firstNameTextField.getText() == null|| lastNameTextField.getText() == null
                    || emailTextField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || firstNameTextField.getText().trim().isEmpty()|| lastNameTextField.getText().trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainFXApplication.getStage());
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("You left one or more fields blank!");
                alert.setContentText("You must provide your name, email and password for access to your account!");
                alert.showAndWait();
            } else {
                stmt = conn.createStatement();
                UserTypeEnum usertype = (UserTypeEnum) usertypeField.getSelectionModel().getSelectedItem();
                System.out.println(usertype.toString());
                sql = "INSERT INTO `USER` (`username`, `password`, `fullname`, `ban`, `attempt`, `type`) VALUES ('" + emailTextField.getText().trim() + "', '" + passwordField.getText() + "', '" + firstNameTextField.getText().trim() +"', '" + lastNameTextField.getText().trim() + "', '0', '0', '" + usertype.toString() +"')";
                stmt.executeUpdate(sql);
                mainFXApplication.showWelcomeScreen();
            }
        } catch(SQLException se){
            mainFXApplication.showDatabaseError();
            se.printStackTrace();
        } catch(Exception e){
            mainFXApplication.showDatabaseError();
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            } catch(SQLException se2) {
            }
            try{
                if(conn!=null)
                    conn.close();
            } catch(SQLException se){
            }
        }
    }
}
