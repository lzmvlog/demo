package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 20:56
 * @Description： 方形
 */
public class Square extends Shape {

    public Shape draw() {
        System.out.println("Inside Square::draw() method.");
        return new Square();
    }
}
