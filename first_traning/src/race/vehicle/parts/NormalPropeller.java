package race.vehicle.parts;

/**
 * 普通のプロペラ
 *
 */
public class NormalPropeller implements Propeller {

    @Override
    public int getForce(int power) {
//        return (int) (power * 1.3);
        return (int) (power * 1.0);
    }

}
