package com.dzhao.simplecms.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CmsDateUtil {
    private static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private CmsDateUtil(){}

    public static Date toDate(String dateStr){
        return toDate(dateStr, null);
    }

    /**
     * To convert string to date by given date format
     * @param dateStr
     * @param datePattern
     * @return
     */
    public static Date toDate(String dateStr, String datePattern){
        SimpleDateFormat df = new SimpleDateFormat( datePattern!=null ? datePattern : DATE_FORMAT );
        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            throw new UnsupportedOperationException("unsupported date format [" + dateStr + "]");
        }
    }

    /**
     * To convert string to date by default simple date format {dd/MM/yyyy HH:mm}
     * @param dateStr
     * @return
     */
    public static Date toDateTime(String dateStr){
        return toDateTime(dateStr, null);
    }

    /**
     * To convert string to date by given date format
     * @param dateStr
     * @return
     */
    public static Date toDateTime(String dateStr, String datePattern){
        SimpleDateFormat df = new SimpleDateFormat( datePattern!=null ? datePattern : DATETIME_FORMAT );
        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            throw new UnsupportedOperationException("unsupported date format [" + dateStr + "]");
        }
    }



}
