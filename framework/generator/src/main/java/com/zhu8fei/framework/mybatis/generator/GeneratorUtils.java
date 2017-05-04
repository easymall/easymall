package com.zhu8fei.framework.mybatis.generator;

import org.apache.commons.lang.WordUtils;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public class GeneratorUtils {
    public static String first(String tableName) {
        String[] names = tableName.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < names.length; i++) {
            sb.append(WordUtils.capitalize(names[i]));
        }
        return sb.toString();
    }
}
