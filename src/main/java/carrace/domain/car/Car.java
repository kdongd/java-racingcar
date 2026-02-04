package carrace.domain.car;

import carrace.domain.move.MoveCondition;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private Position position = new Position();
    private final String carName;

    public Car(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    private void validateName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동 이름은 비어있을 수 없습니다.");
        }
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }

    public void move(MoveCondition condition) {
        if (condition.canMove()) {
            position = position.moveForward();
        }
    }

    public int getPosition() {
        return position.getValue();
    }
}
