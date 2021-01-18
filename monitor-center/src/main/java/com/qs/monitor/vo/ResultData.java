package com.qs.monitor.vo;

import java.io.Serializable;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/17       create this file
 * </pre>
 */
public class ResultData<T> implements Serializable {

    /**
     * 返回码 200 代表成功
     */
    private Integer code;

    private String message;

    private String errorMessage;

    private T data;

    public ResultData() {
    }

    public ResultData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    public static ResultData success(Object object) {
        ResultData resultData = new ResultData();
        resultData.setData(object);
        resultData.setCode(200);
        resultData.setMessage("处理成功");
        return resultData;
    }
}
