package hierarchy.life;

public class Mouse extends Animal {

    public Mouse(int lifespan) {
        super(lifespan);
    }

    @Override
    void eat() {
        System.out.println(this.getClass().getSimpleName() + "がチーズを食べました");

    }

    @Override
    void toAct() {
        // 乱数で動作を決める(1～3:子孫が生まれる、4:食べる、それ以外:何もしない)
        int number = getRandomNumber();

        if (3 >= number) {
            Earth.getInstance().birthCreature(new Mouse(2));
            Earth.getInstance().birthCreature(new Mouse(2));
            System.out.println(this.getClass().getSimpleName() + "は子孫を残す");
        } else if (4 == number) {
            eat();
        } else {
            System.out.println(this.getClass().getSimpleName() + "は何もしない");
        }
    }

}
