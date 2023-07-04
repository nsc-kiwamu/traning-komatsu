package change;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import util.Country;
import util.NumericUtil;

/**
 * 国別の人口を調査する問題
 * @param args
 */
public class Problem04 {

    /**
     * 国別の人口を調査する問題
     * @param args
     */
    public static void main(String[] args) {

        // テストデータとして、1000人分の人口データを取得
        List<Country> countryList = makeTestData(1000);

        /* -- ここから問題 -- */
        /* 国毎の人口を集計するメソッド(aggregateNumber)を実装せよ
         *
         *
         */
        aggregateNumber(countryList);

        /* -- ここから問題 -- */
        /* 列挙値「Country」に新しい国を追加し、再度人口を集計せよ
         *
         *
         */

    }

    /**
     * 引数で指定された要素数分の国情報を作成し返却する。
     * @param indexCount 作成する要素数
     * @return 国情報リスト
     */
    private static List<Country> makeTestData(int indexCount) {

        // 国情報の配列をリストに変換する。
        List<Country> countryList = Arrays.asList(Country.values());

        // 国情報リストから国番号が最大のものを取得する
        Optional<Country> maxNumCountry = countryList.stream().max((l, r) -> l.getNumber() - r.getNumber());
        int maxNumber = maxNumCountry.get().getNumber();

        // 国番号の最大に合わせて、ランダム値を取得する
        List<Integer> dataList = NumericUtil.makeRandomList(indexCount, maxNumber);

        // 作成したランダム値のリストを国情報リストに変換する
        List<Country> retList =
                dataList.parallelStream() // 並列で処理
                        .map(r -> Country.getCountry(r)) // 数値を国番号として国情報を取得
                        .collect(Collectors.toList());   // 取得したものをリストに格納

        return retList;
    }


    private static void aggregateNumber(List<Country> countryList) {
        // ※ 判定にif文ではなく、switch文を使用すること
    }
}
