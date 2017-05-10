package com.zhu8fei.framework.core.lang;

import com.zhu8fei.framework.core.lang.io.FileUtils;
import com.zhu8fei.framework.core.test.method.LangTest;
import com.zhu8fei.framework.test.commons.BaseJunitTest;
import com.zhu8fei.framework.test.commons.utils.MarkTestTarget;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

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
        FileUtils.createFile(projectDir + "\\a.log");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("is a directory");
        FileUtils.createFile(projectDir);
    }

    @Test
    public void createDirTest() throws IOException {
        logger.info("user.dir : {}", projectDir);
        // 日志.log文件 会被git忽略
        FileUtils.mkdir(projectDir + "\\a");
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("is a file");
        FileUtils.mkdir(projectDir + "\\a.log");

    }
}