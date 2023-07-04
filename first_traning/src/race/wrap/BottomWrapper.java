package race.wrap;


public class BottomWrapper implements StringWrapper {

    @Override
    public String wrap(String target, char wrapper) {

        // 改行コードで分割
        String[] targetLine = target.split(System.lineSeparator());

        StringBuilder retBuilder = new StringBuilder();

        int maxSize = 0;

        // 各行にラッピング文字を設定
        for (int i = 0; i < targetLine.length; i++) {
            retBuilder.append(targetLine[i]);

            // 改行コードで分割して要素数が2つ以上の時で最後の要素以外の時に改行を戻し入れる
            if (2 <= targetLine.length && i < targetLine.length -1) {
                retBuilder.append(System.lineSeparator());
            }

            // 各行の最も長い文字数をベースにラッピング数を決める
            int curSize = getWrappingCount(targetLine[i]);
            if (maxSize < curSize) {
                maxSize = curSize;
            }
        }

        retBuilder.append(System.lineSeparator());
        // 一番最後にラッピング文字列を挿入する
        for (int i = 0; i < maxSize; i++) {
            retBuilder.append(wrapper);
        }

        return retBuilder.toString();
    }

}
