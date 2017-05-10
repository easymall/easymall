package com.zhu8fei.framework.core.lang.io;

import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhu8fei on 2017/5/10.
 */
public class FileUtils {
    /**
     * 创建空文件
     *
     * @param file
     */
    public static void createFile(File file) throws IOException {
        Assert.notNull(file, "File not be null");
        if (file.isDirectory()) {
            throw new IllegalArgumentException("File : " + file.getAbsolutePath() + " is a directory !");
        }
        if (file.exists()) {
            return;
        }
        if (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        file.createNewFile();
    }

    /**
     * 创建空文件
     *
     * @param file
     */
    public static void createFile(String file) throws IOException {
        Assert.notNull(file, "File not be null");
        createFile(new File(file));
    }

    /**
     * 创建目录
     *
     * @param file
     */
    public static void mkdir(String file) throws IOException {
        Assert.notNull(file, "directory not be null");
        mkdir(new File(file));
    }

    /**
     * 创建目录
     *
     * @param file
     */
    public static void mkdir(File file) throws IOException {
        Assert.notNull(file, "directory not be null");

        if (file.isFile()) {
            throw new IllegalArgumentException("File : " + file.getAbsolutePath() + " is a file !");
        }
        if (file.exists()) {
            return;
        }
        if (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        file.mkdir();
    }
}
