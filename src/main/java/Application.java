import java.util.List;

public class Application {

    public static void main(String[] args) {
        CarRaceInputView inputView = new CarRaceInputView();
        CarRaceOutputView outputView = new CarRaceOutputView();
        InputService inputService = new InputService(inputView, new IntParser());

        int carCount = inputService.readCarCount();
        int rounds = inputService.readRounds();

        List<Car> cars = CarFactory.create(carCount);
        MoveCondition condition = new RandomMoveCondition();
        Race race = new Race(cars);

        outputView.printStartMessage();
        for (int i = 0; i < rounds; i++) {
            race.moveOnce(condition);
            outputView.printResult(race.getCars());
        }
    }
}
