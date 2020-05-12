package top.shaojie.strategy;

import java.util.Arrays;

/**
 * @author ShaoJie
 * @Date 2019/11/15
 * <p>
 * 策略组模式
 */
public class Main {

    public static void main(String[] args) {
//        int[] a = {9, 2, 3, 5, 7, 1, 4};
//        Sorter sorter = new Sorter();
//        sorter.sort(a);
        Dog[] dogs = {new Dog(3), new Dog(1), new Dog(2)};
        CompareSorter.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }
}
