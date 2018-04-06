package model;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.print.DocFlavor;

/**
 * Created by ajspsp on 05/04/18.
 */
public class Employee extends User{

    public Employee(String firstName, String lastName, String email, String password, String gender){
        super(firstName, lastName, email, password, gender, "Employee");
    }
}
