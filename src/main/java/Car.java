public class Car {
    private int position;

    public void move(MoveCondition condition) {
        if (condition.canMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
