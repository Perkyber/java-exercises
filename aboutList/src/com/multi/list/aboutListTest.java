package com.multi.list;

import com.multi.entity.PersonResult;
import com.multi.pojo.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/11/10 9:43
 * @description:
 */
public class aboutListTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("房山", 22);
        Person person2 = new Person("李四", 33);
        personList.add(person1);
        personList.add(person2);
        PersonResult personResult = new PersonResult(personList.size(), personList);
        System.out.println("personResult = " + personResult);
        List result = personResult.getResult();
        System.out.println("result = " + result);
    }

}
