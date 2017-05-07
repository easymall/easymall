package com.zhu8fei.framework.test.commons.excel;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class CommonTestException extends RuntimeException {
    public CommonTestException() {
        super();
    }

    public CommonTestException(String message) {
        super(message);
    }

    public CommonTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonTestException(Throwable cause) {
        super(cause);
    }

    protected CommonTestException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
