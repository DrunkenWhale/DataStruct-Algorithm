package DataStruct.linear.list;

import DataStruct.linear.LinearList;

public class List<T> implements LinearList<T> {

    private Node<T> head = null;
    private Node<T> back = null;
    private int size = 0;

    public T back() {
        if (this.size > 0) {
            return this.back.value;
        } else {
            return null;
        }
    }

    public T front() {
        if (this.size > 0) {
            return this.head.value;
        } else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T element) {
        if (back == null && head == null) {
            // empty
            head = new Node<>(element);
            back = head;
        } else {
            back.last = new Node<>(element);
            back.last.next = back;
            back = back.last;
        }
        ++this.size;
    }

    @Override
    public T pop() {
        T temp;
        if (this.size > 1) {
            temp = head.value;
            head = head.last;
            head.next = null;
        } else {
            temp = this.back.value;
            this.head = null;
            this.back = null;
        }
        --this.size;
        return temp;
    }

    @Override
    public void show() {
        Node<T> temp = this.back;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


