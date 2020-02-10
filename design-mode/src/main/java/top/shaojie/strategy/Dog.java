package top.shaojie.strategy;

/**
 * @author： ShaoJie
 * @data： 2020年02月05日 21:25
 * @Description： 狗
 */
public class Dog implements Compare {

    private Integer food;

    public Dog() {
        super();
    }

    public Dog(Integer food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return  "大小：" + this.food ;
    }

    public Integer compareTo(Object o) {
        Dog d = (Dog) o;
        if(this.food < d.food) return -1;
        else if (this.food > d.food) return 1;
        else return 0;
    }
}
