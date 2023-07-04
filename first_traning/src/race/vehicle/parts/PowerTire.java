package race.vehicle.parts;

/**
 * 高水準のタイヤ
 *
 */
public class PowerTire implements Tire {

    @Override
    public int getForce(int power) {
        return (int) (power * 2.5);
    }

}
