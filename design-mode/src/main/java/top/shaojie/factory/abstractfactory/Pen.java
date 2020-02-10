package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:29
 * @Description： 钢笔
 */
public class Pen extends Paint {

    public Paint write() {
        System.out.println("Inside pen::write() method.");
        return new Pen();
    }
}
