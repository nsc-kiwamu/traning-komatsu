package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Tire;

/**
 * 普通の車
 *
 */
public class NormalCar extends Car {

    public NormalCar(Engine engine, Tire tire, String boatName) {
        super(engine, tire, boatName);
    }

    @Override
    protected int getOil() {
        return 5;
    }

}
