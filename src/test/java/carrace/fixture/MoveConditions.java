package carrace.fixture;

import carrace.domain.move.MoveCondition;

public class MoveConditions {

    //항상 이동하는 Stub
    public static MoveCondition alwaysMove() {
        return () -> true;
    }

    //절대 이동하지 않는 Stub
    public static MoveCondition neverMove() {
        return () -> false;
    }
}
