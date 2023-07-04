package change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import race.Driver;
import race.ExtremeDriver;
import race.NormalDriver;
import race.vehicle.Boat;
import race.vehicle.FastBoat;
import race.vehicle.NormalBoat;
import race.vehicle.parts.Engine;
import race.vehicle.parts.NormalEngine;
import race.vehicle.parts.NormalPropeller;
import race.vehicle.parts.PowerEngine;
import race.vehicle.parts.PowerPropeller;
import race.vehicle.parts.Propeller;

/**
 * 継承、実装の問題
 *
 */
public class Problem11 {

    /**
     * 様々な部品を組み合わせ、ボートレースをする問題
     * @param args
     */
    public static void main(String args[]) {

        // 1台目のボートを作る
        Engine engine01 = new NormalEngine();
        Propeller propeller01 = new NormalPropeller();
        Boat boat01 = new NormalBoat(engine01, propeller01, "01");

        Driver driver01 = new NormalDriver();
        boat01.ride(driver01);
        boat01.setFuel(100);

        // 2台目のボートを作る
        Engine engine02 = new NormalEngine();
        Propeller propeller02 = new PowerPropeller();
        Boat boat02 = new FastBoat(engine02, propeller02, "02");

        Driver driver02 = new NormalDriver();
        boat02.ride(driver02);
        boat02.setFuel(100);

        // 3台目のボートを作る
        Engine engine03 = new PowerEngine();
        Propeller propeller03 = new NormalPropeller();
        Boat boat03 = new NormalBoat(engine03, propeller03, "03");

        Driver driver03 = new ExtremeDriver();
        boat03.ride(driver03);
        boat03.setFuel(100);


        List<Boat> boatList = Arrays.asList(boat01, boat02, boat03);

        // レースの走行距離
        int mileage = 50;

        rase(boatList, mileage);
        graphicalRace(boatList, mileage);

        /* -- ここから問題 -- */
        /*
         * エンジン、プロペラ、ボート、ドライバーを追加しレースをせよ
         */

        /*
         * レースの走行距離が長い場合、燃料が切れてレースが終わらない。
         * 参加しているボートの燃料が全て切れた場合、レースを中断する
         * ように修正せよ
         */

        /*
         * 出力結果のが以下となるようなgraphicalRaceメソッドを作成せよ
         * ・現状の出力イメージ
         * 01が3進みました
         * 02が0進みました
         * 03が13進みました
         * 01がトータルで3進みました
         * 02がトータルで0進みました
         * 03がトータルで13進みました
         * ～繰り返し～
         *
         * ・新しい出力イメージ
         * ==================================================|ゴール
         * >>>01
         * 02
         * >>>>>>>>>>>>>03
         * ～繰り返し～
         */

        /*
         * コンストラクタに以下を持つ抽象クラスcarを作成し、
         * レースを実施せよ
         * コンストラクタ
         * ・エンジン(既存インターフェースを使用)
         * ・タイヤ(新規インターフェースを作成)
         * ・車体番号
         */

    }

    /**
     * レースを実施する
     * @param list 出場車リスト
     * @param distance 距離
     */
    public static void rase(List<Boat> list, int distance) {
        // 出場車のリストを表示する
        list.stream().forEach(boat -> boat.outputInfo());

        // それぞれのボートが進んだ距離を保持するマップを作成する
        Map<String, Integer> distanceMap = list.stream()
                .collect(Collectors.toMap(
                        (Boat s) -> s.getBoatName(), // キーをボートの番号にする
                        (Boat s) -> 0)); // 値は進んだ距離のため0固定にする

        boolean isRace = true;

        // どれかがゴールするまで続ける
        do {
            int fuelFlg = 0;
            for (Boat boat : list) {
                /* ---------- 燃料すべて0対応 START ---------- */
                if (boat.getFuel() == 0) {
                    fuelFlg++ ;
                    if (fuelFlg == list.size()) {
                        isRace = false;
                        System.out.println("ボートの燃料が全て切れたので、レースを中断します");
                    }
                }
                /* ---------- 燃料すべて0対応 END ---------- */
                int addDistance = boat.drive();
                System.out.println(boat.getBoatName() + "が" + addDistance + "進みました");

                // 進んだ距離をマップに設定する
                int curDistance = distanceMap.get(boat.getBoatName());
                distanceMap.put(boat.getBoatName(), curDistance + addDistance);
            }

            // 進んだ距離の累計とゴール判定
            for (String key : distanceMap.keySet()) {
                // 進んだ距離の累計を取得
                int curDistance = distanceMap.get(key);
                System.out.println(key + "がトータルで" + curDistance + "進みました");

                if (curDistance > distance) {
                    isRace = false;
                }
            }
        } while(isRace);

        // 結果を出力
        judge(distanceMap);
    }

    /**
     * 走行距離から着順を決める
     * @param result レース結果
     */
    private static void judge(Map<String, Integer> result) {

        List<String> rankList = new ArrayList<>();

        // 引数のマップを走行距離で降順ソートし、キーをリストに詰める
        result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) //MAPのバリュー(走行距離)で降順ソート
                .forEach(s -> {
                    rankList.add(s.getKey());
                });


        int rank = 0;
        int prevDistance = 0;

        System.out.println("=========== 結果発表 ===========");

        // 順位判定をおこなう
        for (int i = 0; i < rankList.size(); i++) {
            int curDistance = result.get(rankList.get(i));

            // 前の走行距離と同じ場合は順位は変えない
            if (curDistance != prevDistance) {
                rank ++;
            }
            System.out.println(rank + "位" + rankList.get(i));

            prevDistance = curDistance;

        }

    }

    /**
     * レース状況を視覚的に表示しながら実施する。
     * @param list 出場車リスト
     * @param distance 距離
     */
    public static void graphicalRace(List<Boat> list, int distance) {}

}
