package com.revature;

import com.revature.model.Vehicle;

import java.util.ArrayList;

public class Customer {
    String customerName = "";
    Integer totalBalance = 0;
    Vehicle car = new Vehicle();
    ArrayList<Vehicle> cars = new ArrayList<>();


    Customer(String customerName, Integer totalBalance){
        this.customerName = customerName;
        this.totalBalance = totalBalance;
        //this.cars.add(car);
    }



    public void AddPurchase(Integer cost, Vehicle car){
        this.totalBalance += cost;
        this.cars.add(car);
    }

    public String GetName(){
        return this.customerName;
    }



    void myCars(){
       for(int i = 0; i < cars.size(); i++) {
        System.out.println(i + ": " + cars.get(i));

       }
    }
}
