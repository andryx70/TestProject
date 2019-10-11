package com.andry.testproject;

public class Members {

    private String Name;
    private int Age;
    private Long Number;
    private Float High;

    public Members() {
    }

    public Members(String name, int age, Long number, Float high) {
        Name = name;
        Age = age;
        Number = number;
        High = high;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public Float getHigh() {
        return High;
    }

    public void setHigh(Float high) {
        High = high;
    }
}
