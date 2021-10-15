package Algorithm.sort;


/**
 * 归并排序
 */

public class MergeSort extends Sort {

    public static void sort(int[] arr, Compare compare) {
        sort(arr, 0, arr.length - 1, compare);
    }

    public static void sort(int[] arr, int left, int right, Compare compare) {
        merge(arr, new int[arr.length + 1], left, right, compare);
    }

    public static void merge(int[] arr, int[] ans, int left, int right, Compare compare) {
        if (right <= left) {
            return;
        }
        int mid = (left + right + 1) / 2;
        merge(arr, ans, left, mid - 1, compare);
        merge(arr, ans, mid, right, compare);
        int p = left;
        int q = mid;
        int s = left;
        while (s <= right) {
            if (p >= mid || (q <= right && compare.compare(arr[p], arr[q]))) {
                ans[s++] = arr[q++];
            } else {
                ans[s++] = arr[p++];
            }
        }
        for (int i = left; i <= right; ++i) {
            arr[i] = ans[i];
        }
    }

}
