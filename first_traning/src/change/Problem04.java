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
        List<Country> retList = dataList.parallelStream() // 並列で処理
                .map(r -> Country.getCountry(r)) // 数値を国番号として国情報を取得
                .collect(Collectors.toList()); // 取得したものをリストに格納

        return retList;
    }

    private static void aggregateNumber(List<Country> countryList) {
        // ※ 判定にif文ではなく、switch文を使用すること

        int japanPopulation = 0;
        int usaPopulation = 0;
        int chinaPopulation = 0;
        int indiaPopulation = 0;
        int ukPopulation = 0;
        int italyPopulation = 0;
        int fraPopulation = 0;
        int ausPopulation = 0;
        int korPopulation = 0;
        int canPopulation = 0;
        int deuPopulation = 0;

        for (Country country : countryList) {

            switch (country) {

            case JPN:
                japanPopulation++;
                break;

            case USA:
                usaPopulation++;
                break;

            case CHN:
                chinaPopulation++;
                break;

            case IND:
                indiaPopulation++;
                break;

            case GBR:
                ukPopulation++;
                break;

            case ITR:
                italyPopulation++;
                break;

            case FRA:
                fraPopulation++;
                break;

            case AUS:
                ausPopulation++;
                break;

            case KOR:
                korPopulation++;
                break;

            case CAN:
                canPopulation++;
                break;

            case DEU:
                deuPopulation++;
                break;

            default:
                //未定義の国にはなにもしない
                break;

            }

        }
        System.out.println("japan: " + japanPopulation);
        System.out.println("usa: " + usaPopulation);
        System.out.println("china: " + chinaPopulation);
        System.out.println("india: " + indiaPopulation);
        System.out.println("uk: " + ukPopulation);
        System.out.println("italy:" + italyPopulation);
        System.out.println("fra: " + fraPopulation);
        System.out.println("aus: " + ausPopulation);
        System.out.println("korea: " + korPopulation);
        System.out.println("canada: " + canPopulation);
        System.out.println("germany: " + deuPopulation);
    }
}
