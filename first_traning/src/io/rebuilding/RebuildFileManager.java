package io.rebuilding;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * ファイルを再編成するための抽象クラス
 *
 */
public abstract class RebuildFileManager {

    private PathSearch search;

    private RebuildRule rule;

    private RebuildFileManager() {
    }

    /**
     * コンストラクタ
     * @param search パス探索用インターフェース
     * @param rule 再編成ルール用インターフェース
     */
    public RebuildFileManager(PathSearch search, RebuildRule rule) {
        this.search = search;
        this.rule = rule;
    }

    /**
     * 引数で指定されたパス配下のファイルを再編成する。
     * @param path 編成対象パス
     */
    public void rebuild(Path path) {

        // 探索したパス一覧を取得する
        List<Path> getPathList = search.search(path);

        // パス一覧より対象のリストを取得する
        List<Path> targetPathList =
                getPathList.stream()
                .filter(p -> rule.isTarget(p)) // 編成対象のもののみを抽出
                .collect(Collectors.toList()); // リストにして返却

        // 変換ルールを作成する
        Map<Path, List<Path>> rebuildMap = rule.rebuildPaths(targetPathList, getRebuildRule());

        // ファイルを再編成する
        makeRebuildFiles(rebuildMap);

    }

    /**
     * 引数で取得したパス文字列の先頭の「in」を「out」に変更して返却する<br>
     * Functionを作成する。
     * @return ルール変換用のFunction
     */
    abstract Function<Path, Path> getRebuildRule();

    /**
     * 引数で受け取ったファイルの文字コードを判断する
     * @param path 判定対象ファイルパス
     * @return 判定対象結果
     */
    protected Charset judgeCharset(Path path) {

        Charset charset = null;

        /*
         * かなり頑張れば可能だが、今回はファイル名で
         * 文字コード判断とする
         */

        // 文字コード判定
        if (path.toString().indexOf("utf8") != -1) {
            charset = StandardCharsets.UTF_8;
        } else if (path.toString().indexOf("euc") != -1) {
            charset = Charset.forName("EUC-JP");
        } else if (path.toString().indexOf("sjis") != -1) {
            charset = Charset.forName("SJIS");
        }

        return charset;
    }

    /**
     * 変換ルールより、ファイルを再編成して出力する
     * @param rebuildMap 再編成ルール
     */
    protected void makeRebuildFiles(Map<Path, List<Path>> rebuildMap) {
        // 書き込み先のディレクトリを先に作成しておく
        rebuildMap.keySet().stream().forEach(p -> {
            // 書き込み対象の親ディレクトリが存在しない場合作成
            if (!Files.exists(p.getParent())) {
                try {
                    Files.createDirectories(p.getParent());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // ファイル作成
        for (Path path : rebuildMap.keySet()) {
            // 書き込み先ファイル
            Path destPath = path;

            // 読み込みファイル
            List<Path> srcPaths = rebuildMap.get(path);

            // 読み込んだファイルを書き込み先に出力していく
            for (Path srcPath : srcPaths) {
                Charset charset = judgeCharset(srcPath);

                // ファイルの読み込み
                try {
                    List<String> readFiles = Files.readAllLines(srcPath, charset);

                    // 書き込み先が存在する場合
                    if (Files.exists(destPath)) {
                        Files.write(destPath, readFiles, charset, StandardOpenOption.APPEND);
                    } else {
                        // ファイルが存在しない場合
                        Files.write(destPath, readFiles, charset, StandardOpenOption.CREATE);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
