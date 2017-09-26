package 百度;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s11 = s1.split(" ");
        String[] s21 = s2.split(" ");
        Double sum1 = 0d;
        if(Double.valueOf(s11[0])>0)
             sum1 = 1/Double.valueOf(s11[s11.length-1]);
        for(int i= s11.length-2;i>1;i--){
            sum1 = 1/(Double.valueOf(s11[i])+sum1);
        }
        sum1+=Float.valueOf(s11[1]);
        Double sum2 =0d;
        if(Float.valueOf(s21[0])>0)
            sum2 = 1/Double.valueOf(s21[s21.length-1]);
        for(int i= s21.length-2;i>1;i--){
            sum2 = 1/(Double.valueOf(s21[i])+sum1);
        }
        sum2+=Double.valueOf(s21[1]);
        if(sum1<sum2)
            System.out.print("<");
        else if(sum1>sum2)
            System.out.print(">");
        else
            System.out.print("=");
    }

}
