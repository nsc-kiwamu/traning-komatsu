package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.NumericUtil;

public class Problem01 {

    /**
     * ランダムで生成した数値を振り分ける問題
     * @param args
     */
    public static void main(String[] args) {

        /*
         * ランダムに生成した数値のリストについて
         * 偶数のみ出力するメソッドと奇数のみ出力するメソッドを用意した。
         * これを参考に以降の問題の回答を作成せよ
         */

       // テスト用のランダムデータを作成
        List<Integer> testList = NumericUtil.makeRandomList(10, 100);

        // ランダム生成したデータを一覧として出力
        outputTestNumber(testList);

        // 偶数の一覧を出力
        outputEvenNumber(testList);

        // 奇数の一覧を出力
        outputOddNumber(testList);

        /* -- ここから問題 -- */
        // 3の倍数の一覧を出力
        outputAnyNumber(testList);

        // 奇数の一覧を昇順ソートして出力
        outputSortOddNumber(testList);

    }

    /**
     * 引数で受け取った数値の一覧を出力する。
     * @param testDatalist 振り分け対象データ
     */
    public static void outputTestNumber(List<Integer> dataList) {

        System.out.println("テストデータ一覧");

        for (int i = 0; i < dataList.size(); i++) {
            System.out.print("[" + dataList.get(i) + "]");
        }

        System.out.println("");

    }
    /**
     * 引数で受け取った数値から偶数のみを出力する。
     * @param testDatalist 振り分け対象データ
     */
    public static void outputEvenNumber(List<Integer> dataList) {

        System.out.println("偶数一覧");

        // 2で割り切れたら偶数
        dataList.stream()
        .filter(s -> s % 2 == 0 )
        .map(s -> "[" + s + "]" )
        .forEach(System.out::print);

        System.out.println("");

    }

    /**
     * 引数で受け取った数値から奇数のみを出力する。
     * @param testDatalist 振り分け対象データ
     */
    public static void outputOddNumber(List<Integer> dataList) {

        System.out.println("奇数一覧");

        // 2で割り切れなかったら奇数
        for (Integer data : dataList) {
            if (data % 2 != 0) {
                System.out.print("[" + data + "]");
            }
        }

        System.out.println("");
    }

    public static void outputAnyNumber(List<Integer> dataList) {

        System.out.println("3の倍数一覧");

        //3で割り切れたら3の倍数
         dataList.stream()
         .filter(s -> s % 3 == 0 )
         .map(s -> "[" + s + "]" )
         .forEach(System.out::print);

         System.out.println("");

    }

    public static void outputSortOddNumber(List<Integer> dataList) {

        System.out.println("奇数の一覧を昇順に");

        // 2で割り切れなかったら奇数
        List<Integer> oddList = new ArrayList<>();
        for (Integer data : dataList) {
            if (data % 2 != 0) {
                oddList.add(data);

            }
        }

        //昇順にソート
        Collections.sort(oddList);

        //ソートされた奇数の一覧表示
        for(Integer oddNumber : oddList) {
            System.out.println("[" + oddNumber +"]");
        }

        System.out.println("");


    }

}
