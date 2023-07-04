package race.vehicle.parts;

/**
 * 高出力エンジン
 *
 */
public class PowerEngine implements Engine {

    @Override
    public int getPower(int oil) {
        return oil * 3;
    }

}
