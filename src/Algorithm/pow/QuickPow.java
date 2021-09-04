package Algorithm.pow;

public class QuickPow {

    public static int Pow(int x, int y){
        int ans = 1;
        int base = x;
        while (y!=0){
            if ((y&1)==1){
                ans *= base;
            }
            base *= base;
            y >>= 1;
        }
        return ans;
    }
    public static int Pow(int x,int y,int mod){
        int ans = 1;
        int base = x;
        while (y!=0){
            if ((y&1)==1){
                ans *= base;
                ans %= mod;
            }
            base *= base;
            base %= mod;
            y >>= 1;
        }
        return ans;
    }
}
