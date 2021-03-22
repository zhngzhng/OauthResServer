package com.ex.oauthresserver.controller;

import com.ex.oauthresserver.Dao.UserDaoImpl;
import com.ex.oauthresserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class OauthController {
    /*
    测试接口，获取Principal用户信息
     */
    @Autowired
    UserDaoImpl userDao;

    @GetMapping("/me")
    public Object oauthMe(Principal principal){
        String email = principal.getName();
        System.out.println(email);
        User user = userDao.readUser("email", email);
        return user;
    }
    @RequestMapping(value = "/update",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public Object updateInfo(HttpServletRequest request){
        //传输formDate即可拿到数据
        try {
            return userDao.updateUser(request);
        }catch (Exception e){
            return "Update Fail";
        }
    }
    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public Object test(HttpServletRequest request)
    {
        //传输formDate即可拿到数据
        try {
            return userDao.updateUser(request);
        }catch (Exception e){
            return "Update Fail";
        }
    }
}
