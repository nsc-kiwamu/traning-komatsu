package io.rebuilding;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * サンプル用のマネージャー
 *
 */
public class SampleManager extends RebuildFileManager {

    public SampleManager(PathSearch search, RebuildRule rule) {
        super(search, rule);
    }

    @Override
    Function<Path, Path> getRebuildRule() {
        return p -> {
            String path = p.toString();
            // javaの表記上のエスケープと正規表現のエスケープのため「\」は倍必要
            String replacePath = path.replaceAll("data\\\\in", "data\\\\out");
            return Paths.get(replacePath);
        };
    }

}
