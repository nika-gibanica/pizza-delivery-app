package com.agency04.sbss.pizza;

public class PizzeriaTwo implements PizzeriaService {

    public String _name;
    public String _address;

    public void setName(String _name) {
        this._name = _name;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    @Override
    public String getName(){
        return _name;
    }

    @Override
    public String getAddress(){
        return _address;
    }

    @Override
    public String makePizza(Pizza pizza_type){
        return "Making " + pizza_type;
    }

}
