package com.kenneth.android.petagram.utils;

import android.util.Log;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com");
        props.put("mail.smtp.port", "465");
    }

    private Session getSession() {
        session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }

    public boolean isSended() {

        try {

            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Petagram");
            message.setText("Message from " + name + ": \n \n" + body);

            Transport.send(message);
            Log.i("email", "Mensaje enviado!");

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("email", "Error al enviar!");
            return false;
        }

        return true;
    }

}
