package DataStruct.heap;

public interface Heap {
    void push(int element) throws Exception;
    int  pop()             throws Exception;
    int  top();
}
