package com.ex.oauthresserver.Dao;

import javax.servlet.http.HttpServletRequest;

public interface UserDao {
    Object readUser(String key,String value);
    Object updateUser(HttpServletRequest request);
}
