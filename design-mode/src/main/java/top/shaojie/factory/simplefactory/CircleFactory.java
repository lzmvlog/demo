package top.shaojie.factory.simplefactory;


/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:08
 * @Description： 圆形工厂
 */
public class CircleFactory extends ShapeFactory {

    public Pattern drowCircle(){
        return new Circle();
    }

}
