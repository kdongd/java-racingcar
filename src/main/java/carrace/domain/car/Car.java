package carrace.domain.car;

import carrace.domain.move.MoveCondition;

public class Car {

    private Position position = new Position();

    public void move(MoveCondition condition) {
        if (condition.canMove()) {
            position = position.moveForward();
        }
    }

    public int getPosition() {
        return position.getValue();
    }
}
