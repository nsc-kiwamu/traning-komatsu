package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Propeller;

/**
 * 微妙ボート
 *
 */
public class SubtleBoat extends Boat {

    public SubtleBoat(Engine engine, Propeller propeller, String boatName) {
        super(engine, propeller, boatName);
    }

    @Override
    protected int getOil() {
        return 10;
    }

    protected double getResistivity() {
        return 0.8;
    }

}
