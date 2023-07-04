package hierarchy.life;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 地球を表すクラス
 *
 */
public class Earth {

    /** 自身のインスタンス */
    private static Earth earth = new Earth();

    /** 地球上の生物を表現するためのリスト */
    private List<Creature> creatures = new ArrayList<>();

    /** 新たに生まれた生物のリスト */
    private List<Creature> newCreatures = new ArrayList<>();

    /**
     * コンストラクタ<br>
     * 新たなインスタンスは生成不可とする。
     */
    private Earth() {
        System.out.println("インスタンス生成");
    }

    /**
     * インスタンスを返却する。<br>
     * 本インスタンスはシングルトンのため<br>
     * 何度実行しても同じインスタンスを返却する。
     * @return 地球インスタンス
     */
    public static Earth getInstance() {
        return earth;
    }

    /**
     * 現在の地球上の生物の一覧を表示する
     */
    public void displayCreatures() {
        Map<String, List<Creature>> displayMap = new HashMap<>();

        // 生物の種類毎にMapに格納する
        displayMap = creatures.stream().collect(Collectors.groupingBy(k -> k.getClass().getSimpleName()));

        for (Entry<String, List<Creature>> e : displayMap.entrySet()) {
            System.out.println(e.getKey() + "が" + e.getValue().size());
        }

    }

    /**
     * 時間経過を表現するクラス<br>
     * 地球上全生物に対し、時間経過を伝える
     */
    public void timeElapsed() {
        for (int i = 0; i < creatures.size(); i++) {
            Creature c = creatures.get(i);

            creatures.get(i).timeElapsed();

            // 死んでいたら除外する
            if (c.isDead()) {
                creatures.remove(i);

                // 削除時に要素がつまるので、インデックスを戻す
                i--;
            }
        }

        // 新たに生まれた生物を追加する
        creatures.addAll(newCreatures);
        newCreatures = new ArrayList<>();
    }

    /**
     * 生物が生まれた時ことを表現するクラス
     * @param creature 生まれた生物
     */
    public void birthCreature(Creature creature) {
        newCreatures.add(creature);
    }

}
