package com.example.selectanddelete.entity;


import java.io.Serializable;

/**
 * @author qianxiangsen
 */
@SuppressWarnings("serial")
public class BaseResponse implements Serializable {

    //    StatusUnit status;
//
//    public StatusUnit getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusUnit status) {
//        this.status = status;
//    }
    private int resultCode;
    private String resultMsg;
    private String ResultTotal;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultTotal() {
        return ResultTotal;
    }

    public void setResultTotal(String resultTotal) {
        ResultTotal = resultTotal;
    }
}
