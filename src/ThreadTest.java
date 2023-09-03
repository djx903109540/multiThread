class MyThread extends Thread{

    //遍历100以内的偶数
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" +i);
            }
            //满足特定条件时，释放cpu执行权
            if(i % 20 == 0){
                yield();
            }
        }
    }
}

class MyThread1 extends Thread{

    //遍历100以内的奇数
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+ ":" +i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread1 mt1 = new MyThread1();
        mt.setPriority(Thread.MAX_PRIORITY);
        mt1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(mt.getPriority());
        System.out.println(mt1.getPriority());
        mt.start();
        mt1.start();
    }
}
