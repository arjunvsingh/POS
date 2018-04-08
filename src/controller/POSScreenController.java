package controller;

import fxapp.mainFXApplication;
import javafx.fxml.FXML;

/**
 * Created by ajspsp on 07/04/18.
 */
public class POSScreenController {

    private mainFXApplication mainFXApplication;

    public void setMainApp(mainFXApplication main) {
        mainFXApplication = main;
    }

    @FXML
     public void backButtonPressed(){
        mainFXApplication.showEmployeeMainApplicationScreen();
    }

}
