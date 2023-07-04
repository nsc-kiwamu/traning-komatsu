package util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 課題用の数値を使うユーティリティクラス<br>
 *
 */
public class DateUtil {

    /** 処理時間のデフォルトフォーマット */
    private static final String DEFAULT_PROC_TIME_FORMAT = "ss.SSS";

    /** 処理開始/終了用のデフォルトフォーマット */
    private static final String DEFAULT_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";

    /**
     * 引数で指定された時刻を引数で指定されたフォーマットに変換する。
     * @param time フォーマット変換対象の時刻
     * @param format 変換するフォーマット
     * @return フォーマット変換された文字列
     */
    public static String getTimeText(long time, String format) {

        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(format);
        LocalDateTime date = LocalDateTime.ofInstant(new Date(time).toInstant(), ZoneId.systemDefault());

        return date.format(dtFormat);
    }

    /**
     * 引数で指定された時刻をデフォルトフォーマットに変換する。
     * @param time フォーマット変換対象の時刻
     * @return フォーマット変換された文字列
     */
    public static String getTimeText(long time) {
        return getTimeText(time, DEFAULT_FORMAT);
    }

    /**
     * 現在時刻をデフォルトフォーマットに変換する。
     * @param time フォーマット変換対象の時刻
     * @return フォーマット変換された文字列
     */
    public static String getTimeText() {
        return getTimeText(System.currentTimeMillis(), DEFAULT_FORMAT);
    }

    public static String getProcTime(long startTime, long endTime) {
        return getTimeText(endTime - startTime, DEFAULT_PROC_TIME_FORMAT);
    }

}
