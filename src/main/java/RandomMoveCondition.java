import java.util.Random;

public class RandomMoveCondition implements MoveCondition {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}
