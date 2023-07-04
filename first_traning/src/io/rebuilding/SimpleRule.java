package io.rebuilding;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 単純な再編成を実施するためのクラス
 *
 */
public class SimpleRule implements RebuildRule {

    String targetName = null;

    private SimpleRule() {
    };

    /**
     * コンストラクタ
     * @param targetName 再編成対象ファイルが含む文字列
     */
    public SimpleRule(String targetName) {
        this.targetName = targetName;
    }

    /**
     * コンストラクタで取得した文字列を含むファイルを対象とする。
     * @param 判定対象のパス
     */
    @Override
    public boolean isTarget(Path path) {

        boolean target = false;

        // ファイル名が編成対象かどうかを返却する。
        if (path.toFile().getName().indexOf(targetName) != -1) {
            target = true;
        }

        return target;
    }

    @Override
    public Map<Path, List<Path>> rebuildPaths(List<Path> paths, Function<Path, Path> func) {

        Map<Path, List<Path>> retMap = new HashMap<>();

        // 引数のリスト分処理をする
        for (Path path : paths) {
            // 編集ルールで決められた通りに出力元、先を決める
            Path destPath = func.apply(path);

            // Mapからリストを取得する、取得できない場合はnewしたリストを取得
            List<Path> srcList = retMap.getOrDefault(destPath, new ArrayList<Path>());
            srcList.add(path);
            retMap.put(destPath, srcList);
        }

        return retMap;
    }

}
