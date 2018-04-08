package controller;

import fxapp.mainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by ajspsp on 06/04/18.
 */
public class employeeMainApplicationScreenController {

    @FXML
    Button posButton;

    @FXML
    Button inventoryButton;

    mainFXApplication mainFXApplication;

    public void setMainApp(mainFXApplication main) {
        mainFXApplication = main;
    }

    @FXML
    private void POSButtonPressed(){
        mainFXApplication.showPOSScreen();
    }
    @FXML
    private void inventoryButtonPressed(){
        mainFXApplication.showInventoryScreen();
    }


}
