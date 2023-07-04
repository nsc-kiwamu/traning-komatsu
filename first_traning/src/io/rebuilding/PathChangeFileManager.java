package io.rebuilding;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

public class PathChangeFileManager extends BinaryFileManager {

    public PathChangeFileManager(PathSearch search, RebuildRule rule) {
        super(search, rule);
    }

    @Override
    Function<Path, Path> getRebuildRule() {
        return p -> {
            String path = p.toString();
            // javaの表記上のエスケープと正規表現のエスケープのため「\」は倍必要
            String replacePath = path.replaceFirst("first_traning_15_16\\\\data\\\\in", "first_traning_15_16\\\\data\\\\out\\\\18");
            return Paths.get(replacePath);
        };
    }

}
