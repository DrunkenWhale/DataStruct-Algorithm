package Algorithm.sort;

public abstract class Sort {

    protected static void swap(int[] arr,int a,int b){
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

}



