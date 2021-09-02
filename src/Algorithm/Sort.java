package Algorithm;

public class Sort{

    public static boolean compare(int a,int b){
        return a > b;
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0,arr.length-1);
    }
    public static void quickSort(int[] arr,int left,int right) {
        if(left>=right){
            return ;
        }
        int mid = left;
        for(int i=left+1;i<=right;++i){
            if (compare(arr[i],arr[left])){
                arr[i] ^= arr[++mid];
                arr[mid] ^= arr[i];
                arr[i] ^= arr[mid];
            }
        }
        arr[left] ^= arr[mid];
        arr[mid] ^= arr[left];
        arr[left] ^= arr[mid];

        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
    }

}
