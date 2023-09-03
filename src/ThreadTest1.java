/*
* 创建线程的方式2: 实现runnable接口
* */

class MThread implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        /*
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
        */
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 第" + ticket + "张票已售出");
                ticket--;
            }
            else{
                break;
            }
        }
    }
}

public class ThreadTest1 {
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
