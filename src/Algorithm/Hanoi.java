package Algorithm;

/**
 * tower of hanoi
 * recursion algorithm
 * */
public class Hanoi {
    /**
     * @param n N pieces of hanoi tower
     * @param a all pieces will be put there when the game start
     * @param b empty tower to help us exchange piece of a tower to c tower
     * @param c all pieces will be put there when the game end
     * */
    public static void hanoi(int n,char a,char b,char c){
        if (n==0){
            return;
        }
        hanoi(n-1,a,c,b);
        System.out.printf("%c -> %c\n",a,c);
        hanoi(n-1,b,a,c);
    }

    /**
     * acquiescence situation the character is a , b and c*/

    public static void hanoi(int n){
        hanoi(n,'a','b','c');
    }
}
