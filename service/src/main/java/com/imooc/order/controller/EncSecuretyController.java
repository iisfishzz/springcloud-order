package com.imooc.order.controller;


import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EncSecuretyController {
    @Autowired
    private StringEncryptor stringEncryptor;
    @RequestMapping("encry")
    @ResponseBody
    public String  encry(String userName,String passWord){
        String username = stringEncryptor.encrypt(userName);
        String password = stringEncryptor.encrypt(passWord);
        StringBuilder retJson  = new StringBuilder(500).append("userName : ").append(
                username ).append(" &passWord : ").append(password);
        return  retJson.toString();
    }
}
