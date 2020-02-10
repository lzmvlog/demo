package top.shaojie.factory.simplefactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:08
 * @Description： 方形工厂
 */
public class SquareFactory extends ShapeFactory {

    public Pattern drowSquare() {
        return new Square();
    }

}
