package race.wrap;

import util.StringUtil;

/**
 * 文字列をラップするためのインターフェース
 *
 */
public interface StringWrapper {

    /**
     * 文字列をラッピングして返却する
     * @param target ラッピング対象文字列
     * @param wrapString ラッピングする文字列
     * @return ラッピングされた文字列
     */
    String wrap(String target, char wrapper);

    /**
     * ラッピングするのに必要な文字数を返却する。
     * @param target ラッピング対象文字数
     * @return ラッピング文字数
     */
    default int getWrappingCount(String target) {

        int retCount = 0;

        // ascii文字数の取得
        int asciiCount = StringUtil.countAscii(target);

        // ascii文字数以外の数の取得
        int noAsciiCount = target.toCharArray().length - asciiCount;

        // ascii文字はそのままカウントする
        retCount += asciiCount;

        // ascii以外の文字は2倍でカウントする
        retCount += noAsciiCount * 2;

        return retCount;

    }


}
