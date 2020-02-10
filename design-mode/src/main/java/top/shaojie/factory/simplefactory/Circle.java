package top.shaojie.factory.simplefactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 20:56
 * @Description： 圆形
 */
public class Circle extends Pattern implements Shape {

    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
