package com.test.util;

import com.test.enums.DbType;

import java.sql.*;

/**
 * 数据库工具类
 * @author sunhao
 */
public class DbUtil {
    /** 默认类型：中文数据库 */
    private static DbType dbType = DbType.CHINA;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setDbType(DbType dbType) {
        dbType = dbType;
    }

    public static DbType getDbType() {
        return dbType;
    }

    /**
     * 获取默认连接
     * @return
     */
    public static Connection getConnection() {
        return getConnection(dbType);
    }

    /**
     * 获取数据库连接
     * @param dbType
     * @return
     */
    public static Connection getConnection(DbType dbType) {
        String urlTemplate = "jdbc:sqlite:%s";
        try {
            return DriverManager.getConnection(String.format(urlTemplate, dbType.getDbPath()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement) {
        close(connection);
        close(statement);
    }

    /**
     * 关闭数据库资源
     * @param connection 数据库连接
     * @param statement 执行语句
     * @param resultSet 结果集
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection);
        close(statement);
        close(resultSet);
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
