package com.will.util.entity;

/**
 * ClassName:User
 * Description:
 *
 * @Author wuguanghui
 * @Email import java.util.ArrayList;
 * @Date 2019/8/24 18:06
 */
public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
