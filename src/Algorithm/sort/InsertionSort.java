package Algorithm.sort;

public class InsertionSort extends Sort {
    public static void sort(int[] arr, Compare compare) {
        sort(arr, 0, arr.length - 1, compare);
    }

    public static void sort(int[] arr, int left, int right, Compare compare) {
        for (int i = left; i <= right; ++i) {
            for (int j = i; j > left; --j) {
                if (compare.compare(arr[j - 1], arr[j])) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
