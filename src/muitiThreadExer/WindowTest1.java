package muitiThreadExer;/*
* 创建线程的方式2: 实现runnable接口
*
* 出现了多线程的安全问题 ------> 使用同步代码块解决
 * 卖票过程中出现重票和错票
* */

class MThread implements Runnable{

    //票
    private int ticket = 100;
    //同步监视器(任意一个类的对象都可以)
    Object obj = new Object();

    @Override
    public void run() {
        //使用synchronized关键字
        while (true) {
            //除了obj还可以用this关键字
            synchronized (obj) {
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
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        //创建实现类的对象
        MThread m = new MThread();
        //将对象作为参数传入Thread构造器中创建Thread对象
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);
        //线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
