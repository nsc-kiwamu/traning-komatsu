package race.vehicle.parts;

public class PowerPropeller implements Propeller {

    @Override
    public int getForce(int power) {
        return (int) (power * 1.3);
    }

}
