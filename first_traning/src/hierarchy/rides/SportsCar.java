package hierarchy.rides;

/**
 *スポーツカーを表すクラス
 *
 */

public class SportsCar implements Car {

 // 走行距離
    private static final int speed = 120;

    /**
     * 走行する
     * @param trainModel 車種
     */
    public void run(String carModel) {
        System.out.println(carModel + "で走ります");
    }

    /**
     * スポーツカーで走る
     */
    public int carRun() {
        System.out.println("スポーツカーで" + speed + "km進みました");
        return speed;
    };


}
