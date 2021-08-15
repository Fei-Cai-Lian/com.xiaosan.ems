package com.xiaosan.ems.entity;
/**
 * 编写顺序——database.properties 配置文件
 *      ——utils中的 DbUtils 工具类
 *      ——entity 实体类中的 EmpManager
 *
 */
public class EmpManager {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmpManager() {
    }

    public EmpManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    ——》dao 层 EmpManagerDao 接口

}
