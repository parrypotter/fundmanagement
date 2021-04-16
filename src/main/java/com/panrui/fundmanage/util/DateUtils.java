package com.panrui.fundmanage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtils {

    private final static String patternTime = "yyyy-MM-dd";

    public String DateToString(Date dateTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat(patternTime);
        return dateFormat.format(dateTime);
    }

    public Date StringToDate(String dateString) throws ParseException {
        SimpleDateFormat stringFormat = new SimpleDateFormat(patternTime);
        return stringFormat.parse(dateString);
    }

    public Date DateToDateTime(Date data) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patternTime);
        return StringToDate(DateToString(data));
    }
}
