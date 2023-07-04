package race.vehicle.parts;

/**
 * エンジンを表現するインターフェース
 *
 */
public interface Engine {

    /**
     * 出力を得るためのメソッド
     * @param 燃料
     * @return 出力
     */
    int getPower(int oil);
}
