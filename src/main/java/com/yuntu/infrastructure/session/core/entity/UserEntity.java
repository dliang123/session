package com.yuntu.infrastructure.session.core.entity;

import javax.persistence.*;

/**
 * Created by jackdeng on 2017/10/26.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    //主键、自动生成
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid",insertable = false, updatable = false)
    private Long id;
    @Column(name = "username" )
    private String userName;
    //密码
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
