package race.vehicle;

import race.DriveType;
import race.Driver;
import race.vehicle.parts.Engine;
import race.vehicle.parts.Tire;

/**
 * 車を表現する抽象クラス
 *
 */
public abstract class Car implements Vehicle {

    /**
     * 車を運転するドライバー
     */
    private Driver driver = null;

    /**
     * プロペラを回すためのエンジン
     */
    private Engine engine = null;

    /**
     * エンジンの出力を動力に変えるタイヤ
     */
    private Tire tire = null;

    /**
     * エンジンを動かすための燃料
     */
    private int fuel = 0;

    /**
     * 車を識別するための車体名
     */
    private String boatName = null;

    private Car() {
        // デフォルトコンストラクタは実行不可とする
    }

    /**
     * 車をセットアップする
     * @param engine セットアップするエンジン
     * @param tire セットアップするタイヤ
     * @param boatName 車体番号
     * @return セットアップ済みの車
     */
    public Car (Engine engine, Tire tire, String boatName) {
        this.engine = engine;
        this.tire = tire;
        this.boatName = boatName;
    }

    public void outputInfo() {
        System.out.println("--------- 車体番号" + boatName + "の情報 ---------");
        System.out.println("ドライバー:" + driver.getClass().getSimpleName());
        System.out.println("エンジン:" + engine.getClass().getSimpleName());
        System.out.println("タイヤ:" + tire.getClass().getSimpleName());
        System.out.println("燃料:" + fuel);
    }


    /**
     * 車に燃料を積み込む
     * @param fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    /**
     * 車の燃料を確認する
     * @param fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * 車にドライバーが乗り込む
     * @param driver ドライバー
     */
    public void ride(Driver driver) {
        this.driver = driver;
    }

    /**
     * 車を運転する
     * @return 進んだ距離
     */
    public final int drive() {

        // 走れる状態かチェック
        if (driver == null) {
            System.err.println("ドライバーがいないので走りません。");
            return 0;
        }

        if (fuel == 0) {
            System.err.println("燃料が無いので走りません。");
            return 0;
        }

        // ドライバーの行動により、処理を変える
        DriveType type = driver.drive();

        switch (type) {
        case moveOn:
            // 推進力に車体固有の抵抗をものを返却
            return (int) (getDrivingForce() * getResistivity());
        case Bend:
            // 曲がった場合は最後に0.5倍する
            return (int) (getDrivingForce() * getResistivity() * 0.5);
        default:
            // 止まった場合は処理なし
            return 0;
        }

    }

    /**
     * 推進力を返却する
     * @return 推進力
     */
    private final int getDrivingForce() {
        int distance = 0;

        // 使用する燃料を決める
        int useOil = getOil();

        // 使用した分、燃料を減らす
        fuel -= useOil;

        // 燃料がマイナスになったら使えないので、使用量から減らす
        if (fuel < 0) {
            useOil += fuel;
            fuel = 0;
        }

        // 燃料を使用してエンジンから動力を得る
        int power = engine.getPower(useOil);

        // 得た動力をタイヤを使用して推進力に変える
        int movePower = tire.getForce(power);

        // 推進力をドライバーのスキルで上乗せする
        distance = (int) (movePower * driver.getDrivingSkills());

        return distance;
    }
    /**
     * 車の地面の抵抗を返却する。
     * @return 水の抵抗
     */
    protected double getResistivity() {
        // デフォルトは抵抗1とする
        return 1.0;
    }

    /**
     * 車体名を返却する。
     * @return 車体名
     */
    public final String getBoatName() {
        return boatName;
    }

    /**
     * 一度の運転で使用する燃料
     * @return 使用する燃料
     */
    protected abstract int getOil();

}
