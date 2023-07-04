package race.vehicle.parts;

/**
 * タイヤを表現するインターフェース
 *
 */
public interface Tire {

    /**
     * 推進力を得るためのメソッド
     * @param power 出力
     * @return 推進力
     */
    int getForce(int power);
}
