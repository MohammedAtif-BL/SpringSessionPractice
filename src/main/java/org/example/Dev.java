package org.example;

public class Dev {
    private Demo demo;

    public Dev(Demo demo) {
        this.demo = demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    int age;

    public Dev(int age) {
        this.age = age;
    }

    public Dev() {
        System.out.println("Dev Constructor");
    }

    public void build(){
        System.out.println("Working on Dev");
        demo.compile();
    }
}
