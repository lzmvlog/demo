package top.shaojie.Iterator;

/**
 * @author： ShaoJie
 * @data： 2020年02月09日 16:27
 * @Description： 迭代器模式
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
