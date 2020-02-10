package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:51
 * @Description： 形状工厂
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Paint write() {
        return new Pencil();
    }

    @Override
    public Shape draw() {
        return new Square();
    }
}
