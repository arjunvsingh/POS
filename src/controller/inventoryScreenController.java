package controller;

import fxapp.mainFXApplication;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.UserTypeEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.User;
import sun.java2d.pipe.SpanShapeRenderer;


import java.net.SocketImpl;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.Predicate;

/**
 * Created by ajspsp on 06/04/18.
 */
public class inventoryScreenController {

    private mainFXApplication mainFXApplication;

    @FXML
    private TextField search;

    ObservableList list = FXCollections.observableArrayList(
            new Std(1,"Hello", 2, 4, "new"),
            new Std(1,"World", 2, 4, "new"),
            new Std(1,"Cat", 2, 4, "new"),
            new Std(1,"Dog", 2, 4, "new")
    );

    @FXML
    private TableView<Std> tbl = new TableView<>(list);

    @FXML
    private TableColumn<Std, Integer> id;

    @FXML
    private TableColumn<Std, String> name;

    @FXML
    private TableColumn<Std, Integer> qty;

    @FXML
    private TableColumn<Std, Integer> price;

    @FXML
    private TableColumn<Std, String> category;



    FilteredList filter = new FilteredList(list, e->true);


    public void initialize(){
        tbl.setItems(list);
        id.setCellFactory(new PropertyValueFactory("id"));
        name.setCellFactory(new PropertyValueFactory("name"));
        qty.setCellFactory(new PropertyValueFactory("qty"));
        price.setCellFactory(new PropertyValueFactory("price"));
        category.setCellFactory(new PropertyValueFactory("category"));
        tbl.setItems(list);


    }

    @FXML
    private void search (KeyEvent event){
        search.textProperty().addListener((observable, oldvalue, newValue) -> {
            filter.setPredicate((Predicate<? super Std>) (Std std)->{
                if(newValue.isEmpty() || newValue == null){
                    return true;
                } else if(std.get_name().contains(newValue)){
                    return true;
                }

                return false;
            });
        });

        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tbl.comparatorProperty());
        tbl.setItems(sort);
    }



    public void setMainApp(mainFXApplication main) {
        mainFXApplication = main;


    }

    @FXML
    public void backButtonPressed(){
        mainFXApplication.showEmployeeMainApplicationScreen();
    }

    public class Std{
        private int _id;
        private SimpleStringProperty _name;
        private int _qty;
        private int _price;
        private SimpleStringProperty _category;

        public Std(int id, String name, int qty, int price, String category){
            this._id = id;
            this._name = new SimpleStringProperty(name);
            this._qty = qty;
            this._price = price;
            this._category = new SimpleStringProperty(category);

        }

        public int get_id(){
            return _id;
        }

        public String get_name(){
            return _name.get();
        }

        public int get_qty(){
            return _qty;
        }

        public int get_price(){
            return _price;
        }

        public String get_category(){
            return _category.get();
        }
    }


}
