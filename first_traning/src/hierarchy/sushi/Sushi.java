package hierarchy.sushi;

/**
 * 寿司ネタを表すための列挙値
 *
 */
public enum Sushi {
    TAMAGO(0, "たまご"),
    MAGURO(1, "まぐろ"),
    IKURA(2, "いくら"),
    TYUTORO(3, "中トロ"),
    UNI(4, "うに"),
    OOTORO(5, "大トロ");

    /** 商品番号 */
    private int number = 0;

    /** 商品名 */
    private String name;

    /**
     * コンストラクタ
     * @param number 商品番号
     * @param name 商品名
     */
    private Sushi(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * 商品番号を返却する。
     * @return 商品番号
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * 商品名を返却する。
     * @return 商品名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 引数で指定された商品番号が一致するものを返却する。
     * @param number 商品番号
     * @return 寿司
     */
    public static Sushi getSushi(int number) {

        for (Sushi country : Sushi.values()) {
            if (country.number == number) {
                return country;
            }
        }

        return null;
    }

    /**
     * 引数で指定された商品名が一致するものを返却する。
     * @param number 商品名
     * @return 寿司
     */
    public static Sushi getSushi(String name) {

        for (Sushi country : Sushi.values()) {
            if (country.name.equals(name)) {
                return country;
            }
        }

        return null;
    }

}
