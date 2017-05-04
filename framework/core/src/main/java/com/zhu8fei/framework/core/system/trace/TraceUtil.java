package com.zhu8fei.framework.core.system.trace;

/**
 * Created by zhu8fei on 2017/3/10.
 * 操作序号助手
 */
public class TraceUtil {
    public static String incSpanLevel(String span) {
        if ((span == null) || (span.length() <= 0)) {
            return "1";
        }
        if ("1".equals(span)) {
            StringBuilder nextSpan = new StringBuilder(span);
            nextSpan.append("-");
            nextSpan.append("1");
            return nextSpan.toString();
        }
        if (span.indexOf("-") > 0) {
            String preSpanLevel = span.substring(0, span.lastIndexOf("-"));
            String curSpanLevel = span.substring(span.lastIndexOf("-") + 1);
            StringBuilder nextSpan = new StringBuilder(preSpanLevel);
            nextSpan.append("-");
            nextSpan.append(String.valueOf(Integer.parseInt(curSpanLevel) + 1));
            return nextSpan.toString();
        }
        return "1";
    }
}