package com.zhu8fei.framework.core.file;

import com.zhu8fei.framework.core.exception.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhu8fei on 2017/5/7.
 */
public class SimpleFileReader {
    private static Logger logger = LoggerFactory.getLogger(SimpleFileReader.class);

    public static String readAnFileContext(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            throw new CoreException("文件不存在");
        }
        StringBuilder sb = new StringBuilder();
        try {
            List<String> contentLines = Files.lines(Paths.get(file.toURI()))
                    .collect(Collectors.toList());
            if (contentLines != null) {
                logger.debug("read file in {} lines", contentLines.size());
            } else {
                return sb.toString();
            }
            for (String str : contentLines) {
                sb.append(str);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new CoreException(e);
        }
        return sb.toString();
    }

}
