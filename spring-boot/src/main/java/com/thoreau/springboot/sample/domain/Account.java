package com.thoreau.springboot.sample.domain;

/**
 * 17/7/15 下午10:15.
 *
 * @author zhaozhou
 */
public class Account {
    private final String id;
    private final String type;
    private final String email;

    public Account(String id, String type, String email) {
        this.id = id;
        this.type = type;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }
}
