package hierarchy.life;

/**
 * 植物を表すクラス
 *
 */

public abstract class Plant extends Creature {

    public Plant(int lifespan) {
        super(lifespan);
    }

    abstract void grow();

}
