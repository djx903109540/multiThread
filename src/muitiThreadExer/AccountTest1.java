package muitiThreadExer;

/* 同步机制继承版
 * 实例-存钱问题
 * 两个储户向同一个账户同时存3000元，每次1000元，存3次
 * 每次打印余额
 * */

class Account1{

    //账户余额
    private double balance;
    Account1(double b){
        this.balance = b;
    }

    public void deposit(double b){
        if (b > 0) {
            synchronized (this) {
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
}

class User extends Thread{

    //用户持有的账户
    Account1 acct;

    User(Account1 ac){
        this.acct = ac;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            acct.deposit(1000);
        }
    }
}

public class AccountTest1 {
    public static void main(String[] args) {
        Account1 a = new Account1(0);
        User u1 = new User(a);
        User u2 = new User(a);
        u1.setName("小王");
        u2.setName("小明");
        u1.start();
        u2.start();
    }
}
