package com.panrui.fundmanage.util;

import java.util.List;
/*
 * @ClassName Data
 * @Description  根据uid批量操作数据，独立DAO
 * @Param
 **/
public class Data {
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private List<Integer> ids;
}
