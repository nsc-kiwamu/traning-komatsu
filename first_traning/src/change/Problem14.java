package change;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 入出力の問題
 *
 */
public class Problem14 {

    private static int previousResult = 0;

    /**
     * csvファイルを読み込み、加算結果を出力する
     * @param args
     */
    public static void main(String[] args) {
        execBufferedReader();
        execStream();
        execList();

        /*
         * ここから問題
         */

        /*
         * 課題１
         * 【実装イメージ】で3通り提示しましたが、すべて実行して試してみてください。
         * 問題なく動くんだな、ということが理解できれば完了として構いません。
         * 可能ならデバッグでステップ実行してもらうとより理解が深まると思います。
         */

        /*
         * 課題２
         * 【実装イメージ】からメモリ展開しないどちらかを選択して、
         * 現在はSystem.outに出力している計算結果をファイルに出力するようにしてください。
         * 今回は出力方法は問いません。（目的とすることが実現できることが大事です）
         */

        /*
         * 課題３
         * 現在は【ポイント】①の
         * 1,2
         * 3,1
         * …
         * を対象とした加算のみになっていますが、
         * これを改造して②の
         * 1,2,+
         * 3,1,-
         * …
         * が処理出来るようにしてみてください。
         * 演算は
         * 「+」：加算
         * 「-」：減算
         * 「*」：乗算
         * 「/」：除算
         * の4通りで考えてください。
         * 2項演算で構いませんが、お願いされていることすべて終わってしまってものすごく暇です・・・
         * となるようであれば逆ポーランド記法による複数回演算に改造してみてください。
         */

        /*
         * 課題４
         * 出力内容をその行の演算だけではなく、
         * １つ前の行で行った演算の結果を加算して出力するようにしてみてください。
         * ※１：１つ前の行でも、その前の行との加算は行っています。
         * ※２：修正ポイントはsumメソッドでなくても構いません。（IIRフィルタが参考になるかもしれません）
         */
    }

    /**
     * csvファイルを読み込み、加算結果を出力する。<br>
     * 入力ストリームを使用して1行づつ読み込んで処理するパターン
     *
     */
    protected static void execBufferedReader() {

        previousResult = 0;

        // 好きな方を使って下さい
        //      try (BufferedReader reader = new BufferedReader(new FileReader("./data/in/Problem14_01.csv"))) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("./data/in/Problem14_01.csv"));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("./data/out/Problem14_FileOutput.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(sum(line));
                int result = calculation(line);
                writer.write("行の計算結果：" + result);
                writer.newLine();
                writer.write("加算したもの：" + (result + previousResult));
                writer.newLine();
                previousResult = result;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected static int calculation(String line) {

        String[] comma = line.split(",");
        int a = Integer.parseInt(comma[0]);
        int b = Integer.parseInt(comma[1]);
        String operator = comma[2];

        switch (operator) {

        case "+":
            return a + b;

        case "-":
            return a - b;

        case "*":
            return a * b;

        case "/":
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException("Division by 0");
            }

        default:
            throw new IllegalArgumentException("Invaild operator:" + operator);

        }
    }

    /**
     * csvファイルを読み込み、加算結果を出力する。<br>
     * ストリームAPIを使用して1行づつ処理するパターン
     *
     */
    protected static void execStream() {

        previousResult = 0;

        try (Stream<String> stream = Files.lines(Paths.get("./data/in/Problem14_01.csv"))) {
            stream.forEach(line -> {
                int result = calculation(line);
                System.out.println("行の計算結果：" + result);
                System.out.println("加算したもの：" + (result + previousResult));
                previousResult = result;
            });
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * csvファイルを読み込み、加算結果を出力する。<br>
     * 全行分のデータをリストで取得して処理するパターン
     *
     */
    protected static void execList() {

        previousResult = 0;

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("./data/in/Problem14_01.csv"));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        for (String line : lines) {
            int result = calculation(line);
            System.out.println("行の計算結果：" + result);
            System.out.println("加算したもの：" + (result + previousResult));
            previousResult = result;
        }
    }

    /**
     * 入力値をカンマで区切り加算した結果を返却する。
     * @param line 対象文字列
     * @return 加算結果
     */
    protected static int sum(String line) {
        int sum = 0;
        for (String val : line.split(",")) {
            sum += Integer.parseInt(val);
        }
        return sum;
    }
}
