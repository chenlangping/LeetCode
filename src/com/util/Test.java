package com.util;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        myFileIO f = new myFileIO();
        byte[] data = f.getBytesFromFile("F:/iotest/1.txt");
        f.writeBytesToFile("F:/iotest/11.txt",data);
        //File src = new File("F:/iotest/1.txt");
        //System.out.println(f.readFile("F:/iotest/10.txt"));

    }
}
