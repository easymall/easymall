package com.zhu8fei.core.system.trace;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by zhu8fei on 2017/3/10.
 * 操作序号
 */
public class Trace {
    private final String threadTrace;

    public Trace() {
        // FIXME UUID 算法性能略差,复杂度比较高,比较适合加密使用  此处需要修改为 高效随机算法. 粗略尝试,MAC pro 计算结果为300k dps
        threadTrace = UUID.randomUUID().toString();
    }

    public String getThreadTrace() {
        return threadTrace;
    }
}
