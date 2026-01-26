package carrace.fixture;

import carrace.domain.MoveCondition;

public class AlwaysMoveCondition implements MoveCondition {
    @Override
    public boolean canMove() {
        return true;
    }
}
