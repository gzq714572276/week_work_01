package com.zjw.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjw.Email;
import com.zjw.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;
import java.util.Random;

@Service
public class EmailServiceImpl implements IEmailService {
    //获得一封邮件
    private EmailImpl emailImpl = new EmailImpl();
    @Autowired
    private JavaMailSender javaMailSender;
    /*
    * 发送验证码
    * */
    @Override
    public Email getEmailCode(String addressee) {
        System.out.println(addressee);
        int emailCode = new Random().nextInt(8999) + 1000;
        Email email = new Email();
        email.setSender("gzq___123@sina.com");
        email.setAddressee(addressee);
        email.setSubject("验证码请妥善保管");
        email.setContent(emailCode + "");
        email.setSendtime(new Date());
        emailImpl.getEmail(email,javaMailSender);
        return email;
    }

    @Override
    public Email getEmailToPwd(String address,String name) {
        System.out.println(address);

        Email email = new Email();
        email.setSender("gzq___123@sina.com");
        email.setAddressee(address);
        email.setSubject("重置密码");
        email.setContent("请点击<a href='http://127.0.0.1:8080/user/toResetPsw?name="+name+" '>这里</a>重置密码~");
        email.setSendtime(new Date());
        emailImpl.getEmail(email,javaMailSender);
        return email;
    }
    /*
    * 修改密码邮件
    * */

}
