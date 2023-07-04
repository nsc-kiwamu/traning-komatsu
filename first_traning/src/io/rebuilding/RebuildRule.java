package io.rebuilding;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * パスを再編成するルールを決めるためのインターフェース
 *
 */
public interface RebuildRule {

    /**
     * 編成対象となる場合、trueを返却する。
     * @param path 検討対象パス
     * @return 編成対象結果
     */
    boolean isTarget(Path path);

    /**
     * 引数で受け取ったパスの再編成結果を返却する。<br>
     * 戻り値の結果は以下となる。<br>
     * key:出力先パス<br>
     * value:出力元パス<br>
     * @param paths 再編成対象のパス
     * @param func 再編成ルール
     * @return 再編成結果
     */
    Map<Path, List<Path>> rebuildPaths(List<Path> paths, Function<Path, Path> func);

}
