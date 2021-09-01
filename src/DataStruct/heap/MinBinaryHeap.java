package DataStruct.heap;

public class MinBinaryHeap extends BinaryHeap{

    public MinBinaryHeap(int n) {
    super(n);
}

    @Override
    public boolean compare(int x, int y) {
        return x <= y;
    }
}
