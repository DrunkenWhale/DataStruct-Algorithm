package DataStruct.linear;

public interface LinearList<T> {

    /**
     * @return get LinearList's elements number
     * */
    int getSize();

    /**
     * @return if LinearList is empty ,this method will return true,else will return false
     * */
    boolean isEmpty();
    /**
     * @param element  which will be added to LinearList
     * */
    void push(T element);

    /**
     * @return remove an element from LinearList
     * (the last or the new should be decided by concrete LinearList ),
     * and return it
     * */
    T pop();

    void show();

}
