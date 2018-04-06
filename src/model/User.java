package model;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User {
    private StringProperty _firstname = new SimpleStringProperty();
    private StringProperty _lastname = new SimpleStringProperty();
    private StringProperty _email = new SimpleStringProperty();
    private StringProperty _password = new SimpleStringProperty();
    private StringProperty _gender = new SimpleStringProperty();
    private StringProperty _type = new SimpleStringProperty();

    public User(){

    }

    public User(String firstname, String lastname, String email, String password, String gender, String type){
        _firstname.set(firstname);
        _lastname.set(lastname);
        _email.set(email);
        _password.set(password);
        _gender.set(gender);
        _type.setValue(type);
    }

    public String get_firstname(){
        return _firstname.get();
    }

    public void set_firstname(String _firstname){
        this._firstname.set(_firstname);
    }


    public String get_lastname(){
        return _lastname.get();
    }

    public void set_lastname(String _lastname){
        this._lastname.set(_lastname);
    }

    public String get_email(){
        return _email.get();
    }

    public void set_email(String _email){
        this._email.set(_email);
    }

    public String get_password(){
        return _password.get();
    }

    public void set_password(String _password){
        this._password.set(_password);
    }

    public void set_type(String type){
        _type.set(type);
    }

    public String get_type(){
        return this._type.get();
    }
}

