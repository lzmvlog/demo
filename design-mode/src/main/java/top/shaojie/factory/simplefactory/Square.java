package top.shaojie.factory.simplefactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月06日 20:56
 * @Description： 方形
 */
public class Square extends Pattern implements Shape {

    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
