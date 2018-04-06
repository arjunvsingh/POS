package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ajspsp on 05/04/18.
 */
public abstract class Item {
    private StringProperty _itemName;
    private IntegerProperty _quantity;
    private IntegerProperty _price;

    public Item(String itemName, Integer quantity, Integer price){
        _itemName.set(itemName);
        _quantity.set(quantity);
        _price.set(price);
    }

    public String get_itemName(){
        return _itemName.get();
    }

    public void set_itemName(String _itemname){
        this._itemName.set(_itemname);
    }

    public String get_quantity(){
        return _itemName.get();
    }

    public void set_quantity(String _firstname){
        this._itemName.set(_firstname);
    }
}
