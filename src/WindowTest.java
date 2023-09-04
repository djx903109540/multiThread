
/*
* 多线程实践   实现多窗口卖票
*
* 出现了多线程的安全问题 ------> 使用java同步机制解决
* 卖票过程中出现重票和错票
* */

class Window extends Thread{

    //票
    private static int ticket = 100;

    @Override
    public void run() {

        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 第" + ticket + "张票已卖出");
                ticket--;
            }
            else{
                break;
            }
        }

    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
