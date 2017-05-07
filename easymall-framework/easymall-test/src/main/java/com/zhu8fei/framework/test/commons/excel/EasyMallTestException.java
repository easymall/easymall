package com.zhu8fei.framework.test.commons.excel;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class EasyMallTestException extends Exception {
    public EasyMallTestException() {
        super();
    }

    public EasyMallTestException(String message) {
        super(message);
    }

    public EasyMallTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public EasyMallTestException(Throwable cause) {
        super(cause);
    }

    protected EasyMallTestException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
