package race.vehicle.parts;

/**
 * 微妙プロペラ
 *
 */
public class SubtlePropeller implements Propeller {

    @Override
    public int getForce(int power) {
        return (int) (power * 1.1);
    }

}
