package com.example.userservice.untils;

import lombok.Data;

/**
 * @author yudong
 * @create 2019-08-30 15:30
 */
@Data
public class ServiceException extends RuntimeException {
    private int code;
    private String message;

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message){
        this.message = message;
    }


}
