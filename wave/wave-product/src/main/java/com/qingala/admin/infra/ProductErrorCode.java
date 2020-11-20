package com.qingala.admin.infra;

import com.qingala.wave.common.utils.ErrorCode;

public enum ProductErrorCode implements ErrorCode{
    
    SPU_NOT_FOUND(404,"没有找到该商品");

    private int status;
    private String message;

    ProductErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return this.name();
    }
}
