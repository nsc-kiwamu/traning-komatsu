package util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 課題用の文字列を使うユーティリティクラス<br>
 *
 */
public class StringUtil {

    /**
     * 対象の文字列がUTF-8かどうか判断する。
     * @param target 対象文字列
     * @return 対象文字列のUTF-8判断結果
     */
    public static boolean isUtf8(String target) {
        return isParamCharSet(target, StandardCharsets.UTF_8);
    }

    /**
     * 対象の文字列がSJISかどうか判断する。
     * @param target 対象文字列
     * @return 対象文字列のSJIS判断結果
     */
    public static boolean isSjis(String target) {
        return isParamCharSet(target, Charset.forName("SJIS"));
    }

    /**
     * 対象の文字列がEUC-JPかどうか判断する。
     * @param target 対象文字列
     * @return 対象文字列のEUC-JP判断結果
     */
    public static boolean isEuc(String target) {
        return isParamCharSet(target, Charset.forName("EUC-JP"));
    }

    /**
     * 対象の文字列が引数で設定した文字コードかを判定する
     * @param target 対象文字列
     * @param charset 文字コード
     * @return 対象文字列の文字コード判断結果
     */
    public static boolean isParamCharSet(String target, Charset charset) {

        // 引数をバイト変換したもの
        byte[] orgData = target.getBytes(charset);
        String utfData = new String(orgData, charset);

        return target.equals(utfData);
    }

    /**
     * 対象の文字列のascii文字数を返却する。
     * @param target 対象文字列
     * @return 対象文字列に含まれるascii文字数
     */
    public static int countAscii(String target) {
        int asciiCount = 0;

        // 引数を1文字づつ分解し、ascii文字か確認する
        for (char c : target.toCharArray()) {
            // 正規表現で判断する
            if (String.valueOf(c).matches("\\p{ASCII}")) {
                asciiCount++;
            }
        }
        return asciiCount;

    }
}
