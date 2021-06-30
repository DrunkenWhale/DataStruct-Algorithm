package Struct.Graph;
/** 树状数组 **/
public class BinaryIndexedTree {
    private int[] arr       = null;
    private int[] treeArray = null;
    private int   arrayBound= 0;

    public BinaryIndexedTree(int[] arr,int arrayBound){
        this.arr = arr;
        this.treeArray = new int[arrayBound+1];
        /* 从1到arrayBound */
        /* arr可能不是正好卡到元素数量上限 所以不如手动指定数组边界 */
        this.arrayBound = arrayBound;
        this.init();
    }

    private void init(){
        for (int i=1;i<=arrayBound; ++i){
            treeArray[i] += arr[i];
            int temp = i + lowBit(i);
            if (temp<=arrayBound){
                treeArray[temp] += treeArray[i];
            }
        }
    }

    public void add(int index,int addValue){
        while(index <= this.arrayBound){
            this.treeArray[index] += addValue;
            index += lowBit(index);
        }
    }

    public int getSum(int index){
        int ans = 0;
        while (index >= 1){
            ans += treeArray[index];
            index -= lowBit(index);
        }
        return ans;
    }

    private int lowBit(int x){
        return x & -x;
    }

}
