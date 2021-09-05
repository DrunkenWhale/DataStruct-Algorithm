package Algorithm.sort;

public class HeapSort extends Sort{

    public static void sort(int[] arr,Compare compare){
        sort(arr,arr.length-1,compare);
    }
    public static void sort(int[] arr,int length,Compare compare){
        for (int i = length/2 ;i >= 0;--i) {
            sink(arr,i,length,compare);
        }
        for (int i = length; i > 0 ; --i) {
            swap(arr,0,i);
            sink(arr,0,i,compare);
        }
    }



    private static void sink(int[] arr,int parent,int length,Compare compare){

        int temp = arr[parent];
        int child;
        for (child=parent*2+1;child<=length;child=child*2+1){
            if (child+1<length && compare.compare(arr[child],arr[child+1])){
                ++ child;
            }
            if (compare.compare(arr[child],temp)){
                break;
            }
            arr[parent]= arr[child];
            parent = child;
        }
        arr[parent] = temp;
    }
}
