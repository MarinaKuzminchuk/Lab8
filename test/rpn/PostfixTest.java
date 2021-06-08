package rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostfixTest {

    @Test
    public void evaluate() {
        double delta = 0.001;

        Postfix postfix = new Postfix();
        assertEquals(5, postfix.evaluate("1 2 * 3 +"), delta);
        assertEquals(7, postfix.evaluate("1 2 3 * +"), delta);
        assertEquals(-78, postfix.evaluate("1 2 + 3 4 ^ -"), delta);
        assertEquals(-11, postfix.evaluate("1 2 ^ 3 4 * -"), delta);

        assertEquals(-1011, postfix.evaluate("1 2 3 * + 4 5 ^ - 6 +"), delta);
        assertEquals(9.25, postfix.evaluate("1 2 + 3 * 4 5 6 - ^ +"), delta);
        assertEquals(98.75, postfix.evaluate("1 2 + 3 4 / + 5 + 6 7 8 + * +"), delta);
        assertEquals(-1, postfix.evaluate("9 1 - 2 - 3 2 * - 1 -"), delta);
    }
}
