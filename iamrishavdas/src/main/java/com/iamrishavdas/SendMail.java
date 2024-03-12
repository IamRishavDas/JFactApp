package com.iamrishavdas;

import java.io.File;

import java.util.Properties;
import java.util.Scanner;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendMail {

    public boolean send(String to, String from, String subject, String message){
        boolean flag = false;

        // setting smtp properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls", true);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // credential
        String user = "javafactmail@gmail.com";
        String password = "njlm pmfr csbp cbcw";

        // creating authonticator
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, password);
            }
        };

        // creating session
        Session session = Session.getInstance(prop, auth);

        // creating message
        try{
            Message msg = new MimeMessage(session);
            msg.addRecipients(Message.RecipientType.CC, readRecipients());
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(subject);
            msg.setText(message);
            Transport.send(msg);
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    private InternetAddress[] readRecipients(){
        StringBuilder s = new StringBuilder("");
        Scanner scanner;
        File recipientList = new File("C:\\Users\\Risha\\Desktop\\JFactApp\\JFactApp\\iamrishavdas\\src\\main\\resources\\Recipients.txt");
        try {
            scanner = new Scanner(recipientList);
            while (scanner.hasNextLine()) {
                s.append(scanner.nextLine());
            }
            scanner.close();
            return InternetAddress.parse(String.valueOf(s));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
