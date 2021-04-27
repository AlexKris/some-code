package com.chris.some.code.y2018.m09.d10.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alex
 */
public class TestNullBean implements Serializable {
    private static final long serialVersionUID = 8495932453985737902L;
    private String name;
    private String age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestNullBean test3bean = (TestNullBean) o;
        return Objects.equals(name, test3bean.name) &&
                Objects.equals(age, test3bean.age) &&
                Objects.equals(address, test3bean.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public String toString() {
        return "test3bean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}