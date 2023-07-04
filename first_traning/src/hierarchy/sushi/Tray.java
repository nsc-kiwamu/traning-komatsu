package hierarchy.sushi;

/**
 * お皿を表す抽象クラス
 */
public abstract class Tray implements Cloneable {

     // 皿にのせる寿司ネタ
    Sushi sushi = null;

    // 皿にのせる寿司の数
    int count = 0;

    /**
     * 皿に寿司を乗せる
     * @param sushi 寿司ネタ
     * @param count 個数
     */
    public void setSushi(Sushi sushi, int count) {
        this.sushi = sushi;
        this.count = count;
    }

    /**
     * 寿司を取得する
     * @return 寿司ネタ
     */
    public Sushi getSushi() {
        return sushi;
    }

    abstract int getPrice();

    /**
     * 個数を取得する
     * @return 個数
     */
    public int getCount() {
        return count;
    }
}
