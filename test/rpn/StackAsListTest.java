package rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackAsListTest {

    @Test
    public void testIsEmpty(){
        StackAsList<Integer> stack = new StackAsList<>();
        assertEquals(true, stack.isEmpty());
    }
    @Test
    public void testIsNotEmpty(){
        StackAsList<Integer> stack = new StackAsList<>();
        stack.push(8);
        assertEquals(false, stack.isEmpty());
        assertEquals(8, stack.peek());
    }
    @Test
    public void testPeek(){
        StackAsList<Integer> stack = new StackAsList<>();
        stack.push(9);
        stack.push(4);
        stack.push(3);
        assertEquals(false, stack.isEmpty());
        assertEquals(3, stack.peek());
    }
    @Test
    public void testPeekAfterPop(){
        StackAsList<Integer> stack = new StackAsList<>();
        stack.push(9);
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(false, stack.isEmpty());
        assertEquals(4, stack.peek());
    }
    @Test
    public void testPopMoreThanPush(){
        StackAsList<Integer> stack = new StackAsList<>();
        stack.push(9);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(null, stack.pop());
        assertEquals(true, stack.isEmpty());
        assertEquals(null, stack.peek());
    }

}
