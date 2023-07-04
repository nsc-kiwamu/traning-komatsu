package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Propeller;

public class FastBoat extends Boat {

    public FastBoat(Engine engine, Propeller propeller, String boatName) {
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
