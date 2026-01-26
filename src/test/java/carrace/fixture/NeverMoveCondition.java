package carrace.fixture;

import carrace.domain.MoveCondition;

public class NeverMoveCondition implements MoveCondition {
    @Override
    public boolean canMove() {
        return false;
    }
}

