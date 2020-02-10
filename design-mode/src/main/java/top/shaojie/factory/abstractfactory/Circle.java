package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 20:56
 * @Description： 圆形
 */
public class Circle extends Shape {

    public Shape draw() {
        System.out.println("Inside Circle::draw() method.");
        return new Circle();
    }
}
