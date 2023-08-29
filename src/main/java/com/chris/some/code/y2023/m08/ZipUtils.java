package com.chris.some.code.y2023.m08;

import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.nio.charset.Charset;

public class ZipUtils {

    public static void unZipFile(File zipFile, File unzipFilePath) {
        File file;
        try {
            file = ZipUtil.unzip(zipFile, unzipFilePath);
        } catch (IllegalArgumentException e) {
            file = ZipUtil.unzip(zipFile, unzipFilePath, Charset.forName("GBK"));
        }
    }
}
