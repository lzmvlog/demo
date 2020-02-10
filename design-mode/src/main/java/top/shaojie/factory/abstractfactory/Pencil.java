package top.shaojie.factory.abstractfactory;

/**
 * @author： ShaoJie
 * @data： 2020年02月07日 16:29
 * @Description： 铅笔
 */
public class Pencil extends Paint {

    public Paint write() {
        System.out.println("Inside Pencil::write() method.");
        return new Pencil();
    }

}
