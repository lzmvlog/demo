package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:40
 * @Description： 图案工厂 可继续扩展 扩展只需要确定 继续 抽象的工厂
 */
public class PatternFactory extends AbstractFactory {

    @Override
    public Paint write() {
        return new Pen();
    }

    @Override
    public Shape draw() {
        return new Circle();
    }
}
