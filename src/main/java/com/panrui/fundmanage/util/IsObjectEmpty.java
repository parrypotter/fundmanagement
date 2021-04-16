package com.panrui.fundmanage.util;
/*
 * @ClassName IsEmpty
 * @Description  由于StringUtils方法中的isEmpty已弃用，故用此方法代替
 * @Param
 **/
public class IsObjectEmpty {
    public boolean isEmpty(Object obj){
        return obj == null || "".equals(obj);
    }
}
