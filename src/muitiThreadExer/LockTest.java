package muitiThreadExer;

/*
* 使用Lock锁解决线程安全问题  ---jdk5.0新增
* */

import java.util.concurrent.locks.ReentrantLock;

class Window2 implements Runnable{

    //票
    private static int ticket = 100;

    //锁对象
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {

                //上锁
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": 第" + ticket + "张票已售出");
                    ticket--;
                } else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
