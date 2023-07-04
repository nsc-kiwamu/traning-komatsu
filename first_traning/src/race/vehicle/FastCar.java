package race.vehicle;

import race.vehicle.parts.Engine;
import race.vehicle.parts.Tire;

/**
 * 高性能の車
 *
 */
public class FastCar extends Car {

    public FastCar(Engine engine, Tire tire, String boatName) {
        super(engine, tire, boatName);
    }

    @Override
    protected int getOil() {
        return 12;
    }

    protected double getResistivity() {
        return 0.8;
    }

}
