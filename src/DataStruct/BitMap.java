package DataStruct;

public class BitMap {

    private int[] bitMapArray;
    private int maxSize;

    public BitMap(int maxSize) {
        this.maxSize = maxSize;
        this.bitMapArray = new int[(int) (maxSize / 32 + 1)];
    }

    public BitMap() {
        this.maxSize = (1 << 27);
        this.bitMapArray = new int[1 + (1 << 27)];
    }

    public void add(int number) {
        this.bitMapArray[number / 32] += (1 << (number % 32));
    }

    public void del(int number) {
        this.bitMapArray[number / 32] -= (1 << (number % 32));
    }

    public boolean isNumberExistByIndex(int index) {
        return ((this.bitMapArray[index / 32] >> (index % 32)) & 1) == 1;
    }

    public int[] getAllNumber() {
        int index = 0;
        int[] ans = new int[this.maxSize + 1];
        for (int i = 0; i < this.maxSize; ++i) {
            if (this.bitMapArray[i] != 0) {
                int temp = this.bitMapArray[i];
                for (int j = 0; j <= 31; ++j) {
                    if ((temp & 1) == 1) {
                        ans[index++] = (i * 32 + j);
                    }
                    temp >>= 1;
                }
            }
        }
        return ans;
    }

}
