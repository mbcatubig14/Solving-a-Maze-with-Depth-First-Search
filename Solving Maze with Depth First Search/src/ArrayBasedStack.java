
/**
 * This class is for creating array-based stack to be used for printing the path
 * in DepthFirstSearch.
 *
 * @author Muhammad
 */
public class ArrayBasedStack {

    int capacity;
    static final int DEFAULT_CAPACITY = 1000;
    int stack[];
    int top = -1;

    //Main constructor to be used when called from the DepthFirstSearch class.
    public ArrayBasedStack() {
        this(DEFAULT_CAPACITY);
    }

    /**Constructor for the main constructor above to initialise the default capacity.
     * @param capacity*/
    public ArrayBasedStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    /** @return It returns the size of the stack. */
    public int size() {
        return (top + 1);
    }

    /** @return Returns true when the stack is empty.*/
    public boolean isEmpty() {
        return (top < 0);
    }

    /**This method pushes new node from the top in the stack.
     * @param node     */
    public void push(int node) {
        if (size() == capacity) {
            System.out.println("Stack is full");
        }
        stack[++top] = node;
    }

    //This is an overridden method returns a string format when called for printing the path in depth first search.
    @Override
    public String toString() {
        String string = "";
        if (size() > 0) {
            string += stack[0];
        }
        if (size() > 1) {
            for (int index = 1; index <= size() - 1; index++) {
                string += " --> " + stack[index];
            }
        }
        return string;
    }

    //This method returns an integer value that pops the value on top of the stack
    public int pop() {
        int node;
        //Check if it's empty.
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        //Get the top
        node = stack[top];
        stack[top--] = node;
        return node;
    }

}
