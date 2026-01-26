package carrace;

import carrace.controller.RaceGame;
import carrace.domain.Car;
import carrace.domain.MoveCondition;
import carrace.domain.Race;
import carrace.domain.RandomMoveCondition;
import carrace.controller.InputService;
import carrace.view.CarRaceInputView;
import carrace.view.CarRaceOutputView;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        CarRaceInputView inputView = new CarRaceInputView();
        CarRaceOutputView outputView = new CarRaceOutputView();
        InputService inputService = new InputService(inputView);

        int carCount = inputService.readCarCount();
        int rounds = inputService.readRounds();

        List<Car> cars = Car.createCars(carCount);
        MoveCondition condition = new RandomMoveCondition();
        Race race = new Race(cars);

        RaceGame game = new RaceGame(race, condition, outputView);
        game.play(rounds);
    }
}
