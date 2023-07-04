package race.vehicle.parts;

/**
 * プロペアを表現するインターフェース
 *
 */
public interface Propeller {

    /**
     * 推進力を得るためのメソッド
     * @param power 出力
     * @return 推進力
     */
    int getForce(int power);
}
