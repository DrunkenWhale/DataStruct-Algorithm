package DataStruct.linear.queue;

import DataStruct.linear.LinearList;
import DataStruct.linear.list.List;

public class Queue<T> implements LinearList<T> {

    private int size = 0;
    private final List<T> list;

    public Queue() {
        list = new List<>();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void push(T element) {
        list.push(element);
        ++this.size;
    }

    @Override
    public T pop() {
        --this.size;
        return list.pop();
    }

    @Override
    public void show() {
        list.show();
    }
}
