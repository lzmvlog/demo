package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:38
 * @Description： 主测试 抽象工厂
 *      抽象工厂用于 扩展产品族 只需要添加类似 PatternFactory 的工厂
 *      在其中确定由 什么样的笔来画 什么样的图案
 *      其实就是在确定好的抽象工厂中 去实现具体需要生产的对象
 *      参考  https://www.runoob.com/design-pattern/abstract-factory-pattern.html
 *       一般用于产品一族维度扩展
 */
public class Main {

    public static void main(String[] args) {
        // AbstractFactory factory = new PatternFactory();
        AbstractFactory factory = new ShapeFactory();

        Paint paint = factory.write();
        paint.write();
        Shape shape = factory.draw();
        shape.draw();
    }
}
