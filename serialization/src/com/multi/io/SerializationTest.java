package com.multi.io;

import com.multi.pojo.Person;

import java.io.*;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/11/9 10:30
 * @description: 使用ObjectOutputStream进行序列化
 */
public class SerializationTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream os = new FileOutputStream("io" + File.separator + "io.txt");
        ObjectOutputStream ops = new ObjectOutputStream(os);
        ops.writeObject(new Person("JAY",20, 1));
        ops.close();
    }

}
