package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.QueueADT;


/**
 * An array-based QueueADT.
 * ArrayCircularQueue which implement QueueADT
 * Use an array as the Queue container, and use the
 * variable size to represent the total number of elements
 * in the queue.
 * In the array, new data element will always be stored in 
 * the end of queue,
 * which is represented in the index of (front + size) % 
 * array length.
 *
 * @author ITSC 2214
 * @version 1.0
 * @param <E> 
 */
public class ArrayCircularQueue<E> implements QueueADT<E> {
    /** Default capacity in this QueueADT. */
    private final static int DEFAULT_CAPACITY = 10;
    
    /** Array of items in this QueueADT. */
    private E[] data;

    /** Declare a int variable named front, which represents 
 the index of the frontmost element in this QueueADT. */
    private int front;

    /** Declare a int variable named front, which represents 
 the index of the frontmost element in this QueueADT. */
    private int rear;
    
    
    /** Declare a int variable named size, which represents 
 the number of items currently in this QueueADT. */
    private int size;

    /** The QueueADT is initialized to be empty. */
    @SuppressWarnings("unchecked")
    public ArrayCircularQueue() {
        //TODO Instantiate the array-based data collection
        // with the default capacity constant, DEFAULT_CAPACITY
        
        // Create a new array for the data.
        this.data = (E[])(new Object[DEFAULT_CAPACITY]);
        
        // Default values for the circular queue.
        this.size = 0;
        this.front = -1;
        this.rear = -1;

    }

    /**
     * Insert an element in the end of the queue
     * @param target input element
     */
    @Override
    public void enqueue(E target) {
        /** TODO if queue is full, expand capacity the 
         * array-based data collection,
         *  for example, doubling its size and copying 
         * the original data items into the new expanded array.
         * Then insert a new data item with reference to 
         * the input target into the queue
         * Do not forget to change the size
        **/
        
        // If the queue is full, expand capacity.
        if (isFull()) {
            expandCapacity();
        }
        
        else {
            
            // Set rear equal to rear + 1;
            rear = (rear + 1);
            
            // push the target into the 'rear' of the circular queue
            data[rear] = target;
            
            // Increase the size of the circular queue
            size++;
            
            // If the queue is empty, front is equal to rear.
            if (front == -1) {
                front = rear;
            }
        }


    }

    /**
     * Remove from the beginning of the queue
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public E dequeue() throws EmptyCollectionException {
        /** TODO if queue is empty, throw an exception.
        * Then remove the data item from the queue, which 
        * corresponds to save element at the front index 
        * to a variable, named result,
        * and move the front to its next index in circular 
        * array.
        * 
        * Do not forget to change the size
        * Return the variable result.
        **/
        
        // Create a new reference element.
        E element;
        
        // If the queue is empty, throw an exception
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty.");
        } else {
            
            // Set the data at the front of the queue equal to the reference element.
            element = data[front];
            
            // Set the data at the front of the array equal to null.
            data[front] = null;
            
            // Set the new front as the next element.
            front = (front + 1);
            
            // Decrease the size of the queue.
            size--;
        }
        
        // Return the old element.
        return element;

    }

    /** Double the length of data. */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        E[] newData = (E[])(new Object[data.length * 2]); // Warning
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
    }

    /**
     * Examine whether the queue is empty
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the queue is empty
        
        // Return the boolean value of the size of the queue being equal to 0.
        return size == 0;

    }

     /**
     * Examine whether the queue array is full
     * @return Return true if data is full, 
     *         or else false
     */
    protected boolean isFull() {
        //TODO Evaluate whether the queue is full
        
        // Return the boolean value of the size of the queue being equal to the length of the data array.
        return size == data.length;

    }
    
    /**
     * Retrieve the first
     * @return the element in the beginning of the queue
     * @throws EmptyCollectionException 
     */
    @Override
    public E first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Remove item from empty queue");
        }

        /**TODO return element in the frontmost position of the array **/
        
        // Return the element from the front of the queue.
        return data[front];
        
    }

    /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //TODO return the size of the Queue
        
        // Return the size of the queue.
        return size;

    }
}