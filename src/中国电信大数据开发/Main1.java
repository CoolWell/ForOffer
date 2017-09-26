package 中国电信大数据开发;

import java.util.*;

public class Main1 {
    public static int compute(int num){
        int ret = 0;
        while(num!=0){
            int x = num%10;
            ret+=(x*x);
            num/=10;
        }
        return ret;
    }
    public static boolean solve(int num) {
        int rst = num;
        HashSet<Integer> myset = new HashSet<>();
        while (true) {
            rst = compute(rst);
            if (rst == 1)
                return true;
            if (myset.contains(rst))
                return false;
            myset.add(rst);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ret = solve(n);
        if(ret)
            System.out.print("true");
        else
            System.out.print("false");

    }

}
