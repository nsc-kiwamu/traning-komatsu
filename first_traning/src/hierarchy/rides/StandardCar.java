package hierarchy.rides;

/**
 *普通車を表すクラス
 *
 */

public class StandardCar implements Car {

 // 走行距離
    private static final int speed = 80;

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
        System.out.println("普通車で" + speed + "km進みました");
        return speed;
    };


}
