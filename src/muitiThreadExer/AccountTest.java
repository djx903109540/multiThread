package muitiThreadExer;

/* 同步机制实现版
* 实例-存钱问题
* 两个储户向同一个账户同时存3000元，每次1000元，存3次
* 每次打印余额
* */

class Account{

    //余额
    private double balance;

    Account(double b){
        this.balance = b;
    }

    public synchronized void deposit(double b){
        if (b > 0) {
            balance += b;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": 存钱成功！当前余额为" + balance);
        }
    }

}

class User1 implements Runnable{

    //用户持有的账户
    Account acct;

    User1(Account ac){
        this.acct = ac;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account ac = new Account(0);
        User1 u1 = new User1(ac);
        Thread t1 = new Thread(u1);
        Thread t2 = new Thread(u1);
        t1.setName("小王");
        t2.setName("小明");
        t1.start();
        t2.start();
    }
}
