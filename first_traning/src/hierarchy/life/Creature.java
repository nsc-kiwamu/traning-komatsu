package hierarchy.life;

import util.NumericUtil;

/**
 * 生物を表現するための抽象クラス
 *
 */
public abstract class Creature {

    /** 寿命 */
    private int lifespan;

    /** 年齢 */
    private int age = 0;

    /**
     * デフォルトコンストラクタは許容しない
     */
    private Creature() {
    };

    /**
     * インスタンス生成時に寿命を決める
     * @param lifespan 寿命
     */
    public Creature(int lifespan) {
        this.lifespan = lifespan;
    }

    /**
     * 時間経過
     */
    public final void timeElapsed() {

        // 時間経過にともない、年齢を上げる
        age ++;

        // 寿命を迎えたら何もさせない
        if (isDead()) {
            System.err.println(this.getClass().getSimpleName() + "が死亡ました。");
            return;
        }

        // 生物固有の活動を実施する
        toAct();
    }

    /**
     * 生死判定
     */
    public final boolean isDead() {
        return age > lifespan;
    };

    /**
     * 活動用の乱数生成
     * @return 乱数
     */
    protected int getRandomNumber() {
        return NumericUtil.makeRandomList(1, 10).get(0);
    }


    /**
     * 活動する
     */
    abstract void toAct();

}
