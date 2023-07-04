package change;

import hierarchy.life.Earth;
import hierarchy.life.Mouse;
import hierarchy.life.Tiger;

/**
 * 継承の問題
 *
 */
public class Problem08 {

    /**
     * 地球上に存在する生物の活動を確認する。
     * @param args
     */
    public static void main(String[] args) {
        Tiger tiger = new Tiger(15);
        Mouse mouse = new Mouse(2);

        Earth earth = Earth.getInstance();
        earth.birthCreature(tiger);
        earth.birthCreature(mouse);
        earth.timeElapsed();

        // 10年経過させる
        for (int i = 1; i <= 10; i++) {
            System.out.println("～～～～～" + i + "年目" + "～～～～～");
            System.out.println("====== 現在の生態系 ======");
            earth.displayCreatures();
            System.out.println("------ 活動内容 ------");
            earth.timeElapsed();
            System.out.println("");
        }

        /* -- ここから問題 -- */
        // Animalクラスを継承した新たな生物を作り、地球上に存在させよ
        // 植物を表す抽象クラス(Plant)を作り、それを継承した新たな生物を作り、地球上に存在させよ
        // 寿命が減らない生物を作成したいが可能か？可能であれば生物を作り、不可能であれば理由を説明せよ

    }

}
