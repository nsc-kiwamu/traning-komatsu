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
import race.SubtleDriver;
import race.SuperDriver;
import race.vehicle.Boat;
import race.vehicle.Car;
import race.vehicle.FastBoat;
import race.vehicle.NormalBoat;
import race.vehicle.NormalCar;
import race.vehicle.SubtleBoat;
import race.vehicle.Vehicle;
import race.vehicle.parts.Engine;
import race.vehicle.parts.NormalEngine;
import race.vehicle.parts.NormalPropeller;
import race.vehicle.parts.NormalTire;
import race.vehicle.parts.PowerEngine;
import race.vehicle.parts.PowerPropeller;
import race.vehicle.parts.Propeller;
import race.vehicle.parts.SubtleEngine;
import race.vehicle.parts.SubtlePropeller;
import race.vehicle.parts.SuperEngine;
import race.vehicle.parts.Tire;

/**
 * 継承、実装の問題
 *
 */
public class Problem12 {

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

        //4台目のボートを作る
        Engine engine04 = new SuperEngine();
        Propeller propeller04 = new NormalPropeller();
        Boat boat04 = new NormalBoat(engine04, propeller04, "04");

        Driver driver04 = new SuperDriver();
        boat04.ride(driver04);
        boat04.setFuel(100);

        //5台目のボートを作る
        Engine engine05 = new SubtleEngine();
        Propeller propeller05 = new SubtlePropeller();
        Boat boat05 = new SubtleBoat(engine05, propeller05, "05");

        Driver driver05 = new SubtleDriver();
        boat05.ride(driver05);
        boat05.setFuel(100);

        //車で6人目をレースに参加させる
        Engine engine06 = new NormalEngine();
        Tire tire01 = new NormalTire();
        Car car01 = new NormalCar(engine06, tire01, "06");

        Driver driver06 = new NormalDriver();
        car01.ride(driver06);
        car01.setFuel(100);

        List<Vehicle> boatList = Arrays.asList(boat01, boat02, boat03, boat04, boat05, car01);

        // レースの走行距離
        int mileage = 100;
        //500でも正常に動くことを確認しました。

        //rase(boatList, mileage);
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
         * 実行する際はraceメソッドはコメントアウトし実行すること
         *
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
    /*public static void rase(List<Vehicle> list, int distance) {
        // 出場車のリストを表示する
        list.stream().forEach(boat -> boat.outputInfo());

        // それぞれのボートが進んだ距離を保持するマップを作成する
        Map<String, Integer> distanceMap = list.stream()
                .collect(Collectors.toMap(
                        (Vehicle s) -> s.getBoatName(), // キーをボートの番号にする
                        (Vehicle s) -> 0)); // 値は進んだ距離のため0固定にする

        boolean isRace = true;

        // どれかがゴールするまで続ける
        do {
            int boatsOutOfFuel = 0;

            for (Vehicle boat : list) {
                int addDistance = boat.drive();
                System.out.println(boat.getBoatName() + "が" + addDistance + "進みました");

                // 進んだ距離をマップに設定する
                int curDistance = distanceMap.get(boat.getBoatName());
                distanceMap.put(boat.getBoatName(), curDistance + addDistance);

                //燃料が0以下でレースを中断する
                if (boat.getFuel() <= 0) {
                    boatsOutOfFuel++;
                }

            }

            if (list.size() == boatsOutOfFuel) {
                isRace = false;
                System.out.println("全てのボートの燃料が切れたのでレースを中断します");
                return;
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
        } while (isRace);

        // 結果を出力
        judge(distanceMap);
    }*/

    /**
     * 走行距離から着順を決める
     * @param result レース結果
     */
    private static void judge(Map<String, Integer> result) {

        List<String> rankList = new ArrayList<>();

        // 引数のマップを走行距離で降順ソートし、キーをリストに詰める
        rankList = result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) //MAPのバリュー(走行距離)で降順ソート
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        int rank = 0;
        int prevDistance = 0;

        System.out.println("=========== 結果発表 ===========");

        // 順位判定をおこなう
        for (int i = 0; i < rankList.size(); i++) {
            int curDistance = result.get(rankList.get(i));

            // 前の走行距離と同じ場合は順位は変えない
            if (curDistance != prevDistance) {
                rank++;
            }
            System.out.println(rank + "位" + rankList.get(i));

            prevDistance = curDistance;

        }

    }

    /**
    * レース状況を視覚的に表示しながら実施し、結果を出力する。
    * @param list 出場車リスト
    * @param distance 距離
    */
    public static void graphicalRace(List<Vehicle> list, int distance) {
        String separator = new String(new char[distance]).replace('\0', '=') + "|ゴール";

        // それぞれのボートが進んだ距離を保持するマップを作成する
        Map<String, Integer> distanceMap = list.stream()
                .collect(Collectors.toMap(
                        (Vehicle s) -> s.getBoatName(), // キーをボートの番号にする
                        (Vehicle s) -> 0)); // 値は進んだ距離のため0固定にする

        boolean isRace = true;

        do {
            int boatsOutOfFuel = 0;
            System.out.println(separator);

            for (Vehicle boat : list) {
                String boatName = boat.getBoatName();
                StringBuilder boatLine = new StringBuilder();
                int addDistance = boat.drive();

                int position = distanceMap.get(boatName);
                distanceMap.put(boatName, position + addDistance);

                //燃料が0以下でレースを中断する
                if (boat.getFuel() <= 0) {
                    boatsOutOfFuel++;
                }

                for (int i = 0; i < distanceMap.get(boatName); i++) {
                    boatLine.append(">");
                }

                boatLine.append(boatName);

                System.out.println(boatLine.toString());

            }

            if (list.size() == boatsOutOfFuel) {
                isRace = false;
                System.out.println("全てのボートの燃料が切れたのでレースを中断します");
                return;
            }

            // 進んだ距離の累計とゴール判定
            for (String key : distanceMap.keySet()) {
                // 進んだ距離の累計を取得
                int position = distanceMap.get(key);

                if (position > distance) {
                    isRace = false;
                }
            }

        } while (isRace);

        // レース結果を出力
        judge(distanceMap);
    }

}
