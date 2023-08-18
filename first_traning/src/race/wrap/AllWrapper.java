package race.wrap;

/**
* 文字列を上下左右に包むクラス
*/
public class AllWrapper implements StringWrapper {

    @Override
    public String wrap(String target, char wrapper) {
        StringWrapper top = new TopWrapper();
        StringWrapper bottom = new BottomWrapper();
        StringWrapper side = new SideWrapper();

        // 上部にラッピング
        String wrappedTop = top.wrap(target, wrapper);

        // 下部にラッピング
        String wrappedTopAndBottom = bottom.wrap(wrappedTop, wrapper);

        // 左右にラッピング
        String wrappedAll = side.wrap(wrappedTopAndBottom, wrapper);

        return wrappedAll;
    }
}
