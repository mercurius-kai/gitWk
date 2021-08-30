package com.pinming.wk.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: wk
 * @Date: 2020/7/8 18:20
 */
@Data
public class People implements Serializable {

    private  String id;
    private String name;
    private int age;
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
