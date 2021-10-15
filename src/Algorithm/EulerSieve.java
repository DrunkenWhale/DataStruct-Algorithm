package Algorithm;

public class EulerSieve {

    public boolean[] mark = null;
    public int[] prime = null;
    public int length = 0;

    public EulerSieve(int n) {
        init(n);
        this.length = n;
    }

    /**
     * @param length 需要标记的长度
     *               该方法会将数组中(1,length)区间内素数对应的下标赋为false 合数赋为true
     */
    public void init(int length) {
        this.mark = new boolean[length + 1];
        this.prime = new int[length];
        int index = 0;
        mark[0] = mark[1] = true;
        for (int i = 2; i <= length; ++i) {
            if (!mark[i]) {
                prime[++index] = i;
            }
            for (int j = 1; j <= length && i * prime[j] <= length; ++j) {
                mark[i * prime[j]] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
    }
}
