package race.vehicle.parts;

/**
 * 普通のエンジン
 *
 */
public class NormalEngine implements Engine {

    @Override
    public int getPower(int oil) {
        return oil * 1;
    }

}
