import java.util.Arrays;

/**
 * Programming Project 2: Deque with Arrays
 * ArrayDeque class that implement a Deque interface.
 * @author Stefon Glover
 * @version 9/19/20
 */

public class ArrayDeque<T> implements DequeInterface<T> {

    //Instance variables for the class
    private T[] data;
    private int arraySize;
    private static final String EMPTY_MESSAGE = "The deque is empty.";

    /**
     * Constructor for intitializing the arraySize.
     * @param size Desired array size.
     */
    public ArrayDeque(int size)
    {
        //Create array of a specific size
        data = (T[]) new Object[size];
        this.arraySize = 0;
    }

    /**
     * Method to double the size of the original deque.
     */
    private void increaseArray()
    {
        //Copy the contents of the original array and double its size.
        data = Arrays.copyOf(data, 2 *arraySize);
    }

    /**
     * Add a newEntry to the front of the deque.
     */
    @Override
    public void addToFront(T newEntry) {
        
        //If the array is full, expand it
        if(arraySize == data.length)
        {
            increaseArray();
        }

        //Loop to move the elements to the right
        for(int i = arraySize; i > 0; i--)
        {
            data[i] = data[i - 1];
        }
        //newEntry is placed at index 0
        data[0] = newEntry;
        arraySize++;
    }

    /**
     * Method to add new entry to the back of the deque
     */
    @Override
    public void addToBack(T newEntry) {
        
        //Expand the deque if it is full
        if(arraySize == data.length)
        {
            increaseArray();
        }

        //Add the newEntry
        data[arraySize] = newEntry;
        arraySize++;
    }

    /**
     * Remove the element at the front
     * @return the deleted element
     */
    @Override
    public T removeFront() {
        
        if(isEmpty())
        {
            System.out.println(EMPTY_MESSAGE);
        }

        //Element at index 0
        T frontElement = data[0];

        //Loop to move the elements to the left by 1 posiiton
        for(int i = 0; i < arraySize - 1; i++)
        {
            data[i] = data[i + 1];
        }

        //Decrease the size and return the new front
        arraySize--;
        return frontElement;
    }

    /**
     * Method to remove the last element in the deque.
     */
    @Override
    public T removeBack() {
       
        if(isEmpty())
        {
            System.out.println(EMPTY_MESSAGE);
        }

        //Decrease the size of the deque
        arraySize--;
        return data[arraySize];
    }

    /**
     * Method to get the element at the front of the deque. 
     */
    @Override
    public T getFront() {
       
        if(isEmpty())
        {
            System.out.println(EMPTY_MESSAGE);
        }

        //Return the the element at the front.
        return data[0];
    }

    /**
     * Method to get the last element in the deque.
     */
    @Override
    public T getBack() {
       
        if(isEmpty())
        {
            System.out.println(EMPTY_MESSAGE);
        }

        return data[arraySize - 1];
    }

    /**
     * Method to check if the deque is empty or not
     * @return True if the deque is empty or false if its not.
     */
    @Override
    public boolean isEmpty() {
       
        if(arraySize == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method to remove all the elements in the deque.
     */
    @Override
    public void clear() {
        
        this.arraySize = 0;
    }

    /**
     * Method to show all the elements in the deque.
     */
    public void printAll()
    {
        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(data[i]+"| ");
        }
    }
}