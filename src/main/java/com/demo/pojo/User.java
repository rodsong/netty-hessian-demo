package com.demo.pojo;

import java.io.Serializable;

/**
 * ����
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016��03��15�� added
 */
public class User implements Serializable {

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}