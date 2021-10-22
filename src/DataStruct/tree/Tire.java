package DataStruct.tree;

public class Tire {

    private final int[][] next;
    private final boolean[] exist;
    private int cnt = 0;


    public Tire(int N) {
        this.next = new int[N][26]; // 只能处理英文字符串诶 还得都是小写 这里可以适当扩张
        this.exist = new boolean[N];
    }

    public Tire() {
        this.next = new int[114514][26];
        this.exist = new boolean[114514];
    }

    public void insert(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); ++i) {
            int c = str.charAt(i) - 'a';
            if (next[p][c] == 0) {
                next[p][c] = ++cnt;
            }
            p = next[p][c];
        }
        exist[p] = true;
    }

    public boolean find(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); ++i) {
            int c = str.charAt(i) - 'a';
            if (next[p][c] == 0) {
                return false;
            }
            p = next[p][c];
        }
        return exist[p];
    }

}
