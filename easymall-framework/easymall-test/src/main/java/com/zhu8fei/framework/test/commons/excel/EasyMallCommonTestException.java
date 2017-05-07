package com.zhu8fei.framework.test.commons.excel;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class EasyMallCommonTestException extends Exception {
    public EasyMallCommonTestException() {
        super();
    }

    public EasyMallCommonTestException(String message) {
        super(message);
    }

    public EasyMallCommonTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public EasyMallCommonTestException(Throwable cause) {
        super(cause);
    }

    protected EasyMallCommonTestException(String message, Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
