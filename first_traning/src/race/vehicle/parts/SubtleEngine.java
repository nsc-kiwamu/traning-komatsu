package race.vehicle.parts;

/**
 * 微妙エンジン
 *
 */
public class SubtleEngine implements Engine {

    @Override
    public int getPower(int oil) {
        return oil * 2;
    }

}
