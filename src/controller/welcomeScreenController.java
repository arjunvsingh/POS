package controller;
import fxapp.mainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import model.User;
import model.UserTypeEnum;

import java.sql.*;


/**
 * Created by ajspsp on 05/04/18.
 */
public class welcomeScreenController {
    private mainFXApplication mainFXApplication;

    @FXML
    private TextField email;

    @FXML
    private PasswordField passwordField;

    private User currentUser;


    public void setMainApp(mainFXApplication main) {
        mainFXApplication = main;
    }
    @FXML
    private void loginButtonPressed() {

        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/bitsplease", "bitsplease", "bitsplease");
            stmt = conn.createStatement();
            String sql = "SELECT username, password, firstname, lastname, type, email, FROM USER WHERE username = '" + email.getText().trim() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainFXApplication.getStage());
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Incorrect email!");
                alert.showAndWait();
            } else {
                if (checkUserCredentials(rs)) {
                    currentUser.set_firstname(rs.getString("username"));
                    currentUser.set_lastname(rs.getString("fullname"));
                    currentUser.set_email(rs.getString("email"));

                    if (currentUser.get_type().equals(UserTypeEnum.EMPLOYEE.toString())) {
                        mainFXApplication.showEmployeeMainApplicationScreen();
                    } else {
                        mainFXApplication.showMainApplicationScreen();
                    }

                }
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

    private boolean checkUserCredentials(ResultSet rs) {
        try {
            if (rs.getInt("attempt") > 2 && !rs.getString("type").equals(UserTypeEnum.EMPLOYEE.toString())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainFXApplication.getStage());
                alert.setTitle("Account Locked!");
                alert.setHeaderText("You have more than 3 incorrect logins OR your account was locked by an admin!");
                alert.setContentText("Contact an Admin to resolve!");
                alert.showAndWait();
                return false;
            } else {
                if ((rs.getString("password").equals(passwordField.getText()))) {
                    Connection conn = null;
                    Statement stmt = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/bitsplease", "bitsplease", "bitsplease");
                    stmt = conn.createStatement();
                    String sql = "UPDATE USER SET attempt = '0' WHERE username = '" + email.getText() + "'";
                    stmt.executeUpdate(sql);
                    return true;
                } else {
                    int newAttempt = rs.getInt("attempt") + 1;
                    Connection conn = null;
                    Statement stmt = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/bitsplease", "bitsplease", "bitsplease");
                    stmt = conn.createStatement();
                    String sql = "UPDATE USER SET attempt = '" + newAttempt + "' WHERE username = '" + email.getText() + "'";
                    stmt.executeUpdate(sql);

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(mainFXApplication.getStage());
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Incorrect password!");
                    alert.showAndWait();
                    return false;


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @FXML
    private void registerButtonPressed() {
        mainFXApplication.showRegistrationScreen();
    }

}
