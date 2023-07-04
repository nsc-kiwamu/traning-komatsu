package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Propeller;

/**
 * 普通のボート
 *
 */
public class NormalBoat extends Boat {

    public NormalBoat(Engine engine, Propeller propeller, String boatName) {
        super(engine, propeller, boatName);
    }

    @Override
    protected int getOil() {
        return 3;
    }

}
