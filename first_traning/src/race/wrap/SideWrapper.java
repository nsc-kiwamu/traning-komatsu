package race.wrap;

/**
 * 文字列の横を包むクラス
 *
 */
public class SideWrapper implements StringWrapper {

    @Override
    public String wrap(String target, char wrapper) {

        // 改行コードで分割
        String[] targetLine = target.split(System.lineSeparator());

        StringBuilder retBuilder = new StringBuilder();

        // 各行にラッピング文字を設定
        for (int i = 0; i < targetLine.length; i++) {
            retBuilder.append(wrapper);
            retBuilder.append(targetLine[i]);
            retBuilder.append(wrapper);

            // 改行コードで分割して要素数が2つ以上の時で最後の要素以外の時に改行を戻し入れる
            if (2 <= targetLine.length && i < targetLine.length -1) {
                retBuilder.append(System.lineSeparator());
            }

        }
        return retBuilder.toString();
    }


}
