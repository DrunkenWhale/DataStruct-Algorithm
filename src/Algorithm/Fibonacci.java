package Algorithm;

import Algorithm.pow.MatrixQuickPow;

public class Fibonacci {

    /**
     * 采用递归方法(没有记忆化搜索)的方法求解斐波那契数列
     * 复杂度大概O(nⁿ)？
     *
     * @param n -> 斐波那契数列的项数
     * @return 返回第n项斐波那契数列的值 使用Integer类型 (BigInteger比较慢 写起来不给劲)
     */

    public static Integer getAnsByRecursion(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getAnsByRecursion(n - 1) + getAnsByRecursion(n - 2);
        }
    }

    /**
     * 采用递推方法求解 时间复杂度大概O(n)吧
     *
     * @param n 和上面一样 第几项斐波那契数列
     * @return 和上面真的还是一样啦
     */

    public static Integer getAnsByRecurrence(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int temp;
            for (int i = 2; i <= n; ++i) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    /**
     * 采用矩阵快速幂 时间复杂度约为O(log(n))
     * ε=(´ο｀*)))唉 其他都一样啦
     */
    public static Integer getAnsByMatrixQuickPow(int n) {
        return MatrixQuickPow.multiply(MatrixQuickPow.pow(new int[][]{{1, 1}, {1, 0}}, n - 1), new int[][]{{1}, {0}})[0][0];
    }

}



