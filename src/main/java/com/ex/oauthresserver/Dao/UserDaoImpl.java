package com.ex.oauthresserver.Dao;

import com.ex.oauthresserver.common.CommonMethod;
import com.ex.oauthresserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class UserDaoImpl implements UserDao{
    private final MongoTemplate mongoTemplate;

    public UserDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Object readUser(String key,String value) {
        Query query = Query.query(Criteria.where(key).is(value));
        User user = mongoTemplate.findOne(query,User.class,"users");
        user.setPassword("");
        return user;
    }

    @Override
    public Object updateUser(HttpServletRequest request) {
        try {
            //将整个新的内容以formData传输过来
            String userId = request.getParameter("userId");
            Query queryStr = new Query(Criteria.where("userId").is(userId));
            Update updateStr = CommonMethod.setUpdate(request);
            mongoTemplate.updateFirst(queryStr,updateStr,User.class,"users");
            User newUser = mongoTemplate.findOne(queryStr, User.class, "users");
            newUser.setPassword("");
            return newUser;
        }catch (Exception e){}
        return null;
    }

}
