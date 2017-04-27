package com.zhu8fei.backend.main;

import org.apache.log4j.NDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by cwx on 2017/4/27.
 */
@EnableAutoConfiguration
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        NDC.push("      MAIN-THREAD");
        init();
        SpringApplication.main(args);
        NDC.clear();
    }

    private static void init() {

        File path = new File(System.getProperty("user.dir") + File.separator + "backend" + File.separator + "gulpfile.js");
        if (path.exists()) {
            String os = System.getProperty("os.name").toLowerCase();
            String pre = "";
            String nvm = "nvm";
            String npm = "cnpm";
            String gulp = "gulp";
            String pipe = " | ";
            String win = "";
            if (os.indexOf("windows") >= 0) {
                nvm = "nvmw";
                pre = "cmd /c ";
                pipe = " && ";
                win = pipe +path.getAbsolutePath().split(":")[0].toLowerCase() +": "+pipe;
            }
            String commandMove =  " cd " + path.getParent();
            String commandUseNode = nvm + " use node ";
            String commandNpmInstall = npm + " install --save ";
            String commandGulp = gulp;

            String command = pre + win + commandMove + pipe + commandUseNode + pipe + commandNpmInstall + pipe + commandGulp;
            try {
                execute(command);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private static void execute(String command) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command);
        InputStream stderr = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
            logger.info(line);
        int exitVal = proc.waitFor();
        logger.info("execute result {}", exitVal);
    }
}
