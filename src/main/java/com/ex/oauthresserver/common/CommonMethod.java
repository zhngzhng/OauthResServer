package com.ex.oauthresserver.common;

import org.springframework.data.mongodb.core.query.Update;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class CommonMethod {
    public static Update setUpdate(HttpServletRequest request){
        Update update = new Update();
//      拿到前端的给的内容
        Enumeration parameters = request.getParameterNames();
        while (parameters.hasMoreElements()){
            String key = (String)parameters.nextElement();
            String value = request.getParameter(key);
            if(!key.equals("userState")){
                update.set(key,value);
            }
        }
        return update;
    }
}
