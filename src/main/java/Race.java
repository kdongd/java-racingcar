import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveOnce(MoveCondition condition) {
        for (Car car : cars) {
            car.move(condition);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
