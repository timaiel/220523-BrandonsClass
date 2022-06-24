package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {

    public String car = "";
    public Integer price = 2000;


    public Vehicle(){

    }


     public Vehicle(String car, int price){
        this.car = car;
        this.price = price;
    }




    void setVehicle(String car, Integer price){
        this.car = car;
        this.price = price;
    }



     public String getCar(){
        return this.car;
     }

     public Integer getPrice(){
        return this.price;
     }

     public void setPrice(Integer price){
        this.price = price;
     }

     //  shortcut is alt + insert to make a toString
     @Override
     public String toString(){
        return "[" + this.car +", " + "balance $" + this.price + "]";
     }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(car, vehicle.car) && Objects.equals(price, vehicle.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, price);
    }
}
