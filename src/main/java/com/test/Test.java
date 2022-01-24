package com.test;


import com.test.entity.YGOCard;

import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //List<YGOCard> cardByName = YGOUtil.getCardByName("eye",YGOUtil.enDBType);
        List<YGOCard> cardByName = YGOUtil.getCardByName("究極亜竜",YGOUtil.jaDBType);
        for (YGOCard ygoCard:cardByName){
           // System.out.println(ygoCard);
            YGOCard ygoCardCH = YGOUtil.getCardById(ygoCard.getId(),YGOUtil.zhDBType);
            System.out.println(ygoCardCH.getName());
            System.out.println(ygoCardCH.getDesc());
            System.out.println(ygoCardCH);
        }

    }
}