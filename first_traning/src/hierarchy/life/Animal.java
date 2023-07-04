package hierarchy.life;

/**
 * 動物を表すクラス
 *
 */
public abstract class Animal extends Creature {

    public Animal(int lifespan) {
        super(lifespan);
    }

    abstract void eat();

}
