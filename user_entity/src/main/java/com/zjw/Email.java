package com.zjw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {

    private String sender;
    private String addressee;
    private String subject;
    private String content;
    private Date sendtime;
}
