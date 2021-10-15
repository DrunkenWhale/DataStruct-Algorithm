package Algorithm.sort;

/**
 * 冒泡排序没什么好说的
 */
public class BubbleSort extends Sort {
    public static void sort(int[] arr, Compare compare) {
        sort(arr, 0, arr.length - 1, compare);
    }

    public static void sort(int[] arr, int left, int right, Compare compare) {
        for (int i = left; i <= right; ++i) {
            for (int j = left; j < right; ++j) {
                if (compare.compare(arr[j], arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
