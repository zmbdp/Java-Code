package demo.card;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Test {
    private static final String[] SUIT = {"♥", "♣", "♦", "♠"};

    public static List<Card> buyCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < SUIT.length; i++) {
            for (int j = 1; j < 14; j++) {
                Card card = new Card(SUIT[i],j);
                cards.add(card);
            }
        }
        return cards;
    }


    public static void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int q1 = random.nextInt(52);
            Card tmp = new Card(cards.get(q1).getSuit(), cards.get(q1).getRank());
            int q2 = random.nextInt(52);
            cards.set(q1, cards.get(q2));
            cards.set(q2,tmp);
        }
    }


    public static void main(String[] args) {
        List<Card> cards = buyCard();
        System.out.println(cards);
        shuffle(cards);
        System.out.println(cards);

        //没人轮流揭牌五张
        //先创造出三个人类
        //自己写的->
        List<Card> PasserbyA = new ArrayList<>();
        List<Card> PasserbyB = new ArrayList<>();
        List<Card> PasserbyC = new ArrayList<>();

        //for循环揭牌a
        for (int i = 0; i < 5; i++) {
            //拿到一个就尾插
            PasserbyA.add(cards.remove(0));
            PasserbyB.add(cards.remove(0));
            PasserbyC.add(cards.remove(0));
        }



        //上课提点之后写的
        /*List<List<Card>> lists = new LinkedList<>();
        lists.add(0, PasserbyA);
        lists.add(1, PasserbyB);
        lists.add(2, PasserbyC);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                //获取每次第一张牌的元素，删掉，给一个人
                Card card = cards.remove(0);
              //先找到哪个人 . 在找到那个人的这个下标，给它赋值
                lists.get(j).add(card);//每次都给0这个下标给这个人，因为每次的0的下标都不一样
            }
        }*/

        System.out.println();
        System.out.print("路人甲-> ");
        for (int i = 0; i < 5; i++) {
            System.out.print(PasserbyA.get(i) + " ");
        }
        System.out.println();
        System.out.print("路人乙-> ");
        for (int i = 0; i < 5; i++) {
            System.out.print(PasserbyB.get(i) + " ");
        }
        System.out.println();
        System.out.print("路人丙-> ");
        for (int i = 0; i < 5; i++) {
            System.out.print(PasserbyC.get(i) + " ");
        }
    }

}
