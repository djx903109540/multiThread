package muitiThreadExer;

class Window1 extends Thread{

    //票
    private static int ticket = 100;

    @Override
    public void run() {

        while(true){
            show();
        }
    }

    public static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": 第" + ticket + "张票已卖出");
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
