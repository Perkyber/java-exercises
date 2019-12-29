package com.multi.io;

import com.multi.pojo.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/11/9 10:31
 * @description: 使用ObjectInputStream进行反序列化
 */
public class DeserializationTest {

    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream("io" + File.separator + "io.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        Person person = (Person) ois.readObject();
        System.out.println("person = " + person);
        ois.close();
    }
}
