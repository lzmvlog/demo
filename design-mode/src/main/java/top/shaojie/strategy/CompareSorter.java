package top.shaojie.strategy;

/**
 * @author： ShaoJie
 * @data： 2020年02月05日 21:31
 * @Description： 比较大小
 */
public class CompareSorter {

    public static void sort(Compare[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            int minPro = i;
            for (int j = i + 1; j < args.length; j++) {
                minPro = args[j].compareTo(args[minPro]) == -1 ? j : minPro;
        }
            swap(args, i, minPro);
        }
    }

    static void swap(Compare[] args, int i, int j) {
        Compare temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }
}
