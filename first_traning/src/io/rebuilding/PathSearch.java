package io.rebuilding;

import java.nio.file.Path;
import java.util.List;

/**
 * パスを探索するためのインターフェース
 *
 */
public interface PathSearch {

    /**
     * 引数で取得したパスより探索結果を出力する。
     * @param path 探索対象のパス
     * @return 探索結果
     */
    List<Path> search(Path path);

}
