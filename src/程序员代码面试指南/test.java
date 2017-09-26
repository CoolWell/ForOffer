package 程序员代码面试指南;
import java.util.*;
public class test
{
//    public static void main(String[] args){
//        int i = 0;
//        int j = i++ + ++i;
//        int k = --i + i--;
//
//        StringBuffer sb = new StringBuffer("i love you");
//        sb.replace(2,6,"hate");
//        System.out.print(sb.toString());
//    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] c = line.split("->");
        for(int i=0;i<c.length;i+=2){
            if(i>=c.length-1)
                break;
            String tmp = c[i];
            c[i] = c[i+1];
            c[i+1] = tmp;
        }
        for(int i=0;i<c.length-1;i++){
            System.out.print(c[i]+"->");
        }
        System.out.print(c[c.length-1]);

    }
}
