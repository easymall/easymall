package com.zhu8fei.framework.core.system;

import org.springframework.util.StringUtils;

/**
 * Created by zhu8fei on 2017/3/18.
 */
public enum SystemContextKeyEnum {
    userId_, userName_, locale_, trace_,;

    private SystemContextKeyEnum() {
    }

    public static boolean checkKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        for (SystemContextKeyEnum SystemContextKey : SystemContextKeyEnum.values()) {
            if (SystemContextKey.name().equals(key)) {
                return true;
            }
        }
        return false;
    }

}
