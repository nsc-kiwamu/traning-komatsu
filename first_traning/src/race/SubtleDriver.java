package race;

import java.util.Random;

/**
 * 微妙ドライバー
 *
 */
public class SubtleDriver implements Driver {

    @Override
    public DriveType drive() {
        // 行動を決めるため乱数を取得する
        int action = new Random().nextInt(10);

        if (action < 3) {
            return DriveType.moveOn;
        } else if (action < 6) {
            return DriveType.stop;
        } else {
            return DriveType.Bend;
        }
    }

    @Override
    public double getDrivingSkills() {
        return 1.1;
    }

}
