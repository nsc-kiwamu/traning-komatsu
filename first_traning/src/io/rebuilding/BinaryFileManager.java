package io.rebuilding;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * バイナリデータとして読み書きを行うクラス
 *
 */
public class BinaryFileManager extends RebuildFileManager {

    public BinaryFileManager(PathSearch search, RebuildRule rule) {
        super(search, rule);
    }

    @Override
    Function<Path, Path> getRebuildRule() {
        return p -> {
            String path = p.toString();
            // javaの表記上のエスケープと正規表現のエスケープのため「\」は倍必要
            String replacePath = path.replaceFirst("first_traning_15_16\\\\data\\\\in", "first_traning_15_16\\\\data\\\\out");
            return Paths.get(replacePath);
        };
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

                // ファイルの読み込み
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath.toString()));
                     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath.toString()))) {
                    int valueInt = 0;
                    byte[] b = new byte[1000];
                    while ((valueInt = bis.read(b)) != -1) {
                        bos.write(b, 0, valueInt);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
