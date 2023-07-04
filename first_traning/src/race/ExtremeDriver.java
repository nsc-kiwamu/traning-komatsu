package race;

import java.util.Random;

public class ExtremeDriver implements Driver {

    @Override
    public DriveType drive() {
        // 行動を決めるため乱数を取得する
        int action = new Random().nextInt(10);

        if (action < 6) {
            return DriveType.moveOn;
        } else {
            return DriveType.stop;
        }
    }

    @Override
    public double getDrivingSkills() {
        return 1.2;
    }
}
