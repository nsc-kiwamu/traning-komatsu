package io.rebuilding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 簡易にファイル探索をするためのクラス
 *
 */
public class SingleSearch implements PathSearch {

    @Override
    public List<Path> search(Path path) {

        List<Path> pathList = null;

        // Files#listはクローズが必要なのでtry-with-resourcesを使用
        try (Stream<Path> paths = Files.list(path)) {
            pathList = paths.parallel().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathList;
    }

}
