package com.baker.learning.learnmultipledb.configuration;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.atomic.AtomicInteger;


@Log4j2
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        log.info("change db connect to master");
        set(DBTypeEnum.MASTER);
    }

    public static void slave() {
        log.info("change db connect to slave");
        set(DBTypeEnum.SLAVE);
    }

    public static void clearDatabaseSource() {
        contextHolder.remove();
    }
}
