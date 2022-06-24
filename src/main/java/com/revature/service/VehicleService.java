package com.revature.service;

import com.revature.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
  private static ArrayList<Vehicle> cars = new ArrayList<>();


  public VehicleService(){
    cars.add(new Vehicle("KiaHamsterWheel", 230));
    cars.add(new Vehicle("KiaWasherMachineOnWheel", 470));
    cars.add(new Vehicle("KiaSpaceShipVroomDoom", 775));
  }

  // CREATE - adds a new card to the list
  public static void createNewCar(Vehicle vehicle){

    cars.add(vehicle);
  }


  // READ - returns the list
  public ArrayList<Vehicle> getAllCars(){

    return cars;
  }



  public String getAllCarsAsString(){
    List<Vehicle> cars = getAllCars();
    StringBuilder builder = new StringBuilder();
    //String carsString = "";

    for(Vehicle car : cars){
      builder.append(car.car).append("\n")
              .append(car.price).append("\n\n");
      //carsString += car.car + "\n";
     // carsString += car.price + "\n\n";
    }
    //return carsString;
    return builder.toString();
  }

  public int carCount(){
    return cars.size();
  }
  // UPDATE
  // DELETE


}
