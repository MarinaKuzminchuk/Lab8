package rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixTest {

    @Test
    public void infixToPostfix() {
        Postfix postfix = new Postfix();
        assertEquals("1 2 * 3 +", postfix.infixToPostfix("1 * 2 + 3"));
        assertEquals("1 2 3 * +", postfix.infixToPostfix("1 + 2 * 3"));
        assertEquals("1 2 + 3 4 ^ -", postfix.infixToPostfix("1 + 2 - 3 ^ 4"));
        assertEquals("1 2 ^ 3 4 * -", postfix.infixToPostfix("1 ^ 2 - 3 * 4"));
        assertEquals("1 2 3 * + 4 5 ^ - 6 +", postfix.infixToPostfix("1 + 2 * 3 - 4 ^ 5 + 6"));
        assertEquals("1 2 + 3 * 4 5 6 - ^ +", postfix.infixToPostfix("( 1 + 2 ) * 3 + ( 4 ^ ( 5 - 6 ) )"));
        assertEquals("1 2 + 3 4 / + 5 + 6 7 8 + * +", postfix.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"));
        assertEquals("9 1 - 2 - 3 2 * - 1 -", postfix.infixToPostfix("9 - 1 - 2 - 3 * 2 - 1"));
    }
}
