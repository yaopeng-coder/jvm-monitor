package cn.hust.jvmmonitor.chapter2;

import lombok.Data;

/**
 * @program: jvm-monitor
 * @author: yaopeng
 * @create: 2019-11-16 19:36
 **/
@Data
public class User {

    private Integer userId;

    private String name;

    public User(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
