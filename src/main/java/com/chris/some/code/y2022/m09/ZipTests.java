package com.chris.some.code.y2022.m09;

import cn.hutool.core.util.ZipUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 测试zip解压
 *
 * @author grt
 * @version 1.0
 * @since 2022-09-30 11:31:19
 */
public class ZipTests {

    private static final String ZIP_FILE_PATH = "/Users/alex/Downloads";
    private static final String FILE_PATH = "/Users/alex/Downloads/zipFile";
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        File zipFile = new File(ZIP_FILE_PATH + File.separator + "zipFile.zip");
        if (!zipFile.exists()) {
            System.out.println("[main] 文件不存在");
            return;
        }
        unzipFileByHt(zipFile, false);
        unzipFileByJava(zipFile);
    }

    public static void writeFile() {
        File readFile = new File(ZIP_FILE_PATH + File.separator + "车型库同步ftp信息.txt");
        File file = new File(ZIP_FILE_PATH + File.separator + "folder/create/test.txt");
        try (FileInputStream fileInputStream = new FileInputStream(readFile);
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            int readLength;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((readLength = fileInputStream.read(buffer, 0, BUFFER_SIZE)) != -1) {
                fileOutputStream.write(buffer, 0, readLength);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解压zip文件以及解压文件中的zip文件，
     *
     * @param zipFile    zip文件
     * @param deleteFlag 是否删除zip文件，true：删除，false：不删除。是否删除不影响解压
     */
    public static void unzipFileByHt(File zipFile, boolean deleteFlag) {
        File file = ZipUtil.unzip(zipFile);
        if (deleteFlag) {
            // 是否删除zip文件
            boolean delete = zipFile.delete();
            System.out.println("[unzipFileByHt] file = " + zipFile.getPath() + " delete = " + delete);
        }
        if (file.isDirectory()) {
            // 目录
            File[] files = file.listFiles();
            if (null == files) {
                // 目录下无文件
                return;
            }
            for (File fileIn : files) {
                System.out.println("[unzipFileByHt] fileIn = " + fileIn);
                String fileInName = fileIn.getName();
                if (fileInName.endsWith(".zip")) {
                    System.out.println("[unzipFileByHt] fileInName = " + fileInName);
                    // 递归，解压所有zip文件
                    unzipFileByHt(fileIn, false);
                }
            }
        }
    }

    public static void unzipFileByJava(File zipFile) {
        String path = zipFile.getParent();
        System.out.println("[unzipFileByJava] path = " + path);
        String name = zipFile.getName();
        System.out.println("[unzipFileByJava] name = " + name);
        unzipFileAll(zipFile, path + File.separator + name.substring(0, name.lastIndexOf(".")), false);
    }

    /**
     * 解压所有zip文件
     *
     * @param zipFile    zip文件
     * @param path       zip文件路径
     * @param deleteFlag 是否删除文件
     */
    public static void unzipFileAll(File zipFile, String path, boolean deleteFlag) {
        System.out.println("*****************************");
        unzipFile(zipFile, path, deleteFlag);

        List<String> filePathList = new ArrayList<>();
        getFilePathList(filePathList, new File(FILE_PATH));
        System.out.println("[unzipFileAll] filePathList = " + filePathList);

        for (String filePath : filePathList) {
            if (filePath.endsWith("zip")) {
                System.out.println("[unzipFileAll] filePath = " + filePath);
                File file = new File(filePath);
                String parent = file.getParent();
                unzipFileAll(file, parent, true);
            }
        }
    }

    /**
     * 将zip文件内容解压到指定目录
     *
     * @param zipFile    zip文件
     * @param path       指定目录
     * @param deleteFlag 是否删除zip文件
     */
    public static void unzipFile(File zipFile, String path, boolean deleteFlag) {
        try (FileInputStream fileInputStream = new FileInputStream(zipFile);
             ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            while (nextEntry != null) {
                String filePath = path + File.separator + nextEntry.getName();
                if (!nextEntry.isDirectory()) {
                    // if the entry is a file, extracts it
                    extractFile(zipInputStream, filePath);
                } else {
                    // if the entry is a directory, make the directory
                    File dir = new File(filePath);
                    if (!dir.exists()) {
                        boolean mkdir = dir.mkdir();
                        System.out.println("[unzipFile] dir = " + dir + " mkdir = " + mkdir);
                    }
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (deleteFlag) {
                boolean delete = zipFile.delete();
                System.out.println("[unzipFile] zipFile = " + zipFile + " delete = " + delete);
            }
        } catch (FileNotFoundException ex) {
            System.err.format("[unzipFile] The file %s does not exist", path);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("[unzipFile] I/O error: " + ex);
            ex.printStackTrace();
        }
    }

    /**
     * 创建文件
     *
     * @param zipIn    {@link ZipInputStream}
     * @param filePath 文件路径
     * @throws IOException 异常
     */
    public static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(Paths.get(filePath));
             BufferedOutputStream bos = new BufferedOutputStream(outputStream)) {
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 获取指定路径下所有文件路径列表，包含文件夹下文件
     *
     * @param filePathList 文件路径列表结果
     * @param path         路径
     */
    public static void getFilePathList(List<String> filePathList, File path) {
        if (path.isDirectory()) {
            System.out.println("[getFilePathList] path = " + path);
            File[] files = path.listFiles();
            if (null == files) {
                return;
            }
            for (File file : files) {
                System.out.println("[getFilePathList] file = " + file);
                getFilePathList(filePathList, file);
            }
        } else {
            String filePath = path.getPath();
            filePathList.add(filePath);
        }
    }

}
