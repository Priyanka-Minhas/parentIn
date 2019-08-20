package com.sdei.parentIn.model;

import com.sdei.parentIn.utils.ConstantsKt;

public class BaseModel {


    public BaseModel() {
        this.statusCode = ConstantsKt.getCODE_ERROR();
        this.message ="";
    }

    /**
     * statusCode : 200
     * message : Registration successful
     */

    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
