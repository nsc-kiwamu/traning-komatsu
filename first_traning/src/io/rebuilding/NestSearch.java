package io.rebuilding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 階層構造を意識してファイル探索をするためのクラス
 *
 */
public class NestSearch implements PathSearch {

    @Override
    public List<Path> search(Path path) {

        List<Path> pathList = new ArrayList<>();
        List<Path> dirList = new ArrayList<>();

        // Files#listはクローズが必要なのでtry-with-resourcesを使用
        try (Stream<Path> paths = Files.list(path)) {

            // 全パス情報を格納
            paths.parallel().forEach(p -> {
                // 探索した全パスを格納
                pathList.add(p);

                // ディレクトリのみを格納
                if (Files.isDirectory(p)) {
                    dirList.add(p);
                }

            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 取得したパスがディレクトリのものは再起処理で再度探索し結果を格納する
        for (Path p : dirList) {
            pathList.addAll(search(p));
        }

        return pathList;
    }

}
