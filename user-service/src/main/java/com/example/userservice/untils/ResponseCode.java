package com.example.userservice.untils;

/**
 * @author yudong
 * @create 2019-08-30 14:39
 */
public interface ResponseCode {
    /**
     * 账号或者密码错误
     */
    int ACCOUNT_PASSWORD_ERROR = 101;

    /**
     * 操作成功
     */
    int OK = 200;

    /**
     * 语义错误、请求参数错误
     */
    int BAD_REQUEST = 300;

    /**
     * 业务失败
     */
    int BUSINESS = 302;
}
