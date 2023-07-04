package change;

import hierarchy.rides.BulletTrain;

/**
 * インターフェースの問題
 *
 */
public class Problem09 {

    /**
     * 乗り物での走行距離を求める
     * @param args
     */
    public static void main(String[] args) {

        // 走行距離
        int distance = 0;

        BulletTrain bulletTrain = new BulletTrain();
        bulletTrain.run("新幹線");
        distance += bulletTrain.trainRun();
        System.out.println("総走行距離は" + distance + "kmです");


        /* -- ここから問題 -- */

        /*
         * 「乗り物で走る」という「run」メソッド、
         * 及び「車で走る」という「carRun」メソッドを実装するための
         * 車を表すCarインターフェースを作成せよ
         */

        /*
         * スポーツカーを表すクラスSportsCarクラスを作成せよ
         * なお、Carインターフェースを実装すること
         * ※スポーツカーは1回につき120km進むものとする
         */

        /*
         * 普通車を表すクラスStandardCarクラスを作成せよ
         * なお、Carインターフェースを実装すること
         * ※普通車は1回につき80km進むものとする
         */

        /*
         * 新幹線、スポーツカー、普通車をそれぞれ1回ずつ使用し470km走行せよ
         */

    }

}
