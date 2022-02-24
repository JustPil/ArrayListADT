package AL;

public interface ArrayListInterface<T> {
    void add(T t);
    boolean contains(T t);
    boolean remove(T t);
    T get(int index);
    boolean isEmpty();
    boolean isFull();
    int size();
    void clear();
    int indexOf(T t);
    int lastIndexOf(T t);
    boolean set(int index, T t);
    int getCapacity();
    String toString();
}
