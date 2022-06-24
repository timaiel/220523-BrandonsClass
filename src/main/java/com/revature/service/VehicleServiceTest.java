package com.revature.service;

public class VehicleServiceTest {

  public void foo(){
      System.out.println("blah");
  }
/*
   List<Vehicle> mockList = Mockito.mock(List.class);

 @Test
  public void whenGivenVehicleObjectCreateNewVehicleAddsDoesNotThrowAnException(){
    Vehicle car = new Vehicle();
    VehicleService service = new VehicleService();

    // we've turned our service invocation into an executable
    Assertions.assertDoesNotThrow(() -> service.createNewCar(car));
    //
  }

   @Test
   public void whenGivenVehicleObjectCreateNewVehicleReturnsTrue(){
       Vehicle car = new Vehicle();
       VehicleService service = new VehicleService(mockList);
       Mockito.when(mocklist.add(car)).thenReturn(true);


   }

   @Test
   public void whenGivenValidIdGetVehicleByIdReturnsFlashcardWithThatId(){
       Vehicle car = new Vehicle("car", 2500);

       Mockito.when(mockList.get("car")).thenReturn(car); // this is a process called stubbing
       VehicleService service = new VehicleService();
       Vehicle result = service.getVehicleByModel("Kia");

       Assertions.assertEquals(car.car, result.car);
       Assertions.assertEquals(car.price, result.price);
   }

 */
}
