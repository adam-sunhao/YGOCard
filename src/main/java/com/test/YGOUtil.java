package com.test;

import com.test.entity.YGOCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rumble on 2022/1/24.
 */
public class YGOUtil {
    public static final Integer zhDBType = 0 ;
    public static final Integer enDBType = 1 ;
    public static final Integer jaDBType = 2 ;
    private static final String zhDBURL = "zhcards.cdb" ;
    private static final String enDBURL = "encards.cdb" ;
    private static final String jaDBURL = "jacards.cdb" ;
    private static final String BASEDBURL = "jdbc:sqlite:" ;

    private static Connection getConnectionType(Integer type) throws SQLException {
        Connection connection = null;
        String url = null;
        if (enDBType.equals(type)){
            url = BASEDBURL+enDBURL;
        }else if (jaDBType.equals(type)){
            url = BASEDBURL+jaDBURL;
        }else {
            url = BASEDBURL+zhDBURL;
        }
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public static YGOCard getCardById(Integer id,Integer type) throws ClassNotFoundException {


        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {

            connection = getConnectionType(type);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from texts where id = "+id);
            while(rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setDesc(rs.getString("desc"));
                ygoCard.setName(rs.getString("name"));
                ygoCard.setStr1(rs.getString("str1"));
                ygoCard.setStr2(rs.getString("str2"));
                ygoCard.setStr3(rs.getString("str3"));
                ygoCard.setStr4(rs.getString("str4"));
                ygoCard.setStr5(rs.getString("str5"));
                ygoCard.setStr6(rs.getString("str6"));
                ygoCard.setStr7(rs.getString("str7"));
                ygoCard.setStr8(rs.getString("str8"));
                ygoCard.setStr9(rs.getString("str9"));
                ygoCard.setStr10(rs.getString("str10"));
                ygoCard.setStr11(rs.getString("str11"));
                ygoCard.setStr12(rs.getString("str12"));
                ygoCard.setStr13(rs.getString("str13"));
                ygoCard.setStr14(rs.getString("str14"));
                ygoCard.setStr15(rs.getString("str15"));
                ygoCard.setStr16(rs.getString("str16"));
                return ygoCard;
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return null;
    }



    //根据名字模糊搜索卡牌编号 type指定语言
    public static List<YGOCard> getCardByName(String name,Integer type) throws ClassNotFoundException {

        List<YGOCard> cardList = new ArrayList<YGOCard>();

        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {
            connection = getConnectionType(type);
            String sql = "select * from texts where name like \'%"+name + "%\'";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setName(rs.getString("name"));
                ygoCard.setDesc(rs.getString("desc"));
                ygoCard.setStr1(rs.getString("str1"));
                ygoCard.setStr2(rs.getString("str2"));
                ygoCard.setStr3(rs.getString("str3"));
                ygoCard.setStr4(rs.getString("str4"));
                cardList.add(ygoCard);
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return cardList;
    }

    public static YGOCard getDatas(Integer id) throws ClassNotFoundException {


        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:sqlite:zhcards.cdb");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from datas where id = "+id);
            while(rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setDesc(rs.getString("ot"));
                ygoCard.setName(rs.getString("alias"));
                ygoCard.setStr1(rs.getString("setcode"));
                ygoCard.setStr2(rs.getString("type"));
                ygoCard.setStr3(rs.getString("atk"));
                ygoCard.setStr4(rs.getString("def"));
                ygoCard.setStr5(rs.getString("level"));
                ygoCard.setStr6(rs.getString("race"));
               // ygoCard.setStr7(rs.getString("attributecategory"));

                return ygoCard;
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return null;
    }


}
