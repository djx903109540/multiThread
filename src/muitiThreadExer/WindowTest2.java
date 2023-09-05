package muitiThreadExer;

/*
* 使用同步方法解决线程安全问题
* */

class MThread1 implements Runnable{

    //票
    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            //调用同步方法
            show();
        }
    }

    //同步方法
    public synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": 第" + ticket + "张票已售出");
            ticket--;
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        //创建实现类的对象
        MThread1 m = new MThread1();
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
