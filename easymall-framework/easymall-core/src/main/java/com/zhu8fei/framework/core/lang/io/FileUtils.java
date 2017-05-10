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
    public static boolean createFile(File file) throws IOException {
        Assert.notNull(file, "File not be null");
        if (file.isDirectory()) {
            throw new IllegalArgumentException("File : " + file.getAbsolutePath() + " is a directory !");
        }
        if (file.exists()) {
            return true;
        }
        if (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        file.createNewFile();
        return true;
    }

    /**
     * 创建空文件
     *
     * @param file
     */
    public static boolean createFile(String file) throws IOException {
        Assert.notNull(file, "File not be null");
        return createFile(new File(file));
    }

    /**
     * 创建目录
     *
     * @param file
     */
    public static boolean mkdir(String file) throws IOException {
        Assert.notNull(file, "directory not be null");
        return mkdir(new File(file));
    }

    /**
     * 创建目录
     *
     * @param file
     */
    public static boolean mkdir(File file) throws IOException {
        Assert.notNull(file, "directory not be null");

        if (file.isFile()) {
            throw new IllegalArgumentException("File : " + file.getAbsolutePath() + " is a file !");
        }
        if (file.exists()) {
            return true;
        }
        if (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }
        file.mkdir();
        return true;
    }
}
