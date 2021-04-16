package com.panrui.fundmanage.util;
/*
 * @ClassName AjaxResult
 * @Description  前端ajax交互之后的返回信息，json格式返回前端
 * @Param
 **/
public class AjaxResult {
    private boolean success;
    private String message;
    private String imgurl;
    private String typeId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }


}
