package top.shaojie.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ShaoJie
 * @Date 2019/11/19
 */
public class MyThread01 {
    // volatile 使得 args 在线程中可见
    volatile List args = new ArrayList();

    public void add(int num) {
        args.add(num);
    }

    public int size() {
        return args.size();
    }

    public static void main(String[] args) {

        MyThread01 myThread = new MyThread01();

        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                if (myThread.size() != 5) {
                    try {
                        // wait() 会释放锁 notify() 不会释放锁
                        // 锁定当前对象 等待被唤醒
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("添加结束:" + myThread.size());
                lock.notify();
            }
        }, "t2").start();

        try {
            // 休眠一秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    myThread.add(i);
                    System.out.println("当前添加的是：" + i);

                    if (myThread.size() == 5) {
                        // notify() 唤醒当前被锁定的锁
                        lock.notify();

                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        // 休眠一秒
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}
