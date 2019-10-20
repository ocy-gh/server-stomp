package com.example.server.entity.po;

public class Greeting {

    private String content;

    //TESTING
    private String name;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}