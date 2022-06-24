package com.revature.controller;

import com.revature.model.Vehicle;
import com.revature.service.VehicleService;
import io.javalin.http.Handler;


/* this is designed to handle web requests for the 'car' resource
   the goal of a controller is to be able to invoke the CRUD operations that exist within the service layer
   ctx is short for context
*/

public class VehicleController {
  VehicleService vehicleService = new VehicleService();

  // READ
  // 'handler' is a functional interface
  public Handler getAllCars = ctx -> {
   //ctx.result(vehicleService.getAllCars().toString());
   ctx.result(vehicleService.getAllCarsAsString());
   //ctx.json(vehicleService.getAllCars());
  };

  //CREATE

  public Handler createSomeCar =  ctx -> {

   vehicleService.createNewCar(new Vehicle("KiaSuper", 1400));

   ctx.status(201); // send back 201 created to suggest a resource was created
  };



  public Handler setCar = ctx -> {
      // Vehicle vehicle = cyx.bodyAsClass(Vehicle.class);
      //vehicleService.createNewCar(ctx.bodyAsClass(Vehicle.class));


      String car = ctx.body().split(";")[0].trim();
      //String car = context.body().substring(0,context.body().indexOf(";");
      String price =  ctx.body().split(";")[1].trim();

      System.out.println("Added a car to the lot!");

      Vehicle v = new Vehicle(car, Integer.valueOf(price));

      VehicleService.createNewCar(v);


      /*
      try{
       int id = Integer.parseInt(param);
       }
       catch(NumberFormatException e){
        context.result("Stop entering words as IDs!");
        context.status(400); //Bad Request!
       }
       */

     // ctx.result("Vehicle Added Successfully!");
   };

}
