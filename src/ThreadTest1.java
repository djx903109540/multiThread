/*
* 创建线程的方式2: 实现runnable接口
* */

class MThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread m = new MThread();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.start();
        t2.start();
    }
}
