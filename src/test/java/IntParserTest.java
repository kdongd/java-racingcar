import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntParserTest {

    private final IntParser parser = new IntParser();

    @DisplayName("정수 문자열 입력 시 int 반환")
    @Test
    void parseValidInteger() {
        assertEquals(42, parser.parse("42", "error"));
    }

    @DisplayName("숫자가 아닌 문자열 입력 시 예외 발생")
    @Test
    void parseInvalidInteger() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("abc", "error"));
    }
}

