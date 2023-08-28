package change;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.rebuilding.NestSearch;
import io.rebuilding.RebuildFileManager;
import io.rebuilding.SampleManager;
import io.rebuilding.SimpleRule;

/**
 * 入出力の問題
 *
 */
public class Problem15 {


    /**
     * 引数で受け取ったファイルを再編成し、別の場所に出力する
     * @param args
     */
    public static void main(String[] args) {
        // ファイルの再編成を実施する。
        RebuildFileManager manager = new SampleManager(new NestSearch(), new SimpleRule("Problem15"));
        manager.rebuild(Paths.get("./data/in"));

        newLine();



        /*
         * ここから問題
         * 問題①
         * SingleSearchを使用すると、in\nest配下のファイルが対象とならない
         * NestSearchを使用して、nest配下のファイルも対象とせよ
         */

        /*
         * ここから問題
         * 問題②
         * 各種ファイルの内容を変更せず、ファイルの構成のみを編成しているが
         * ファイルに以下の変更をし、ファイルを編成せよ。
         * ・ファイル内の文章について、「。」の後は改行して出力する
         */

        /*
         * ここから問題
         * 問題③
         * 各種ファイルの内容を変更せず、ファイルの構成のみを編成する際に
         * RebuildFileManagerにてファイルの文字コードを意識して読み込み/書き込みをしている。
         * 読み込み/書き込みデータをテキストデータではなく、バイナリデータとして
         * 扱えば文字コードを意識する必要が無くなるため、文字コードを意識せず
         * バイナリデータで読み書きを実施するよう、RebuildFileManagerを継承した
         * 新たなクラスを作成し、実行せよ
         */

    }

    public static void newLine() {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("./data/in/Problem15_utf8.txt"));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get("./data/out/Problem15_utf8.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {

                line = insertNewLine(line);
                writer.write(line);
                writer.newLine();
            }

        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String insertNewLine(String line) {

        return line.replaceAll("。", "。\n");
    }


}
