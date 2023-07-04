package change;

import java.nio.file.Paths;

import io.rebuilding.BinaryFileManager;
import io.rebuilding.MakeDirectoryRule;
import io.rebuilding.NestSearch;
import io.rebuilding.RebuildFileManager;

/**
 * ファイルを読み込みディレクトリ構成を変更し出力する問題
 *
 */
public class Problem16 {

    /**
     * 引数で受け取ったファイルを再編成し、別の場所に出力する
     * @param args
     */
    public static void main(String[] args) {
        // ファイルの再編成を実施する。
        RebuildFileManager manager = new BinaryFileManager(new NestSearch(), new MakeDirectoryRule("報告書"));
        manager.rebuild(Paths.get("./data/in"));

        /*
         * ※問題を解く前に実施する
         * ・以下のディレクトリをローカルに落とす
         * 今のクラウドのOJTレポートの格納場所
         * /02.第2システム部/40期_Common/2課/10_人事関連/01_OJTレポート/市川千穂
         * 報告書 市川千穂 2018年6月11日.doc
         * 報告書 市川千穂 2018年6月12日.doc
         * ・・・
         */

        /*
         * ここから問題
         * 問題①
         * 各種ファイルの内容を変更せず、
         * 現在のディレクトリを以下の構成に変更する。
         * 【変更前】
         * /02.第2システム部/40期_Common/2課/10_人事関連/01_OJTレポート/市川千穂
         * 報告書 市川千穂 2018年6月11日.doc
         * 報告書 市川千穂 2018年6月12日.doc
         * ・・・
         * 【変更後】
         * /02.第2システム部/40期_Common/2課/10_人事関連/01_OJTレポート/市川千穂/201806
         * 報告書 市川千穂 2018年6月11日.doc
         * 報告書 市川千穂 2018年6月12日.doc
         * ・・・
         */

        /*
         * 問題①で変更したディレクトリをクラウドにあげる
         */

    }

}
