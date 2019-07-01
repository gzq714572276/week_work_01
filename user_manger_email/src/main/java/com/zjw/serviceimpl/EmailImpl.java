package com.zjw.serviceimpl;

import com.zjw.Email;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class EmailImpl {

    public void getEmail(Email email,JavaMailSender javaMailSender) {
        System.out.println(email);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

            mimeMessageHelper.setFrom(email.getSender());

            mimeMessageHelper.addTo(email.getAddressee(),"亲");

            mimeMessageHelper.setSubject(email.getSubject());

            mimeMessageHelper.setText(email.getContent(),true);

            mimeMessageHelper.setSentDate(email.getSendtime());

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
