package com.rentcar.webapp.Utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utility {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static String formatDate(Date date) {
        return date != null ? dateFormat.format(date) : null;
    }
    public static Date parseDate(String date) throws ParseException {
        if (date == null) return null;

        java.util.Date d = dateFormat.parse(date);
        return new Date(d.getTime());
    }

}
