package com.example.userservice.untils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yudong
 * @create 2019-08-30 14:33
 */
@Data
public class ResultMessage {
    /**
     * 响应码
     */
    private int responseCode;

    /**
     * 响应码详细说明
     */
    private String message;

    /**
     * 响应数据
     */
    private Map<String,Object> resultPram;

    public ResultMessage() {
        this.responseCode = ResponseCode.OK;
        this.message = "success";
    }

    public ResultMessage(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public ResultMessage(int responseCode, String message, Object o) {
        this.responseCode = responseCode;
        this.message = message;
        if (o != null){
            if (resultPram == null){
                resultPram= new HashMap<>();
            }
            this.resultPram.put("resource", o);
        }
    }

    public ResultMessage putParam(Object value) {
        if (value != null){
            if (resultPram == null){
                resultPram= new HashMap<>();
            }
            this.resultPram.put("resource", value);
            return this;
        }
        return this;
    }

    public ResultMessage putParam(String key, Object value) {
        if (value != null){
            if (resultPram == null){
                resultPram= new HashMap<>();
            }
            this.resultPram.put(key, value);
            return this;
        }
        return this;
    }
}
