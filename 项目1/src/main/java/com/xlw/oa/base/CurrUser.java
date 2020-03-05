package com.xlw.oa.base;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/4 16:40
 */
public class CurrUser {
    private String userId;
    private String userName;

    public CurrUser(String userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public CurrUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
