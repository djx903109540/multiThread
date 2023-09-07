package multiThreadExer1;

/*
* 线程通信实例：两个线程交替打印1-100的整数
* */

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {

                //唤醒
                notify();

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    try {
                        //阻塞，会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    break;
                }
            }
        }
    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
