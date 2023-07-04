package hierarchy.rides;

/**
 * 電車を表すインターフェース
 *
 */
public interface Train {

    /**
     * 乗り物で走る
     */
    public abstract void run(String trainModel);

    /**
     * 電車で走る
     */
    public abstract int trainRun();

}
