package com.zhu8fei.framework.test.commons.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MarkTestTarget({"MarkTestTarget"})
public @interface MarkTestTarget {
    String[] value() default {"none"};
}
