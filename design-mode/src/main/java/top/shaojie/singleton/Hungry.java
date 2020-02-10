package top.shaojie.singleton;

/**
 * @author ShaoJie
 * @Date 2019/11/15
 * @description 饿汉式的单例模式
 */
public class Hungry {

    private static Hungry init;

    static {
        init = new Hungry();
    }

    private Hungry() {
    }

    public static Hungry getInstance() {
        return init;
    }

    public static void main(String[] args) {
        // 不管用到与否，类加载时就完成实例化    简单点的理解可以是 不管你要干嘛 都需要做的准备工作
        // 由于当前类的构造器为 private 是 私有的  那也就是说 超出当前类就不能被实例化 也就是不能被 Mrg mrg = new Mrg();
        // 所以在获取的时候 只提供了 获取实例的方法 getInstance
        Hungry h1 = Hungry.getInstance();
        Hungry h2 = Hungry.getInstance();
        // 比较获取的对象是否是一个对象
        System.out.println(h1.equals(h2));
    }
}
