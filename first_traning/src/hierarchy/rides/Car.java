package hierarchy.rides;

/**
 * 車を表すインターフェース
 *
 */

public interface Car {

    /**
     * 乗り物で走る
     */
    public abstract void run(String carModel);

    /**
     * 車で走る
     */
    public abstract int carRun();

}
