package race.vehicle.parts;

/**
 * 普通のタイヤ
 *
 */
public class NormalTire implements Tire {

    @Override
    public int getForce(int power) {
        return (int) (power * 1.5);
    }

}
