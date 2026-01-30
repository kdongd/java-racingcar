package carrace.view;

import carrace.domain.car.Car;

import java.util.List;


public class CarRaceOutputView {

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
