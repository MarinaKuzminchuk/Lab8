package rpn;

public class StackAsList<T> implements Stack<T> {

    private LinkedListNode<T> top; // last element in the linked list = top of the stack

    @Override
    public void push(T element) {
        if(this.isEmpty()){
            top = new LinkedListNode<>(element); // create linked list with one node with data = element
        } else {
            LinkedListNode<T> node = new LinkedListNode<>(element); // create new node above top
            top.setNext(node); // create a link from top to node
            node.setPrevious(top); // create a link from node to top
            top = node;
        }
    }

    @Override
    public T pop() {
        if(this.isEmpty()){
            return null;
        } else {
            T element = top.getData(); // save the data from the top node to local variable
            LinkedListNode<T> newTopOfStack = top.getPrevious(); // save the node below the top to local variable
            if (newTopOfStack != null) {
                newTopOfStack.setNext(null); // disconnect the new top from the current top
            }
            top.setPrevious(null); // disconnect the current top from the new top
            top = newTopOfStack;
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
