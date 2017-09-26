import java.util.*;
//public class Test {
//    public static void main(String[] args){
//        List<Object> l =new ArrayList<>();
//        while (true)
//            l.add(new Object());
//    }
//}
class Consumer implements Runnable {

    @Override
    public synchronized void run() {
        // TODO Auto-generated method stub
        int count = 10;
        while(count > 0) {
            synchronized (Test. obj) {

                System. out.print( "B");
                count --;
                Test. obj.notify(); // 主动释放对象锁

                try {
                    Test. obj.wait();

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
class Produce implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        int count = 10;
        while(count > 0) {
            synchronized (Test. obj) {

                //System.out.print("count = " + count);
                System. out.print( "A");
                count --;
                Test. obj.notify();

                try {
                    Test. obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }

}
public class Test {

    public static final Object obj = new Object();

    public static void main(String[] args) {

        new Thread( new Produce()).start();
        new Thread( new Consumer()).start();

    }
}