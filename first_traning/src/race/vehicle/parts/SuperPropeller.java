package race.vehicle.parts;

/**
 * 凄いプロペラ
 *
 */
public class SuperPropeller implements Propeller {

    @Override
    public int getForce(int power) {
        return (int) (power * 2.0);
    }

}
