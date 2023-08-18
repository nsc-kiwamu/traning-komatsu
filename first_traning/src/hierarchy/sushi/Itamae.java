package hierarchy.sushi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 板前クラス
 *
 */
public class Itamae {

    // 注文票
    private ArrayList<Tray> orderSheet = new ArrayList<>();

    // 皿とネタの紐付
    private Map<String, Class<?>> relationTraySushi = new HashMap<>();

    // ネタとの皿に乗せる個数の紐付
    private Map<String, Integer> relationSushiCount = new HashMap<>();

    /**
     * コンストラクタ
     */
    public Itamae() {
        // 注文票を作成する
        makeOrderForm();
    }

    /**
     * 注文票を作成する。
     */
    private void makeOrderForm() {
        // 寿司の全要素を取得する
        Sushi[] sushiArray = Sushi.values();

        // 皿との紐付を作成する
        makeRelationTraySushi(sushiArray);
        makeRelationSushiCount(sushiArray);

    }

    /**
     * 皿とネタの紐付を作成する
     * @param suhiArray 寿司のネタ一覧
     */
    private void makeRelationTraySushi(Sushi[] sushiArray) {

        // 処理しやすいようにリスト化する
        List<Sushi> sushiList = Arrays.asList(sushiArray);

        // 金皿と赤皿を定義し、それ以外は青皿とする
        for (Sushi sushi : sushiList) {
            Class<?> targetTray = null;
            if ("大トロ".equals(sushi.getName()) || "うに".equals(sushi.getName())) {
                targetTray = GoldTray.class;
            } else if ("中トロ".equals(sushi.getName())) {
                targetTray = RedTray.class;
            } else if ("サーモン".equals(sushi.getName())) {
                targetTray = YellowTray.class;
            } else if ("甘エビ".equals(sushi.getName())) {
                targetTray = GreenTray.class;
            } else {
                targetTray = BlueTray.class;
            }
            relationTraySushi.put(sushi.getName(), targetTray);
        }
    }

    /**
     * 皿とネタの個数の紐付を作成する
     * @param sushiArray 寿司のネタ一覧
     */
    private void makeRelationSushiCount(Sushi[] sushiArray) {
        // 処理しやすいようにリスト化する
        List<Sushi> sushiList = Arrays.asList(sushiArray);

        for (Sushi sushi : sushiList) {
            int count = 2;
            if ("大トロ".equals(sushi.getName())) {
                count = 1;
            }
            relationSushiCount.put(sushi.getName(), count);
        }
    }

    /**
     * 寿司を注文する
     * @param name 寿司ネタ名
     */
    public void order(String name) {

        // 注文内容より、ネタを作成する
        Sushi orderSushi = Sushi.getSushi(name);

        // 無効な商品は処理しない
        if (orderSushi == null) {
            return;
        }

        // 乗せる皿を取得する
        Tray tray = null;
        try {
            tray = (Tray) relationTraySushi.get(orderSushi.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        // 乗せる個数を取得する
        int count = relationSushiCount.get(orderSushi.getName());

        tray.setSushi(orderSushi, count);

        orderSheet.add(tray);
    }

    /**
     * 支払い金額と食べた個数を表示する
     */
    public void payment() {
        // 合計金額
        int totalPrice = 0;
        int price = 0;
        int eatNum = 0;

        Map<String, List<Tray>> orderMap = new HashMap<>();

        // 寿司ネタ毎にまとめる
        orderMap = orderSheet.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getSushi().getName()));

        //最大の文字数の取得
        int maxNameLength = orderMap.keySet().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        // 清算処理
        for (String key : orderMap.keySet()) {
            price = 0;
            int trayCount = 0;
            int number = 0;

            /*int maxNameLength = orderMap.keySet().stream()
                    .mapToInt(String::length)
                    .max()
                    .orElse(0);*/

            for (Tray tray : orderMap.get(key)) {
                price += tray.getPrice();
                totalPrice += tray.getPrice();
                eatNum += tray.getCount();

                trayCount = orderMap.get(key).size();
                number += tray.getCount();
            }

            //System.out.println(key + "\t" + "\t" + price + "円\t" + trayCount + "皿\t" + number + "貫");

            if ("サーモン".equals(key)) {
                System.out.printf("%-" + (maxNameLength) + "s", key);
                System.out.printf("%7d円", price);
                System.out.printf("%4d皿", trayCount);
                System.out.printf("%2d貫%n", number);
            } else {
                //System.out.println("\t" + "\t" + price + "円\t" + trayCount + "皿\t" + number + "貫");
                System.out.println(key + "\t" + "\t" + price + "円\t" + trayCount + "皿\t" + number + "貫");
            }

            /*System.out.printf("%-" + (maxNameLength) + "s", key);
            System.out.println(price + "円\t" + trayCount + "皿\t" + number + "貫");*/
        }

        System.out.println("合計金額：" + totalPrice + "円（食べた数：" + eatNum + "貫）");

    }
}
