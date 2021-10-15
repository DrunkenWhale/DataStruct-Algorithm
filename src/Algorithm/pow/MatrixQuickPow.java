package Algorithm.pow;

public class MatrixQuickPow {

    public static int[][] pow(int[][] arr, int n) {
        int[][] ans = new int[arr.length][arr[0].length];
        for (int i = 0; i < ans.length; i++) {
            ans[i][i] = 1;    // 单位阵是对角线为1
        }
        int[][] base = arr;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = MatrixQuickPow.multiply(ans, base);
            }
            base = MatrixQuickPow.multiply(base, base);
            n >>= 1;
        }
        return ans;
    }


    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] ans = new int[a.length][b[0].length]; // a*b  *  b*c  == a*c  矩阵行/列数
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    // 打印矩阵
    public static void show(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%-7d", ints[j]);
            }
            System.out.println();
        }
    }

}

