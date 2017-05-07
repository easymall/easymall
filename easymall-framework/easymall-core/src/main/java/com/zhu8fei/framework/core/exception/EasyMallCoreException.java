package com.zhu8fei.framework.core.exception;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class EasyMallCoreException extends Exception {
    public EasyMallCoreException() {
        super();
    }

    public EasyMallCoreException(String message) {
        super(message);
    }

    public EasyMallCoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public EasyMallCoreException(Throwable cause) {
        super(cause);
    }

    protected EasyMallCoreException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
