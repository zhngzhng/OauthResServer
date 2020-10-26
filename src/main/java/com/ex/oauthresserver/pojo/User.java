package com.ex.oauthresserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    /**
     *
     */
    //    _id(fixed):mongodb自动生成
    private String userId; //uuid
    private String email;
    private String password;  //MD5 在后端进行MD5编码
    private String name;
    private long phoneNum;
    private UserTitle title;
    private String country;
    private String state;
    private String city;
    private String homePage;
    private ArrayList<String> organizations;
    private String introduction;
    private Date creatTime;
    private ArrayList<String> loginIp;
    private String domain;
    private ArrayList<Resource> resources;
}
