package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 課題用の数値を使うユーティリティクラス<br>
 *
 */
public class NumericUtil {

    /**
     * 引数の内容に応じて、0以上のランダムな数値を作成し返却する。
     * @param indexCount ランダム生成する要素数
     * @param maxValue ランダム生成する数の最大値
     * @return ランダム生成された数値のリスト
     */
    public static List<Integer> makeRandomList(int indexCount, int maxValue) {

        List<Integer> retList = new ArrayList<>();
        Random random = new Random();

        IntStream.range(0, indexCount).forEach(i -> {
            // 指定された上限値は含まないため、+1で渡す
            retList.add(random.nextInt(maxValue + 1));
        });

        return retList;

    }

}
