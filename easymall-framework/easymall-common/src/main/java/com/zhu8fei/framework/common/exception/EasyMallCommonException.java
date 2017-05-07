package com.zhu8fei.framework.common.exception;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public class EasyMallCommonException extends Exception {

    public EasyMallCommonException() {
        super();
    }

    public EasyMallCommonException(String message) {
        super(message);
    }

    public EasyMallCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public EasyMallCommonException(Throwable cause) {
        super(cause);
    }

    protected EasyMallCommonException(String message, Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
