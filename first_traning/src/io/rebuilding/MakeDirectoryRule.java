package io.rebuilding;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * ディレクトリ構成の変更を実施するためのクラス
 *
 */
public class MakeDirectoryRule implements RebuildRule {
    String targetName = null;

    private MakeDirectoryRule() {
    };

    /**
     * コンストラクタ
     * @param targetName 再編成対象ファイルが含む文字列
     */
    public MakeDirectoryRule(String targetName) {
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

            // 対象ファイル名からフォルダ名を設定
            String outPutFileName = destPath.getFileName().toString();
            String[] fileNameList = outPutFileName.split(" ");
            String[] strYear = fileNameList[2].split("年");
            String year = strYear[0];
            String[] strMonth = strYear[1].split("月");
            String month = strMonth[0];
            if (month.length() == 1) {
                month = "0" + month;
            }

            // 月毎にフォルダを作成
            String dirPath = Paths.get(destPath.getParent().toString(), year + month).toString();
            File file = new File(dirPath);
            file.mkdir();
            destPath = Paths.get(dirPath, outPutFileName);

            // Mapからリストを取得する、取得できない場合はnewしたリストを取得
            List<Path> srcList = retMap.getOrDefault(destPath, new ArrayList<Path>());
            srcList.add(path);
            retMap.put(destPath, srcList);
        }

        return retMap;
    }


}
