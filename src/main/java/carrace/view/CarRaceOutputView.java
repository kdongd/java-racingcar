package carrace.view;

import carrace.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;


public class CarRaceOutputView {

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();

    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}


