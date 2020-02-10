package top.shaojie.strategy;

/**
 * @author ShaoJie
 * @Date 2019/11/15
 * @description 选择排序
 */
public class Sorter {

    /**
     * 选择排序（Selection sort）是一种简单直观的排序算法。
     * 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
     * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
     */

    public static void sort(int[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            int minPro = i;
            for (int j = i + 1; j < args.length; j++) {
                minPro = args[j] < args[minPro] ? j : minPro;
            }

            swap(args, i, minPro);
        }
    }

    static void swap(int[] args, int i, int j) {
        int temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }

}
