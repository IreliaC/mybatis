package com.joyowo.mybatis.nio;

/**
 * Author: chenby
 * Date: 2018-01-05
 *
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；
 * 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
 B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
 C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 */
public class Sync implements Runnable {
    private static int count;

    public Sync() {
        count = 0;
    }
    @Override
    public void run() {
        method();
    }

    public synchronized static void  method() {
        for (int i = 0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + count++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Sync sync1 = new Sync();
        Sync sync2 = new Sync();
        Thread t1 = new Thread(sync1,"t1");
        Thread t2 = new Thread(sync2,"t2");
        t1.start();
        t2.start();

    }



}
