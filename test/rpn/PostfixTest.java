package rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostfixTest {

    @Test
    public void evaluate() {
        Postfix postfix = new Postfix();
        assertEquals(16, postfix.evaluate("8 2 / 2 2 + *"));
        assertEquals(26, postfix.evaluate("4 5 6 * + 8 -"));
        assertEquals(536, postfix.evaluate("18 3 / 2 ^ 13 7 + 5 2 ^ * +"));
    }
}
