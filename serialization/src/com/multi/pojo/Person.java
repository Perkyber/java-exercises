package com.multi.pojo;

import java.io.Serializable;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/11/9 10:27
 * @description: Person实体类进行序列化
 */
public class Person implements Serializable {

    /**
     *      指定序列对象的固定版本号
     */
    private final static long serialVersionUID = 8656128222714547171L;

    // 需进行序列化
    private String name;
    // transient --> 不进行序列化, Integer默认值为null
    transient private Integer age;
    private Integer sex;
    private Long phone;
    // 增加的字段
    //private Boolean isMarry;


    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, Integer age, Integer sex, Long phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
