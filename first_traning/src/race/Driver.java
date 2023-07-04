package race;

/**
 * 運転手を表現するインターフェース
 *
 */
public interface Driver {

    /**
     * 運転時の行動を返却する
     * @return 行動
     */
    public DriveType drive();

    /**
     * 運転技術を返却する
     * @return 運転技術
     */
    public double getDrivingSkills();
}
