package unit_test;

/**
 * 金額を表すクラス
 */
public class Money {

    /** 金額 */
    int amount;

    /**
     * コンストラクター
     *
     * @param amount 金額
     * @throw IllegalArgumentException
     *             amountが負の場合にスローします。
     */
    public Money(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = amount;
    }

    /**
     * 金額を足し算します。
     *
     * @param m 金額
     * @return 加算金額
     */
    public Money add(Money m) {
        return new Money(amount + m.amount);
    }

    /**
     * 同値を検査します。
     * amountの値が等しい時に限り、同値と判断します。
     *
     * @param obj 比較対象オブジェクト
     * @return 等しければ真
     */
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Money)) {
            return false;
        }

        Money m = (Money) obj;
        return amount == m.amount;
    }
}
