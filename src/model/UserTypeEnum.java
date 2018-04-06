package model;

/**
 * Created by ajspsp on 06/04/18.
 */
public enum UserTypeEnum {
    USER("user"), EMPLOYEE("employee"), CUSTOMER("customer");

    private String databaseRepresentation;

    private UserTypeEnum(String databaseRepresentation) {
        this.databaseRepresentation = databaseRepresentation;
    }

    public String toString() {
        return databaseRepresentation;
    }
}
