package carrace.fixture;


import carrace.domain.car.Cars;



public class CarsFixture {

    public static Cars threeCars() {
        return Cars.from("car1,car2,car3");
    }


}

