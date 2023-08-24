package race.wrap;

/**
* 文字列の横を包むクラス
*/
public class SideWrapper implements StringWrapper {

    @Override
    public String wrap(String target, char wrapper) {

        // 改行コードで分割
        String[] targetLine = target.split(System.lineSeparator());

        StringBuilder retBuilder = new StringBuilder();

        int maxSize = 0;

        // 最も長い行の文字数を特定
        for (int i = 0; i < targetLine.length; i++) {
            int curSize = getWrappingCount(targetLine[i]);
            if (maxSize < curSize) {
                maxSize = curSize;
            }
        }

        // 各行にラッピング文字を設定
        for (int i = 0; i < targetLine.length; i++) {
            retBuilder.append(wrapper);
            retBuilder.append(targetLine[i]);

            int blank = maxSize - getWrappingCount(targetLine[i]);
            for (int j = 0; j < blank; j++) {
                retBuilder.append(" ");
            }

            retBuilder.append(wrapper);

            // 改行コードで分割して要素数が2つ以上の時で最後の要素以外の時に改行を戻し入れる
            if (2 <= targetLine.length && i < targetLine.length - 1) {
                retBuilder.append(System.lineSeparator());
            }
        }

        return retBuilder.toString();
    }
}
