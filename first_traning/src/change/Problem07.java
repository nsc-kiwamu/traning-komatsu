package change;

import hierarchy.sushi.Itamae;

// 回転寿司を注文する問題
public class Problem07{

    /**
     * 回転寿司を注文する
     * @param args
     */
    public static void main(String[] args){

        Itamae itamae = new Itamae();
        itamae.order("たまご");
        itamae.order("まぐろ");
        itamae.order("まぐろ");
        itamae.order("中トロ");
        itamae.order("うに");
        itamae.order("大トロ");
        itamae.order("まぐろ");

        System.out.println("注文票-------------");
        itamae.payment();
        System.out.println("-------------------");


        /* -- ここから問題 -- */

        // Trayクラスを継承した新たな黄皿、及び緑皿を作れ
        // なお、黄皿は1皿210円、緑皿は1皿420円とする。

        // 黄皿である「サーモン」を3皿、緑皿である「甘エビ」を1皿を追加注文せよ

    }
}
