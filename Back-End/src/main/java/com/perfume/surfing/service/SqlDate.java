package com.perfume.surfing.service;

import java.util.Date;

public class SqlDate {
    static public java.sql.Date now(){
        Date utilDate = new Date();
        long milliSeconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(milliSeconds);

        return sqlDate;
    }
}
