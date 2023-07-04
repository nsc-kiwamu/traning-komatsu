package change;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Comparatorの確認
 *
 * @param args
 */
public class Problem05 {

    /**
     * Comparatorを変えてソート条件を変更する問題
     *
     * @param args
     */
    public static void main(String[] args) {

        // 試験用データ
        List<Integer> dataList = Arrays.asList(7, 5, 10, 15, 20);

        // ソートその1(自然順序)
        System.out.println("ソート1(自然順序の昇順 その①");
        dataList.stream().sorted(Comparator.naturalOrder()).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // ソートその1(自然順序)
        System.out.println("ソート1(自然順序の昇順 その②");
        dataList.stream().sorted((l, r) -> l - r).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        System.out.println("ソート1(自然順序の昇順 その③");
        dataList.stream().sorted(new Comparator<Integer>() {
            public int compare(Integer l, Integer r) {
                System.out.println("l" + l);
                System.out.println("r" + r);
                /*
                 * このcompareメソッドで並び替えのルールを決めている
                 */
                return l - r;
            }
        }).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // ソートその2(自然順序逆順)
        System.out.println("ソート2(自然順序の降順 その①");
        dataList.stream().sorted(Comparator.reverseOrder()).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // ソートその2(自然順序逆順)
        System.out.println("ソート2(自然順序の降順 その②");
        dataList.stream().sorted((l, r) -> r - l).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // ソートその2(自然順序逆順)
        System.out.println("ソート2(自然順序の降順 その③");
        dataList.stream().sorted(new Comparator<Integer>() {
            public int compare(Integer l, Integer r) {
                return r - l;
            }
        }).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // ソートその3(独自ルール) 7を一番前にして、それ以外は自然順序昇順
        System.out.println("ソート3(独自ルール)");
        dataList.stream().sorted(new Comparator<Integer>() {
            public int compare(Integer l, Integer r) {
                if (l == 7) {
                    return -1;
                } else if (r == 7) {
                    return 1;
                } else {
                    return l - r;
                }
            }
        }).map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        /* -- ここから問題 -- */
        // Comparatorのcompareメソッドを実装し、以下の順序となるようなソート処理を実装せよ
        // 15が一番前になる、7が一番後ろになる、それ以外は昇順になる
        System.out.println("ソート4(問題)");

    }
}
