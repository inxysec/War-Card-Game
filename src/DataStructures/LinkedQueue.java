package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.QueueADT;

/**
 * Linked list implementation of Queues. 
 * 
 * @author ITSC 2214
 *
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /* front: the beginning of the queue */
    private SinglyLinkedNode<T> front = new SinglyLinkedNode<>();
    
    /* rear: the end of the queue */
    private SinglyLinkedNode<T> rear = new SinglyLinkedNode<>();
    
    /* size: the number of elements in the queue */
    private int size;
    
    /**
     * Constructor
     */
    public LinkedQueue() {
        //TODO Instantiate the linked list-based data 
        //collection
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Insert an element in the end of the queue
     * @param target input element
     */
    @Override
    public void enqueue(T target) {
        /** TODO if queue is empty, insert new node
         * and change the rear and front references
         * 
         * if queue is not empty, insert new node in 
         * the rear of the queue
        **/

        // Reference node for old rear.
        SinglyLinkedNode<T> temp = rear;
        
        // Set new rears values.
        rear = new SinglyLinkedNode<T>();
        rear.setElement(target);
        rear.setNext(null);
        
        // If the queue is empty, set the front equal to the rear.
        if (isEmpty()) {
            front = rear;
        } else {
            // Set the old rear's next equal to the newly created node at the rear.
            temp.setNext(rear);
        }
        
        // Increase the size of the queue.
        size++;
    }
    
    /**
     * Remove from the beginning of the queue
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        /** TODO if queue is empty, throw an exception.
        * Then remove the data item from the queue
        * Do not forget to change the size
        **/
        
        // Get the data from the current front of the queue.
        T temp = front.getElement();
        
        // Set the new front to the next node in the queue.
        front = front.getNext();
        
        // Check if queue is empty.
        if (isEmpty()) {
            
            // Set rear to null
            rear = null;
            
            // Throw empty collection exception.
            throw new EmptyCollectionException();
        }
        
        // Reduce the size of the queue
        size--;
        
        // Return the dequeued element
        return temp;
    }
    
    /**
     * Examine whether the queue is empty
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the queue is empty
        
        // Return the boolean of if the size is equal to 0.
        return size == 0;

    }
    
    /**
     * Retrieve the front
     * @return the element in the beginning of the queue
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Remove item from empty queue");
        }

        /**TODO return element in the frontmost position of the array **/
        return front.getElement();
        
    }
    
    /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //TODO return the size of the Queue
        
        // Return the size of the queue.
        return this.size;

    }
}

