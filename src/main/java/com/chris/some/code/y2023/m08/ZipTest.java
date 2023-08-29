package com.chris.some.code.y2023.m08;

import cn.hutool.core.util.ObjectUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZipTest {

    public static void main(String[] args) {
        String localPath = "/Users/admin/Downloads/";
        String totalFilename = "FAF_CREDIT_NO2203864.zip";
        String filename = "FAF_CREDIT_NO2203864";
        String unZipFilePath = localPath + filename + "/";
        String zipFilePath = localPath + totalFilename;
        File zipFile = new File(zipFilePath);
        File unzipFile = new File(unZipFilePath);
        ZipUtils.unZipFile(zipFile, unzipFile);

        List<File> fileList = new ArrayList<>();
        getFileList(fileList, unzipFile);
        if (fileList.isEmpty()) {
            System.out.println("empty");
            return;
        }
        // IDENTITY 身份证正面、身份证反面、人脸识别照片
        List<File> identityFile = new ArrayList<>();
        // AUTHORIZATION 个人征信授权书
        List<File> authorizationFile = new ArrayList<>();
        // CONTRACT 贷款抵押合同
        List<File> contractFile = new ArrayList<>();
        for (File file : fileList) {
            File parentFile = file.getParentFile();
            String parentFilename = parentFile.getName();
            if (parentFilename.contains("IDENTITY")) {
                identityFile.add(file);
            } else if (parentFilename.contains("AUTHORIZATION")) {
                authorizationFile.add(file);
            } else if (parentFilename.contains("CONTRACT")) {
                contractFile.add(file);
            }
        }
        System.out.println("identityFile size " + identityFile.size() + ", identityFile = " + identityFile);
        System.out.println("authorizationFile size " + authorizationFile.size() + ", authorizationFile = " + authorizationFile);
        System.out.println("contractFile size " + contractFile.size() + ", contractFile = " + contractFile);
    }

    public static void getFileList(List<File> fileList, File file) {
        File[] files = file.listFiles();
        if (Objects.isNull(files) || ObjectUtil.isEmpty(files)) {
            return;
        }
        for (File fileInner : files) {
            String name = fileInner.getName();
            if (".DS_Store".equals(name) || "__MACOSX".equals(name)) {
                continue;
            }
            if (fileInner.isDirectory()) {
                getFileList(fileList, fileInner);
            } else {
                fileList.add(fileInner);
            }
        }
    }
}
