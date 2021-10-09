package Algorithm;
// 前缀函数
public class Prefix {

    public static int[] getPrefixArray(String str){
        int[] pi = new int[str.length()];
        for (int i = 1; i < pi.length; i++) {
            int j = pi[i-1];
            while(j>0 && str.charAt(i)!=str.charAt((j))){
                j = pi[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
                ++ j;
            }
            pi[i] = j;
        }
        return pi;
    }

}
