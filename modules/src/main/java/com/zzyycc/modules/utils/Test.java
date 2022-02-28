package com.zzyycc.modules.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className test
 * @createTime 2022/2/28 16:41
 * @description
 */
public class Test {



    public static void main(String[] args) {
        aaa(null);




    }

    public static void aaa(HttpServletResponse response){

        try {
            // 读取文件
            File file = new File("D://AutoGenerator");
            // 创建zip输出流和缓冲流
            //ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("D://code.zip"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);

            compress(zipOutputStream, bufferedOutputStream, file, null);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void compress(ZipOutputStream zipOut, BufferedOutputStream bufferedOut, File sourceFile, String name) throws IOException {
        if (StringUtils.isEmpty(name)) {
            name = sourceFile.getName();
        }
        // 如果是文件
        if (sourceFile.isFile()) {
            zipOut.putNextEntry(new ZipEntry(name));
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            BufferedInputStream bufferInTask = new BufferedInputStream(fileInputStream);
            //将源文件写入到zip文件中
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                bufferedOut.write(bytes,0, len);
            }
            bufferInTask.close();
            fileInputStream.close();
        } else {
            // 如果是文件夹，递归压缩
            File[] files = sourceFile.listFiles();
            // 如果为空，只输出文件夹
            if (null == files) {
                zipOut.putNextEntry(new ZipEntry(name + "/"));
            } else {
                for (File file : files) {
                    compress(zipOut, bufferedOut, file, name+"/"+file.getName());
                }
            }
        }


    }




}
