package race.wrap;

public class TopWrapper implements StringWrapper {

    @Override
    public String wrap(String target, char wrapper) {

        // 改行コードで分割
        String[] targetLine = target.split(System.lineSeparator());

        StringBuilder retBuilder = new StringBuilder();

        int maxSize = 0;

        // 各行の最も長い文字数をベースにラッピング数を決める
        for (int i = 0; i < targetLine.length; i++) {
            int curSize = getWrappingCount(targetLine[i]);
            if (maxSize < curSize) {
                maxSize = curSize;
            }
        }

        for (int i = 0; i < maxSize; i++) {
            retBuilder.append(wrapper);
        }

        retBuilder.append(System.lineSeparator());

        retBuilder.append(target); // 元の文字列を追加

        return retBuilder.toString();
    }
}
