package DataStruct.Heap;

public class MaxBinaryHeap extends BinaryHeap{

    public MaxBinaryHeap(int n) {
        super(n);
    }

    @Override
    public boolean compare(int x, int y) {
        return x >= y;
    }
}
