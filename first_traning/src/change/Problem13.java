package change;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import race.wrap.BottomWrapper;
import race.wrap.SideWrapper;
import race.wrap.StringWrapper;

/**
 * 入出力の問題
 *
 */
public class Problem13 {

    /**
     * キー入力された値を読み込み、加工する問題
     * @param args
     */
    public static void main(String args[]) {
        // 一行のラッピング
        oneLineWrap();

        // 複数行のラッピング
        multiLineWrap();

        /* -- ここから問題 -- */
        /*
         * StringWrapperインターフェースを実装した
         * TopWrapperクラスを作成し、入力文字列の
         * 上部をラッピングするクラスを作成する。
         * 作成したクラスをoneLineWrap()/multiLineWrap()
         * に組み込んで動かす
         */

        /*
         * ラッピング対象が複数存在した場合
         * SideWrapperクラスのラッピングは
         * 以下のような動作となる。
         * *aaa*
         * *bbbb*
         * *ccccc*
         * これを「最も長い文字に合わせラッピングする」
         * ように改修し、以下のような結果とせよ
         * *aaa  *
         * *bbbb *
         * *ccccc*
         *
         */

        /*
         * StringWrapperインターフェースを実装した
         * AllWrapperクラスを作成し、入力文字列の
         * 上/左右/下をラッピングするクラスを作成する。
         * 作成したクラスをoneLineWrap()/multiLineWrap()
         * に組み込んで動かす
         */


    }

    /**
     * 1行の入力に対して、文字列をラッピングする
     */
    public static void oneLineWrap() {

        // ユーザに入力を促す
        System.out.println("ラップする文字列を入力して下さい。");

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;

        try {

            inputStr = read.readLine();
            System.out.println(inputStr + "をラップします");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 横と下をラップする
        StringWrapper side = new SideWrapper();
        StringWrapper bottom = new BottomWrapper();
        System.out.println(bottom.wrap(side.wrap(inputStr, '*'), '*'));

    }

    /**
     * 複数行の入力に対して、文字列をラッピングする
     */
    public static void multiLineWrap() {

        // ユーザに入力を促す
        System.out.println("ラップする文字列を入力して下さい。");

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLine = new ArrayList<>();

        try {

            boolean isRead = true;
            do {
                inputLine.add(read.readLine());

                System.out.println("入力を終了しますか？(y)");
                if ("y".equals(read.readLine())) {
                    isRead = false;
                } else {
                    System.out.println("ラップする文字列を追加で入力して下さい。");
                }
            } while (isRead);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // リストをStringに戻す
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < inputLine.size(); i++) {
            build.append(inputLine.get(i));

            // 改行コードで分割して要素数が2つ以上の時で最後の要素以外の時に改行を戻し入れる
            if (2 <= inputLine.size() && i < inputLine.size() -1) {
                build.append(System.lineSeparator());
            }
        }


        // 横と下をラップする
        StringWrapper side = new SideWrapper();
        StringWrapper bottom = new BottomWrapper();
        System.out.println(bottom.wrap(side.wrap(build.toString(), '|'), '-'));

    }

}
