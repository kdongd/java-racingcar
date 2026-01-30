package carrace;

import carrace.controller.RaceGame;
import carrace.domain.car.Car;
import carrace.domain.car.CarCreator;
import carrace.domain.move.MoveCondition;
import carrace.domain.move.RandomMoveCondition;
import carrace.domain.race.Race;
import carrace.view.CarRaceInputView;
import carrace.view.CarRaceOutputView;
import carrace.service.InputService;

import java.util.List;



public class Application {

    public static void main(String[] args) {
        CarRaceInputView inputView = new CarRaceInputView();
        CarRaceOutputView outputView = new CarRaceOutputView();
        InputService inputService = new InputService(inputView);

        String carName = inputService.readCarNames();
        int rounds = inputService.readRounds();

        List<Car> cars = CarCreator.create(carName);
        MoveCondition condition = new RandomMoveCondition();
        Race race = new Race(cars);

        RaceGame game = new RaceGame(race, condition, outputView);
        game.play(rounds);

    }
}
