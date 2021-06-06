package rpn;

public class StackAsList<T> implements Stack<T> {

    private LinkedListNode<T> top; // last element in the linked list = top of the stack

    @Override
    public void push(T element) {
        if(this.isEmpty()){
            top = new LinkedListNode<>(element); // create linked list with one node with data = element
        } else {
            LinkedListNode<T> node = new LinkedListNode<>(element); // create new node above top
            node.setNext(top); // create a link from the node to the top
            top = node; // new node is the new top
        }
    }

    @Override
    public T pop() {
        if(this.isEmpty()){
            return null;
        } else {
            T element = top.getData(); // save the data from the top node to local variable
            LinkedListNode<T> newTop = top.getNext(); // get the new top using the "next" link
            top.setNext(null); // remove the link between the current top and the new top
            top = newTop; // declare the new top
            return element;
        }
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
            return null;
        } else {
            return top.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
