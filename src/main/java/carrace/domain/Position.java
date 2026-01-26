package carrace.domain;

public class Position {

    private static final int START = 0;
    private final int value;

    public Position() {
        this(START);
    }

    public Position(int value) {
        if (value < START) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
        this.value = value;
    }

    public Position moveForward() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }
}
