package com.zhu8fei.framework.core.system;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by zhu8fei on 2017/3/9.
 * <p>
 * 上下文类. 用于获取当前操作的上下文.
 */
public class SystemContext {
    private static String USER_ID = SystemContextKeyEnum.userId_.name();
    private static String USER_NAME = SystemContextKeyEnum.userName_.name();
    private static String LOCALE = SystemContextKeyEnum.locale_.name();
    private static String TRACE = SystemContextKeyEnum.trace_.name();
    private static final transient ThreadLocal<Map<String, String>> contextMap = new ThreadLocal<>();
    private static Integer MAX_CAPACITY = 20;
    private static Integer MAX_SIZE = 200;

    public static Map<String, String> getContextMap() {
        return contextMap.get();
    }

    public static String get(String key) {
        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            return null;
        }
        return contextMap.get(key);
    }

    public static String put(String key, String value) {
        if (!SystemContextKeyEnum.checkKey(key)) {
            throw new RuntimeException("key:" + key + " is not registered.");
        }
        if ((value == null)) {
            throw new RuntimeException("value:" + key + " is null,i can't put it into the context map");
        }
        if (value.length() > MAX_SIZE) {
            throw new RuntimeException("value is more than " + MAX_SIZE + ", i can't put it into the context map");
        }

        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            synchronized (SystemContext.contextMap) {
                if (contextMap == null) {
                    contextMap = new HashMap<>();
                    SystemContext.contextMap.set(contextMap);
                }
            }
        } else if (contextMap.size() > MAX_CAPACITY) {
            throw new RuntimeException("the context map is full, can't put anything");
        }
        return contextMap.put(key, value);

    }

    public static String getLocale() {
        return get(LOCALE);
    }

    public static void setLocale(String locale) {
        put(LOCALE, locale);
    }

    public static void setUserId(Long userId) {
        if (userId != null) {
            put(USER_ID, userId + "");
        }
    }

    public static Long getUserId() {
        String userId = get(USER_ID);
        if ((userId == null) || ("null".equalsIgnoreCase(userId.trim()))) {
            return null;
        }
        return Long.valueOf(userId);
    }

    public static void setUserName(String userName) {
        if (userName != null) {
            if (userName.length() > MAX_SIZE) {
                put(USER_NAME, userName.substring(0, MAX_SIZE));
            } else {
                put(USER_NAME, userName);
            }
        }
    }
    public static void setTrace(String trace) {
        if (trace != null) {
            if (trace.length() > MAX_SIZE) {
                put(TRACE, trace.substring(0, MAX_SIZE));
            } else {
                put(TRACE, trace);
            }
        }
    }

    public static String getUserName() {
        return get(USER_NAME);
    }

    public static String getTrace(){
        return get(TRACE);
    }

    public static void clean() {
        contextMap.remove();
    }
}

