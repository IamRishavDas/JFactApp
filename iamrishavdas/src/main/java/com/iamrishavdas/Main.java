package com.iamrishavdas;

public class Main {
    public Main() {
        boolean isSended = new SendMail().send("iamrishavdas@gmail.com", "javafactmail@gmail.com", "Daily Java Fact!",
                WebScrapper.getFact());
        if (isSended) {
            WebScrapper.updateFactCount();
            System.out.println("message sended succfully!");
        } else {
            System.out.println("error while sending!");
        }
    }
}