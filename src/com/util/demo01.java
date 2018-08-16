package com.util;

import java.io.*;

public class demo01 {

    public static void main(String[] args) {
        String strPath = "F:/iotest/1.txt";
        //1.建立file对象
        File file = new File(strPath);
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            //3.读取
            byte[] bytes = new byte[1024];
            int len = 0;
            while (-1 != (len = is.read(bytes))) {
                //输出
                String info = new String(bytes, 0, len);
                System.out.println(info);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

}
