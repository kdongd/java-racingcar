public class MoveAction {
    public void moveAll(Car[] cars, MoveCondition condition) {
        for (Car car : cars) {
            car.move(condition);
        }
    }
}
