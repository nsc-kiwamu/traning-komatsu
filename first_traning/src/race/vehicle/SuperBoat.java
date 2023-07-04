package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Propeller;

/**
 * 凄いボート
 *
 */
public class SuperBoat extends Boat {

    public SuperBoat(Engine engine, Propeller propeller, String boatName) {
        super(engine, propeller, boatName);
    }

    @Override
    protected int getOil() {
        return 15;
    }

    protected double getResistivity() {
        return 0.5;
    }

}
