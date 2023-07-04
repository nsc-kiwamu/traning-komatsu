package race;

import java.util.Random;

/**
 * 凄いドライバー
 *
 */
public class SuperDriver implements Driver {

    @Override
    public DriveType drive() {
        // 行動を決めるため乱数を取得する
        int action = new Random().nextInt(10);

        if (action < 2) {
            return DriveType.moveOn;
        } else if (action < 5) {
            return DriveType.stop;
        } else {
            return DriveType.Bend;
        }
    }

    @Override
    public double getDrivingSkills() {
        return 1.5;
    }

}
