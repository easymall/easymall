package com.zhu8fei.test.commons.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MarkTestTarget(testType={"MarkTestTarget"})
public @interface MarkTestTarget
{
  String[] testType() default {"none"};
}
