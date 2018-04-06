package model;

import javax.print.DocFlavor;

/**
 * Created by ajspsp on 05/04/18.
 */
public class Customer extends User {
    public Customer(String firstName, String lastName, String email, String password, String gender){
        super(firstName, lastName, email, password, gender, "Customer");
    }
}
