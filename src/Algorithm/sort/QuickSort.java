package Algorithm.sort;

/**
 * 快速排序
 * */
public class QuickSort extends Sort{

    /**
     * 写了个函数式的接口来着
     * 这样更灵活?（才不会啦！）
     * @param compare lambda表达式
     * */
    public static void sort(int[] arr,Compare compare){
        sort(arr,0,arr.length-1,compare);
    }

    /**
     * @params
     *  arr     要排序的数组
     *  left    要排序的数组的左边界
     *  right   要排序的数组的右边界
     * */
    public static void sort(int[] arr,int left,int right,Compare compare){
        if (right<=left){
            // 这个不用注释吧..
            return;
        }
        // pivot作为快排的基准点 默认取数组左边界的值
        // 也可视为将数组左边界上的值挖空
        int pivot = arr[left];
        // 定义两个游标
        int i = left;
        int j = right;
        // 当两个游标相遇时结束循环
        while (i < j){
            // 当匿名函数返回true的时候 右边游标左移
            while(i<j && compare.compare(arr[j],pivot)){
                -- j;
            }
            // 说明上述的某种比值关系被改变了 此时 将数组左游标(被挖空)的地方赋值为
            // 改变了比值关系的那个值 同时将左游标右移
            // 挖空右游标上的值
            if (i<j){
                arr[i++] = arr[j];
            }
            // 同上 不过调换了左右游标挖空和赋值的顺序
            while (i<j && compare.compare(pivot,arr[i])){
                ++ i;
            }
            if (i<j){
                arr[j--] = arr[i];
            }
        }
        // 循环结束了 这次将最后挖空的位置赋值为最初始的基准值
        arr[i] = pivot;
        // 对左右两个区间递归进行排序
        sort(arr,left,i-1,compare);
        sort(arr,i+1,right,compare);
    }
}
