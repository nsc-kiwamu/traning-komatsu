package change;

import java.util.List;

import util.NumericUtil;

/**
 * ランダムで生成した数値で勝負をする問題
 * @param args
 */
public class Problem03 {

    /**
     * ランダムで生成した数値で勝負をする問題
     * @param args
     */
    public static void main(String[] args) {

        /*
         * ユーザAとユーザBで0～15の数値の書いた10枚
         * のカードを取得し、数値の大小で勝負をする。テストだよ。
         */

        // ユーザAとBでカードを取得
        List<Integer> cardListA = NumericUtil.makeRandomList(10, 15);
        List<Integer> cardListB = NumericUtil.makeRandomList(10, 15);
        List<Integer> cardListC = NumericUtil.makeRandomList(100, 15);
        List<Integer> cardListD = NumericUtil.makeRandomList(100, 15);
        List<Integer> cardListE = NumericUtil.makeRandomList(1000, 15);
        List<Integer> cardListF = NumericUtil.makeRandomList(1000, 15);


        // ユーザAとBで勝負する
        gameComplete(cardListA, cardListB);
        game3Win(cardListC, cardListD);
        game3StraightWin(cardListE, cardListF);

        /* -- ここから問題 -- */
        /* 比較するカード数を100枚に増やし、先に3勝した方を勝ちと判断するメソッド(game3Win)
         * を実装せよ。
         * 結果には以下を出力すること
         * ・どちらが勝ったのか
         * ・3勝の内訳(何戦目で勝ったか)
         *
         * */

        /* 比較するカード数を1000枚に増やし、先に3連勝した方を勝ちと判断するメソッド(game3StraightWin)
         * を実装せよ。
         * 結果には以下を出力すること
         * ・どちらが勝ったのか
         * ・3勝の内訳(何戦目で勝ったか)
         *
         * */

    }

    /**
     * 引数で与えられたリストの大小比較をおこなう。
     * @param targetAList ユーザAのリスト
     * @param targetBList ユーザBのリスト
     */
    private static void gameComplete(List<Integer> targetAList, List<Integer> targetBList) {

        System.out.println("--------- お互いのカードを大小比較しました。 ---------");

        System.out.println("ユーザAのリスト");
        targetAList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        System.out.println("ユーザBのリスト");
        targetBList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        // 要素数に差がある場合、少ない方に合わせて比較をする。
        int gameCount = targetAList.size() > targetBList.size() ? targetBList.size() : targetAList.size();

        int winCountA = 0;
        int winCountB = 0;


        for (int i = 0; i < gameCount; i++) {
            // 大小比較
            if (targetAList.get(i) < targetBList.get(i)) {
                winCountB++;

            } else if (targetBList.get(i) < targetAList.get(i)) {
                winCountA++;


            }
        }


        if (winCountA == winCountB) {
            System.out.println("引き分け");
        } else if (winCountA > winCountB) {
            System.out.println("Aの勝ち");
        } else {
            System.out.println("Bの勝ち");
        }

    }

   /* List<Integer> cardListA = NumericUtil.makeRandomList(100, 15);
    List<Integer> cardListB = NumericUtil.makeRandomList(100, 15);*/



    private static void game3Win(List<Integer> targetAList, List<Integer> targetBList) {

    	 System.out.println("--------- お互いのカードを大小比較しました。 ---------");

         System.out.println("ユーザAのリスト");
         targetAList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
         System.out.println("");

         System.out.println("ユーザBのリスト");
         targetBList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
         System.out.println("");

      // 要素数に差がある場合、少ない方に合わせて比較をする。
         int gameCount = targetAList.size() > targetBList.size() ? targetBList.size() : targetAList.size();

         int winCountA = 0;
         int winCountB = 0;
         int[] winRecordA = new int[3];
         int[] winRecordB = new int[3];
         int lastWinA = 0;
         int lastWinB = 0;

         for (int i = 0; i < gameCount; i++) {
             // 大小比較
             if (targetAList.get(i) < targetBList.get(i)) {
                 winCountB++;
                 lastWinB = i + 1;
                 if (winCountB >= 3) {
                 	break;
                 }
             }
             else if (targetBList.get(i) < targetAList.get(i)) {
            	 winCountA++;
            	 lastWinA = i + 1;
            	 if (winCountA >= 3) {
                 	break;
                 }
             }

         }
         System.out.println();

         if (winCountA == winCountB) {
             System.out.println("引き分け");
         } else if (winCountA > winCountB) {
             System.out.println("Aの勝ち");
             for (int i = 0; i < 3; i++) {
            	 if (winRecordA[i] != 0) {
            		 System.out.println((i + 1) + "戦目で勝ち");
            	 }
             }
             if(lastWinA != -1) {
            	 System.out.println("何戦目で勝ったか：" + lastWinA + "戦目");
             }
    }else {
    	System.out.println("Bの勝ち");
        for (int i = 0; i < 3; i++) {
       	 if (winRecordB[i] != 0) {
       		 System.out.println((i + 1) + "戦目で勝ち");
       	   }
        }
        if(lastWinB != -1) {
       	 System.out.println("何戦目で勝ったか：" + lastWinB + "戦目");
        }
     }
  }





    private static void game3StraightWin(List<Integer> targetAList, List<Integer> targetBList) {

    	System.out.println("--------- お互いのカードを大小比較しました。 ---------");

        System.out.println("ユーザAのリスト");
        targetAList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

        System.out.println("ユーザBのリスト");
        targetBList.stream().map(s -> "[" + s + "]").forEach(System.out::print);
        System.out.println("");

     // 要素数に差がある場合、少ない方に合わせて比較をする。
        int gameCount = targetAList.size() > targetBList.size() ? targetBList.size() : targetAList.size();

        int winCountA = 0;
        int winCountB = 0;
        int winStraightA = 0;
        int winStraightB = 0;
        int winRound = 0;

        for (int i = 0; i < gameCount; i++) {
            // 大小比較
            if (targetAList.get(i) < targetBList.get(i)) {
                winCountB++;
                winStraightA = 0;
                winStraightB++;
                if (winStraightB == 3) {
                	winRound = i + 1;
                	break;
                }
            }
            else if (targetBList.get(i) < targetAList.get(i)) {
           	 winCountA++;
           	 winStraightB = 0;
           	 winStraightA++;
           	 if (winStraightA == 3) {
                	winRound = i + 1;
                	break;
                }
            }

        }
        System.out.println();

        if (winCountA == winCountB) {
            System.out.println("引き分け");
        } else if (winCountA > winCountB) {
            System.out.println("Aの勝ち");
        } else {
            System.out.println("Bの勝ち");
            }

      	 if (winRound > 0) {
      		 System.out.println("3連勝が" + winRound + "戦目で達成");
      	   }else {
      		   System.out.println("3連勝はなかった");

      	   }

       }

 }





