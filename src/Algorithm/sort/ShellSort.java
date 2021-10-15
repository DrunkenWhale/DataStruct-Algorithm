package Algorithm.sort;

public class ShellSort extends Sort {
    public static void sort(int[] arr, Compare compare) {
        sort(arr, 0, arr.length - 1, compare);
    }

    public static void sort(int[] arr, int left, int right, Compare compare) {
        int j;
        for (int gap = (right - left + 1) / 2; gap > 0; gap /= 2) {
            for (int i = gap; i <= right; ++i) {
                int temp = arr[i];
                for (j = i; j >= gap + left && compare.compare(arr[j - gap], temp); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
