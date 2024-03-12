package com.iamrishavdas;

public class Main {
    public static void main(String[] args) {
        boolean idSended = new SendMail().send("iamrishavdas@gmail.com", "javafactmail@gmail.com", "Daily Java Fact!", "Java was made by an accident. Around 1992, James Gosling was working at the Sun Labs. He and his team at that time were building a set-top box and which is started by “cleaning up” the C++ and they all wound up with a new language called Java or Oak.");
        if(idSended){
            System.out.println("message sended succfully!");
        } else {
            System.out.println("error while sending!");
        }
    }
}