package com.revature;

import com.revature.controller.VehicleController;
import com.revature.model.Vehicle;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args){

      /*
        try{
            throw new Exception();

        }

        catch (Exception e){
            e.printStackTrace(); // OR use System.out.println("");
            System.out.println("Whoops");
        }

       try {
           //throw new RuntimeException();
           //int x = 5/0; //
           File file = new File("textFoo.txt");
           FileReader reader = new FileReader(file);
        }

        catch (FileNotFoundException e){
         System.out.println("In the catch for the runtime");
        }

        catch (RuntimeException e) {
         System.out.println("");
        }

       catch(Throwable e){
        System.out.println("");
       }

      // catch(RuntimeException | FileNotFoundException e){
          // System.out.println("foo"); }

       */


        VehicleController vehicleController = new VehicleController();

        // The Javalin constructor has protected access so we can't call it directly
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx->ctx.result("Welcome to Tia's Kias!")); //localhost:8080 in web browser


        //ArrayList<Vehicle> carLot = new ArrayList<>();
       // app.get("/carLot", ctx -> ctx.result(carLot.toString() ));
        app.get("/cars", vehicleController.getAllCars );
        //app.post("/cars", vehicleController.createNewCar);
        app.post("/cars", vehicleController.setCar);
        //app.post("/cars/{id}", vehicleController.getVehicleById);

        System.out.println("Your Application has started\n");

        //object initialization
        Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        //System.out.println(input);

        String input;


        String userName = "";
        Boolean loggedInAsCustomer = false;
        Boolean loggedInAsEmployee = false;

        Customer curCustomer = null;

        ArrayList<Customer> customers = new ArrayList<>();

        ArrayList<Vehicle> cars = new ArrayList<>();
         cars.add(new Vehicle("Kia Soul_2012", 2500));
         cars.add(new Vehicle("KiaUltima", 4000));
         cars.add(new Vehicle("Soul EV_2013", 5100));
         cars.add(new Vehicle("Soul Turbo_2017", 3200));
         //Vehicle KiaSoul = new Vehicle("KiaSoul", "onLot", 2500);


        //ArrayList<fooClass> foo = new ArrayList<>();

        while(!loggedInAsCustomer && !loggedInAsEmployee) {
            System.out.println("\n");
            System.out.println("****************************");
            System.out.println("** Welcome to Tia's Kias! **");
            System.out.println("****************************");
            System.out.println("1: Login");
            System.out.println("2: Register");

            input = scanner.nextLine();

            switch (input) {
                case "1":


                        System.out.println("Enter your UserName");
                        input = scanner.nextLine();

                        if(input.equals("Tia")) {
                            System.out.println("Employee Logged in Successfully!");
                            loggedInAsEmployee = true;
                            break;

                        }else if(input.equals("")) {
                            System.out.println("Please enter a username");
                            break;


                        }else if(!input.equals("")) {
                            //for(int i = 0; i < customers.size(); i++)  System.out.println(customers.get(i).customerName);
                              Boolean custFound = false;
                                  for (Customer cs : customers)
                                   if (input.equals(cs.customerName)) {
                                    custFound = true;
                                    curCustomer = cs;
                                    System.out.println("Customer Logged in Successfully!");
                                    loggedInAsCustomer = true;
                                  }

                              if(!custFound)
                                    System.out.println("You are not registered. Please register with us!");

                                }
                          break;

                case "2":
                    System.out.println("Please Create Your UserName");
                    input = scanner.nextLine();
                    userName = input;
                    curCustomer = new Customer(userName, 0);
                    customers.add(curCustomer);
                    System.out.println("Thank you for registering! Please now log in");
                    break;


                default:
                    System.out.println("please choose an available option");
                    break;

            }
        }

            while(loggedInAsCustomer) {
                System.out.println("\n");
                System.out.println("Please Choose From the Menu " + userName + "!");
                System.out.println("1: View and purchase available cars on the lot");
                System.out.println("2: View bought cars");
                System.out.println("3: View remaining balances + Make a Payment");
                System.out.println("0: Log Out");

                input = scanner.nextLine();

                switch (input) {
                    case "0":
                        System.out.println("Good bye!");
                        loggedInAsCustomer = false;
                        break;

                    case "1":
                        System.out.println("\n");
                        System.out.println("*****************");
                        System.out.println("Viewing Inventory");
                        System.out.println("*****************");
                        for (int i = 0; i < cars.size(); i++) {
                            System.out.println(i + ": " + cars.get(i).toString());
                        }
                        System.out.println("Would you like to purchase an available vehicle? \n Please enter a ## or x to exit");
                        input = scanner.nextLine();

                        if (input == "x")
                            break;

                        if (Integer.parseInt(input) >= 0) {
                            System.out.println("****  Congratulations! **** \nYou've bought the " + cars.get(Integer.parseInt(input)).car + "!!");
                            System.out.println("Thank you for your purchase! We will add this car to your account!");
                            for (int i = 0; i < customers.size(); i++) {
                                if (customers.get(i).GetName().equals(userName))
                                    customers.get(i).AddPurchase(cars.get(Integer.parseInt(input)).price, cars.get(Integer.parseInt(input)));
                            }

                            break;
                        }


                        break;

                    case "2":
                        System.out.println("Your cars");
                        for (int i = 0; i < customers.size(); i++) {
                            if (customers.get(i).GetName().equals(userName))
                                customers.get(i).myCars();
                        }
                        break;

                    case "3":
                        System.out.println("Your total balance is $" + curCustomer.totalBalance);

                        int payment = -1;
                          while(payment < 0){
                               try{
                                   System.out.println("How much would you like to pay?");
                                   payment = scanner.nextInt();
                               } catch (InputMismatchException ex){
                                   //System.out.println(ex);
                                   System.out.println("Please enter a valid dollar amount");
                                   scanner.next();
                               }
                          }

                         curCustomer.totalBalance -= payment;
                         System.out.println("Thank you! Your total balance is now $" + curCustomer.totalBalance);
                         break;



                    default:
                       System.out.println("Please choose an available option");
                       break;
                }
            }




            while(loggedInAsEmployee){
                System.out.println("\n");
                System.out.println("Please Choose From the Menu Employee!");
                System.out.println("1: Add car to the lot");
                System.out.println("2: See offers for cars");
                System.out.println("3: Remove cars");
                System.out.println("4: View remaining payments");
                System.out.println("0: Log Out");
                input = scanner.nextLine();

                switch (input) {
                    case "0":
                }
            }


    }
}
