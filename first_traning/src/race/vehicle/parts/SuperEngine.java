package race.vehicle.parts;

/**
 * 凄いエンジン
 *
 */
public class SuperEngine implements Engine {

    @Override
    public int getPower(int oil) {
        return oil * 5;
    }

}
