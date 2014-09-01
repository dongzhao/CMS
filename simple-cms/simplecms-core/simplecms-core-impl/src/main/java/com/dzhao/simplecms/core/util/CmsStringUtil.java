package com.dzhao.simplecms.core.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CmsStringUtil {

    private static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String DATE_FORMAT = "dd/MM/yyyy";


    private CmsStringUtil(){}

    /**
     *
     * @param date
     * @return
     */
    public static String datetimeToString(Date date){
        return dateToString(date, DATETIME_FORMAT);
    }

    public static String datetimeToString(Timestamp stamp){
        Date date = new Date(stamp.getTime());
        return dateToString(date, DATETIME_FORMAT);
    }

    /**
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        return dateToString(date, DATE_FORMAT);
    }
    /*

     */
    public static String dateToString(Date date, String formatter){
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatter);
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            throw new UnsupportedOperationException("unsupported date  [" + date.toString() + "]");
        }
    }

}
