package com.zjw.service;

        import com.zjw.Email;

public interface IEmailService {
    Email getEmailCode(String addressee);

    Email getEmailToPwd(String addressee,String name);
}
