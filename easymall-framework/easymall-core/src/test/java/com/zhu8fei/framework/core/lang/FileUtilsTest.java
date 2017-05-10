package com.zhu8fei.framework.core.lang;

import com.zhu8fei.framework.core.lang.io.FileUtils;
import com.zhu8fei.framework.core.method.LangTest;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by zhu8fei on 2017/5/10.
 */
@MarkTestTarget(LangTest.class)
public class FileUtilsTest extends BaseJunitTest {
    private String projectDir = System.getProperty("user.dir");

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void createFileTest() throws IOException {
        logger.info("user.dir : {}", projectDir);
        // 日志.log文件 会被git忽略
        // mac下  \\目录会死活认为目录存在
        FileUtils.createFile(projectDir+"/a/a.log");
        FileUtils.createFile(projectDir + "/a.log");
        Files.delete(Paths.get(projectDir + "/a.log"));
        Files.delete(Paths.get(projectDir + "/a/a.log"));
        Files.delete(Paths.get(projectDir + "/a"));
    }

    @Test
    public void createDirTest() throws IOException {
        logger.info("user.dir : {}", projectDir);
        // 日志.log文件 会被git忽略
        FileUtils.mkdir(projectDir + "/b.log");
        Files.delete(Paths.get(projectDir + "/b.log"));
        FileUtils.mkdir(projectDir + "/b/b");
        FileUtils.mkdir(projectDir + "/b");
        Files.delete(Paths.get(projectDir + "/b/b"));
        Files.delete(Paths.get(projectDir + "/b"));
    }
}