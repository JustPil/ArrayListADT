package arraylists;

import lists.ListInterface;
import java.util.Comparator;

public class ArrayList<T> implements ListInterface<T> {
    private int capacity;
    private int numElements = 0;
    private T[] array;
    private final double LOAD_THRESHOLD = .75;
    private final int ELEMENT_NOT_FOUND = -1;
    private Comparator<T> comp;

    /**
     * Constructor initializes the ArrayList with a Comparator and default capacity of 10.
     */
    public ArrayList() {
        array = (T[])new Object[capacity = 10];
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * Constructor initializes the ArrayList with a Comparator and a user-specified capacity.
     * @param cap the User-specified capacity. If the capacity is negative, the default capacity of 10 is used.
     */
    public ArrayList(int cap) {
        array = (T[])new Object[capacity = cap > 0 ? cap : 10];
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * add Adds a new element to the ArrayList, resizing the internal array if load threshold is reached.
     * @param t The element to add.
     */
    public void add(T t) {
        array[numElements++] = t;
        if((double)(numElements / capacity) >= LOAD_THRESHOLD) {
            resize();
        }
    }

    /**
     * contains Checks if a value is present in the ArrayList.
     * @param t The value to check.
     * @return True if the value is present, false otherwise.
     */
    public boolean contains(T t) {
        for(T value : array) {
            if(value == null) {
                break;
            }
            if(comp.compare(value, t) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * remove Removes an element from the ArrayList, if present.
     * @param t The value to remove.
     * @return True is removal is successful, false otherwise.
     */
    public boolean remove(T t) {
        for(int i = 0; i < numElements; i++) {
            if(array[i] == null) {
                break;
            }
            if(comp.compare(array[i], t) == 0) {
                array[i] = null;
                numElements--;
                shift(i);
                return true;
            }
        }
        return false;
    }

    /**
     * shift Shifts the ArrayList elements left after a deletion occurs.
     * @param index The index of a deleted element, whereby shifting begins.
     */
    private void shift(int index) {
        for(int i = index; i < array.length - 2; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * get Returns a value at a specified index.
     * @param index The index to retrieve a value.
     * @return Returns an element value or a null value if out of bounds.
     */
    public T get(int index) {
        if(index < 0 || index >= array.length) {
            return null;
        }
        return array[index];
    }

    /**
     * isEmpty Checks if the ArrayList is empty.
     * @return True if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * isFull Checks if the ArrayList is full.
     * @return True if the ArrayList is full, false otherwise.
     */
    public boolean isFull() {
        return numElements == array.length;
    }

    /**
     * size Returns the number of elements stored in the ArrayList.
     * @return The number of elements stored in the ArrayList.
     */
    public int size() {
        return numElements;
    }

    /**
     * clear Clears the ArrayList of all elements by referencing a newly-created array.
     */
    public void clear() {
        array = (T[])new Object[capacity];
        numElements = 0;
    }

    /**
     * indexOf Returns an index of the first occurrence of a user-specified value.
     * @param t The value to check.
     * @return The index of the first occurrence of the value.
     */
    public int indexOf(T t) {
        for(int i = 0; i < numElements; i++) {
            if(array[i] != null && comp.compare(array[i], t) == 0) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * lastIndexOf Returns an index of the last occurrence of a user-specified value.
     * @param t The value to check.
     * @return The index of the last occurrence of the value.
     */
    public int lastIndexOf(T t) {
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] != null && comp.compare(array[i], t) == 0) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * set Sets a user-specified index to a user-specified value.
     * @param index The index.
     * @param t The value.
     * @return True if the set was successful, false otherwise.
     */
    public boolean set(int index, T t) {
        if(index < 0 || index >= numElements) {
            return false;
        }
        array[index] = t;
        return true;
    }

    /**
     * getCapacity Returns the ArrayList's current capacity.
     * @return The capacity of the ArrayList.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * resize Resizes the ArrayList by creating a new internal array with doubled capacity.
     */
    private void resize() {
        capacity *= 2;
        T[] resizedArray = (T[])new Object[capacity];
        System.arraycopy(array, 0, resizedArray, 0, array.length);
        array = resizedArray;
    }

    /**
     * toString Returns a String of all elements contained in the ArrayList.
     * @return A String containing all elements in the ArrayList.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < numElements; i++) {
            sb.append(array[i]);
            sb.append(i != numElements - 1 ? " " : "");
        }
        return sb.append("]").toString();
    }
}
