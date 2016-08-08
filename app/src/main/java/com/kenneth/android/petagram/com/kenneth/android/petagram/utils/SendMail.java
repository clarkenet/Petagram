package com.kenneth.android.petagram.com.kenneth.android.petagram.utils;

import java.util.Properties;

import javax.mail.Session;

/**
 * Created by kenneth on 8/08/16.
 */
public class SendMail {

    final private String username = "odishamma@yahoo.com.mx";
    final private String password = "yahoo1234";

    private Properties props;
    private Session session;

    private String email;
    private String name;
    private String body;

    public SendMail(String body, String email, String name) {
        this.body = body;
        this.email = email;
        this.name = name;



    }
}
