package util;

/**
 * 国情報を表すための列挙値
 *
 */
public enum Country {
    JPN(0, "日本"),
    USA(1, "アメリカ"),
    CHN(2, "中国"),
    IND(3, "インド"),
    GBR(4, "イギリス"),
    ITR(5, "イタリア"),
    FRA(6, "フランス"),
    AUS(7, "オーストラリア");

    /** 国番号 */
    private int number = 0;

    /** 国名(和名) */
    private String jpName;

    /**
     * コンストラクタ
     * @param number 国番号
     * @param jpName 国名(和名)
     */
    private Country(int number, String jpName) {
        this.number = number;
        this.jpName = jpName;
    }

    /**
     * 国番号を返却する。
     * @return 国番号
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * 国名(和名)を返却する。
     * @return 国名(和名)
     */
    public String getJpName() {
        return this.jpName;
    }

    /**
     * 引数で指定された国番号が一致するものを返却する。
     * @param number 国番号
     * @return 国情報
     */
    public static Country getCountry(int number) {

        for (Country country : Country.values()) {
            if (country.number == number) {
                return country;
            }
        }

        return null;
    }

    /**
     * 引数で指定された国名(和名)が一致するものを返却する。
     * @param number 国番号
     * @return 国情報
     */
    public static Country getCountry(String jpName) {

        for (Country country : Country.values()) {
            if (country.jpName.equals(jpName)) {
                return country;
            }
        }

        return null;
    }

}
