package com.qingala.wave.common.utils;

import static com.google.common.collect.Maps.newHashMap;
import static org.apache.commons.collections4.MapUtils.isEmpty;

import java.util.Map;

public class ServiceException extends RuntimeException {
    
     /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    private final Map<String, Object> data = newHashMap();

    public ServiceException(ErrorCode code){
        this.errorCode = code.getCode();
        this.errorCode = code.getMessage();
    }

    public ServiceException(ErrorCode code,Map<String, Object> data){
        this.errorCode = code.getCode();
        this.errorCode = code.getMessage();
        if (!isEmpty(data)) {
            this.data.putAll(data);
        }
    }

}
