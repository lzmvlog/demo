package top.shaojie.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ShaoJie
 * @Date 2019/11/19
 * 启动一个线程向一个集合（数组）中加10的数
 * 启动另一个线程 检测上一个线程 当加到 5 时 停止添加
 */
public class MyThread {

    // volatile 使得 args 在线程中可见
    volatile List args = new ArrayList();

    public void add(int num) {
        args.add(num);
    }

    public int size() {
        return args.size();
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myThread.add(i);
                System.out.println("当前添加的是：" + i);

                try {
                    // 休眠一秒
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (myThread.size() == 5) {
                    break;
                }
            }
            System.out.println("添加结束:" + myThread.size());
        }, "t2").start();

    }
}
