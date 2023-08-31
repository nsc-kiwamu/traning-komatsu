package io.rebuilding;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * マネージャー
 *
 */
public class BinaryManager extends RebuildFileManager {

    public BinaryManager(PathSearch search, RebuildRule rule) {
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

}
