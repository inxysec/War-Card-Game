package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.StackADT;

/**
 * Linked list implementation of Stacks. 
 * 
 * @author ITSC 2214
 * @version 1.0
 * @param <T> 
 */
public class LinkedStack<T> implements StackADT<T> {
    /* top: the top of the stack */
    private SinglyLinkedNode<T> top;
    
    /* size: the number of elements in the stack */
    private int size;
    
    /**
     * Constructor
     */
    public LinkedStack() {
        //TODO Instantiate the linked list-based data 
        //collection
        
        // Default parameters for the new stack.
        top = null;
        size = 0;
    }
    
    /**
     * Insert an element on the top of the stack
     * @param target input element
     */
    @Override
    public void push(T target) {
        //TODO Add targer to the top of the stack 
        //(represented by the top reference node)
        
        // Get a reference for the old top.
        SinglyLinkedNode<T> temp = top;
        
        // Reinitialize top with a new node.
        top = new SinglyLinkedNode<>();
        
        // Set the new nodes paramaeters (Data and Next)
        top.setElement(target);
        top.setNext(temp);
        
        // Increase the stack size.
        size++;
    }

    /**
     * Remove out of the top of the stack
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Pop off empty stack");
        }

        //TODO Remove and return the top item on the stack
        //Corresponding to retrieve the top node and reset 
        //the top reference to the reference of its next node
        
        // Get the data of the top node.
        T temp = top.getElement();
        
        // Set the new top as the next node in the stack.
        top = top.getNext();
        
        // Decrease the size of the stack.
        size--;
        
        // Return the data from the old top node.
        return temp;

    }
    
    /**
     * Retrieve the element on the top of the stack
     * @return the element on the top of the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Peep on the top of empty stack");
        }

        //TODO Return the top item on this stack, but do 
        //not modify the stack.
        //Corresponding to return the element in the node 
        //referred by the reference top
        
        // Return the top nodes element;
        return top.getElement();

    }
    
     /**
     * Examine whether the stack is empty
     * @return true: if the stack is empty
     *         false: if the stack is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the stack is empty
        
        // If the top has nothing, return true. Else, return false.
        return top == null;
    }
    
     /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //TODO return the size of the stack 
        
        // Returns the size of the stack.
        return size;
    }
}

