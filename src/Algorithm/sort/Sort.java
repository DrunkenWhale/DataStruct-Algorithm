package Algorithm.sort;

public class Sort {

    /**    public static boolean compare(int a, int b){
                return a>b;
        }*/

    protected static void swap(int[] arr,int a,int b){
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
/* ************************************冒泡排序******************************************************* */
    public static void bubbleSort(int[] arr, Compare compare){
        bubbleSort(arr,0,arr.length-1,compare);
    }

    public static void bubbleSort(int[] arr,int left,int right,Compare compare){
        for (int i=left;i<=right;++i){
            for(int j=left;j<right;++j){
                if (compare.compare(arr[j],arr[j+1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
/* ************************************快速排序******************************************************** */
    public static void quickSort(int[] arr,Compare compare){
        quickSort(arr,0,arr.length-1,compare);
    }

    public static void quickSort(int[] arr,int left,int right,Compare compare){
        if (right<=left){
            return;
        }
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            while(i<j && compare.compare(arr[j],temp)){
                -- j;
            }
            if (i<j){
                arr[i++] = arr[j];
            }
            while (i<j && compare.compare(temp,arr[i])){
                ++ i;
            }
            if (i<j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        quickSort(arr,left,i-1,compare);
        quickSort(arr,i+1,right,compare);
    }
}



