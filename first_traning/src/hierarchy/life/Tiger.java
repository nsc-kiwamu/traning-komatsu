package hierarchy.life;

/**
 * 虎を表すクラス
 *
 */
public class Tiger extends Animal {

    public Tiger(int lifespan) {
        super(lifespan);
    }

    @Override
    void eat() {
        System.out.println(this.getClass().getSimpleName() + "が肉を食べた");
    }

    @Override
    void toAct() {
        // 乱数で動作を決める(1:子孫が生まれる、2:食べる、それ以外:何もしない)
        int number = getRandomNumber();

        if (1 == number) {
            Earth.getInstance().birthCreature(new Tiger(10));
            System.out.println(this.getClass().getSimpleName() + "は子孫を残す");
        } else if (2 == number) {
            eat();
        } else {
            System.out.println(this.getClass().getSimpleName() + "は何もしない");
        }
    }

}
