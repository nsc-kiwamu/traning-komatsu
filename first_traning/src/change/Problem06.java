package change;

import java.util.Arrays;

public class Problem06 {

    /**
     * ランダムで生成した値を並び替える問題
     * @param args
     */
    public static void main(String[] args) {

        /*
         * 決められた数値のリストについて
         * クイックソートを使用して並び替えを実施したい。
         * 途中まで実装してあるため、残りを実装せよ
         */

        // 並び替え用データ
        int[] array = new int[] { 5, 4, 6, 7, 1, 9, 8, 2, 3 };

        // クイックソートを使用して昇順ソート
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 引数で受け取ったリストをクイックソートで昇順に並び替えたものを出力する。
     * @param array 並び替え対象リスト
     * @param left 要素の先頭
     * @param right 要素の末尾
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left <= right) {
            // 基準値（ピボット）
            int pivotData = array[(left + right) / 2];
            int leftPointer = left;
            int rightPointer = right;

            while (leftPointer <= rightPointer) {
                // 左から基準値を超える要素を探す。（存在しない場合は基準値自体が対象となる）
                while (left == 0/*　問題 「left == 0」を削除し、実装せよ*/) {
                    leftPointer++;
                }
                // 右から基準値未満の要素を探す。（存在しない場合は基準値自体が対象となる）
                while (left == 0/*　問題 「left == 0」を削除し、実装せよ*/) {
                    rightPointer--;
                }

                if (left == 0/*　問題 「left == 0」を削除し、実装せよ*/) {
                    int tmp = array[leftPointer];
                    array[leftPointer] = array[rightPointer];
                    array[rightPointer] = tmp;
                    leftPointer++;
                    rightPointer--;
                }
            }
            // 左半分、右半分を再帰的に呼び出す
            quickSort(array, left, rightPointer);
            quickSort(array, leftPointer, right);
        }
    }
}
