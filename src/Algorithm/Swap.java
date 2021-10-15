package Algorithm;

public class Swap {
    public static void swapIntArrayElement(int x, int y, int[] arr) {
        /* 感觉有些妙 就直接记下来了 */
        arr[x] ^= arr[y]; // arr[x]储存arr[x]和arr[y]两者的信息
        arr[y] ^= arr[x]; // 保持arr[x]不变,利用arr[x]异或反转arr[y]的原始值使其等于x的原始值
        arr[x] ^= arr[y]; // 保持arr[x]不变,利用arr[y]异或反转arr[x]的原始值使其等于x的原始值
    }
}
