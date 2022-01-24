package com.test;


import com.test.entity.YGOCard;
import com.test.util.YGOUtil;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        YGOCard cardInfo = YGOUtil.getCardById(10000);
        System.out.println(cardInfo);

        List<YGOCard> cards = YGOUtil.getCardsByName("龙");
        for (YGOCard card : cards) {
            //System.out.println(card);
        }
    }
}