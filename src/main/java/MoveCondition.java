import java.util.Random;

public class MoveCondition {
    private final Random random = new Random();

    public boolean canMove() {
        return random.nextInt(10) >= 4;
    }
}
