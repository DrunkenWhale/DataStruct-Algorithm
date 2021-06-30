package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/** gcd -> Greatest Common Divisor
 *  求最大公倍数
 *  不查错 所以全靠用户啦
 */

public class GCD {
    /* 递归好写 就用递归啦 (✺ω✺)*/

    /* 2个数 求最大公因数 */
    static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }

    /* 对数组求最大公因数 */
    static  int gcd(int[] arr){
        int params = arr[0];
        for (int i=1;i<arr.length;++i){
            params = gcd(params,arr[i]);
        }
        return params;
    }

    /* 对数组求最大公因数,但是要指定数组边界 */
    static  int gcd(int[] arr,int Bound){
        int params = arr[0];
        for (int i=1;i<=Bound;++i){
            params = gcd(params,arr[i]);
        }
        return params;
    }

    /* 对数组求最大公因数,但是要指定数组边界和起点 */
    static  int gcd(int[] arr,int index,int Bound){
        int params = arr[index];
        for (int i=index+1;i<=Bound;++i){
            params = gcd(params,arr[i]);
        }
        return params;
    }


    /*  测试 用例是洛谷P1888
   public static void main(String[] args) {
       Scanner read = new Scanner(System.in);
       int[] arr = new int[3];
       arr[0] = read.nextInt();
       arr[1] = read.nextInt();
       arr[2] = read.nextInt();
       Arrays.sort(arr);
       int params  = gcd(gcd(arr[0],arr[1]),gcd(arr[1],arr[2]));
       System.out.printf("%d/%d",arr[0]/params,arr[2]/params);
   }*/
}
