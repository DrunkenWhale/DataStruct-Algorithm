package DataStruct.linear.stack;

import DataStruct.linear.LinearList;
import DataStruct.linear.list.Node;

public class Stack<T> implements LinearList<T> {

    private int size;
    private Node<T> head;

    public Stack() {
    }

    public T top() {
        if (this.size != 0) {
            return this.head.value;
        } else {
            return null;
        }
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
        if (head == null) {
            head = new Node<>(element);
        } else {
            head.next = new Node<>(element);
            head.next.last = head;
            head = head.next;
        }
        ++this.size;
    }

    @Override
    public T pop() {
        if (this.size > 0) {
            T temp = head.value;
            head = head.last;
            if (head != null) {
                head.next = null;
            }
            --this.size;
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public void show() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.last;
        }
        System.out.println();
    }

}
