package race;

import java.util.Random;

/**
 * 普通のドライバー
 *
 */
public class NormalDriver implements Driver {

    @Override
    public DriveType drive() {
        // 行動を決めるため乱数を取得する
        int action = new Random().nextInt(10);

        if (action < 4) {
            return DriveType.moveOn;
        } else if (action < 7) {
            return DriveType.stop;
        } else {
            return DriveType.Bend;
        }
    }

    @Override
    public double getDrivingSkills() {
        return 1.0;
    }

}
