package com.panrui.fundmanage.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author panrui
 * @Classname DateFormatUtil
 * @Description 日期转换
 */
@Component
public class DateFormatUtil {
    private final static String FORMAT = "yyyy-MM-dd";
    public String getFormatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        return date==null?"2121-04-08":dateFormat.format(date);
    }
}
