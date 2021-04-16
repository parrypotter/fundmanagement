package com.panrui.fundmanage.util;

import java.util.List;

public class PageBean<T> {
    private Integer pageNum;  //第几页
    private Integer pageSize; //每页条数
    private List<T> dataS; //总数据量
    private Integer totalNum; //总共几页
    private Integer totalSize; //总的条数

    public PageBean(Integer pageNum, Integer pageSize) {
        if(pageNum<=0){
            this.pageNum = 1;
        }else{
            this.pageNum = pageNum;
        }
        if(pageSize<=0){
            this.pageSize = 10;
        }else{
            this.pageSize = pageSize;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getpageNum() {
        return pageNum;
    }

    public void setpageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getpageSize() {
        return pageSize;
    }

    public void setpageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getdataS() {
        return dataS;
    }

    public void setdataS(List dataS) {
        this.dataS = dataS;
    }

    public Integer gettotalNum() {
        return totalNum;
    }

    public void settotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer gettotalSize() {
        return totalSize;
    }

    public void settotalSize(Integer totalSize) {
        this.totalNum = (totalSize%pageSize==0)?(totalSize/pageSize):(totalSize/pageSize+1);
        this.totalSize = totalSize;
    }

    /**
     * 开始索引
     */
    public Integer getStartIndex(){
        return (this.pageNum-1)*this.pageSize;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", dataS=" + dataS +
                ", totalNum=" + totalNum +
                ", totalSize=" + totalSize +
                '}';
    }
}
