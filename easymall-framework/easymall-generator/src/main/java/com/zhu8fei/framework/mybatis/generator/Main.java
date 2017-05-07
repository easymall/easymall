package com.zhu8fei.framework.mybatis.generator;

import org.mybatis.generator.api.ShellRunner;

/**
 * Created by zhu8fei on 2017/5/4.
 */
public class Main {

    public static void main(String[] args) {
        String pre = "user";
        String config = MybatisTempletPlugin.class.getClassLoader().getResource(pre+"/generatorConfig.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }
}
