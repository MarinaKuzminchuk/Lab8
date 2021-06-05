package rpn;

public interface Stack<T> {
    void push(T element);
    T pop(); // takes out the last element from the Stack
    T peek(); // looks at the last element in the Stack
    boolean isEmpty(); // checks if the stack is empty

}
