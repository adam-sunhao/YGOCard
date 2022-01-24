package com.test.enums;

/**
 * 数据库类型
 * @author sunhao
 */
public enum DbType {
    /**
     * 多语言数据库类型
     */
    CHINA("db/zh-CN/cards.cdb"), ENGLISH("db/en-US/cards.cdb"), JAPAN("db/ja-JP/cards.cdb"), KOREA("db/ko-KR/cards.cdb");

    DbType(String dbPath) {
        this.dbPath = dbPath;
    }

    private String dbPath;

    public String getDbPath() {
        return dbPath;
    }
}
