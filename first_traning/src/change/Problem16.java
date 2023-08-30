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
         * /11.第2システム統括部/007.45期_Common/システム第1部/1課/10_人事関連/01_OJTレポート/小松大二
         * 報告書 小松_2023年07月05日.docx
         * 報告書 小松_2023年07月06日.docx
         * ・・・
         */

        /*
         * ここから問題
         * 問題①
         * 各種ファイルの内容を変更せず、
         * 現在のディレクトリを以下の構成に変更する。
         * 【変更前】
         * /11.第2システム統括部/007.45期_Common/システム第1部/1課/10_人事関連/01_OJTレポート/小松大二
         * 報告書 小松_2023年07月05日.docx
         * 報告書 小松_2023年07月06日.docx
         * ・・・
         * 【変更後】
         * /11.第2システム統括部/007.45期_Common/システム第1部/1課/10_人事関連/01_OJTレポート/小松大二/202307
         * 報告書 小松_2023年07月05日.docx
         * 報告書 小松_2023年07月06日.docx
         * ・・・
         * /11.第2システム統括部/007.45期_Common/システム第1部/1課/10_人事関連/01_OJTレポート/小松大二/202308
         * 報告書 小松_2023年08月01日.docx
         * 報告書 小松_2023年08月02日.docx
         * ・・・
         */

        /*
         * 問題①で変更したディレクトリをクラウドにあげる
         */

    }

}
