package java学习.斗地主;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/26 9:12
 * javax.smartcardio.Card
 * java学习.斗地主.Card
 */
public class GameDemo {
    /**
     * 定义一个静态集合，存储54张牌对象，集合只需要一个
     */
    public static final List<Card> ALL_CARDS=new ArrayList<>();
    //做牌
    static {
        //定义一个数组存储牌的点数，类型确定，个数确定，就用数组
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors={"♠","♥","♣","♦"};
        //先遍历点数和四种花色，封装为牌对象
        for (String number : numbers) {
            for (String color : colors) {
                Card card=new Card(number,color);
                ALL_CARDS.add(card);
            }
        }
        //单独加入大小王
        Collections.addAll(ALL_CARDS,new Card("","king"),new Card("","smallking"));
    }

    public static void main(String[] args) {
        Collections.shuffle(ALL_CARDS);
        List<Card> LingHuChong=new ArrayList<>();
        List<Card> jiumozhi=new ArrayList<>();
        List<Card> dongfangbubai=new ArrayList<>();
        /**
         * 发牌
         */
        for(int i=0;i<ALL_CARDS.size()-3;i++){
            Card c=ALL_CARDS.get(i);
            if(i%3==0)
                LingHuChong.add(c);
            if(i%3==1)
                jiumozhi.add(c);
            if(i%3==2)
                dongfangbubai.add(c);
        }
    }
}
