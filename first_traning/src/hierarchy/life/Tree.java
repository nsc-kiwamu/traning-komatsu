package hierarchy.life;

/**
 * 木を表すクラス
 *
 */

 public class Tree extends Plant {

     public Tree(int lifespan) {
         super(lifespan);
     }

     @Override
     void grow() {
         System.out.println(this.getClass().getSimpleName() + "が成長した");
     }

     @Override
     void toAct() {
      // 乱数で動作を決める(1:種子を落とす、2:成長する、それ以外:何もしない)
         int number = getRandomNumber();

         if (1 == number) {
             Earth.getInstance().birthCreature(new Tree(1000));
             System.out.println(this.getClass().getSimpleName() + "は種子を落とす");
         } else if (2 == number) {
             grow();
         } else {
             System.out.println(this.getClass().getSimpleName() + "は何もしない");
         }


     }

}
