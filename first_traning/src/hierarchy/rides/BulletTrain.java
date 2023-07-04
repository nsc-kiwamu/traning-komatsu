package hierarchy.rides;

/**
 * 新幹線を表すクラス
 *
 */
public class BulletTrain implements Train {

    // 走行距離
    private static final int speed = 270;

    /**
     * 走行する
     * @param trainModel 車種
     */
    public void run(String trainModel) {
        System.out.println(trainModel + "で走ります");
    }

    /**
     * 新幹線で走る
     */
    public int trainRun() {
        System.out.println("新幹線で" + speed + "km進みました");
        return speed;
    };


}
