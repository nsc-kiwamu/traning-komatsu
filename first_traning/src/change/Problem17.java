package change;

import unit_test.Money;

/**
 * ホワイトボックステストを確認する問題
 *
 */
public class Problem17 {

    public static void main(String[] args) {
        Money money = new Money(1);
        money.add(money);

        if (money.equals(money)) {
            System.out.println("同値です。");
        }

        Money moneyTest = new Money(1);
        if (!money.equals(moneyTest)) {
            System.out.println("同値ではありません。");
        }

        if (!money.equals("2")) {
            System.out.println("同値ではありません。");
        }


        /*
         * ここから問題
         * 問題①
         * 「\doc\課題17_【新人向け課題】単体テスト.xlsx」の
         * 「ホワイトボックステスト」シートを確認し、
         * ホワイトボックステストついて理解せよ
         * （理解できれば問題完了とします。）
         */

        /*
         * ここから問題
         * 問題②
         * 「\doc\課題17_【新人向け課題】単体テスト.xlsx」の
         * 「Junitについて」シートを参考にしつつ、
         * Money.javaに対するテストケースのクラスを作成せよ。
         */

        /*
         * ここから問題
         * 問題③
         * 「\doc\課題17_【新人向け課題】単体テスト.xlsx」の
         * 「問題③テスト項目」シートのテスト項目、及び作成例をもとに、
         * Money.javaに対するテストケースのクラスを実装し、
         * JUnitでバグがないこと（実行が9/9、エラー、及び失敗が0）を確認せよ
         */

    }

}
