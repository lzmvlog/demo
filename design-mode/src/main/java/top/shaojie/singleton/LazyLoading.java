package top.shaojie.singleton;

/**
 * @author ShaoJie
 * @Date 2019/11/15
 * @description 懒汉加载模式
 */
public class LazyLoading {

    private static volatile LazyLoading init;

    public LazyLoading() {
    }

    /**
     * 当需要的时候 才需要被实例化
     * 但是这样会带来线程问题 因此创建的对象并不是同一个 因此并不是单例模式 所以 需要修改创建的方式
     * 怎么来判断是否是对一个对象呢？ 建议打印出对象的地址观察 发现地址并不是同一个
     *
     * @return
     */
    public static LazyLoading getInstance01() {
        if (init == null) {
            try {
                // 使线程休眠一秒 模拟线程被打乱
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            init = new LazyLoading();
        }
        return init;
    }

    /**
     * 使用锁来解决线程问题 给当前的线程加锁 这时创建的就是用一个对象了
     * 但是效率有所下降
     *
     * @return
     */
    public static synchronized LazyLoading getInstance02() {
        if (init == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            init = new LazyLoading();
        }
        return init;
    }

    /**
     * 使用同步代码块来提高效率 （通过减小同步代码块的方式来提高效率 但是还是存在线程的问题）
     *
     * @return
     */
    public static LazyLoading getInstance03() {
        if (init == null) {
            synchronized (LazyLoading.class) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                init = new LazyLoading();
            }
        }
        return init;
    }

    /**
     * 双重检查
     * 这种写法很完美 但是需要在加上 volatile 也就是 private static volatile LazyLoading init;
     * 如果不加 volatile 会在初始化时就返回 init 对象
     *
     * @return
     */
    public static LazyLoading getInstance04() {
        if (init == null) {
            synchronized (LazyLoading.class) {
                if (init == null) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    init = new LazyLoading();
                }
            }
        }
        return init;
    }

    /**
     * 静态内部类方式 在加载类时 不会初始化内部类
     * 如何保证线程安全？
     * JVM 在加载一个类时 只会加载一次
     */
    public static class LazyLodingHolder {
        private final static LazyLoading init = new LazyLoading();
    }

    public static LazyLoading getInstance05() {
        return LazyLodingHolder.init;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // 模拟线程访问
            new Thread(() ->
                    // 打印出对象的地址 发现地址不同
                    // System.out.println(LazyLoading.getInstance01())
                    // 地址是相同了 但是效率缺下降了
                    // System.out.println(LazyLoading.getInstance02())
                    // System.out.println(LazyLoading.getInstance03())
                    // System.out.println(LazyLoading.getInstance04())
                    System.out.println(LazyLoading.getInstance05())
            ).start();
        }
    }

}
