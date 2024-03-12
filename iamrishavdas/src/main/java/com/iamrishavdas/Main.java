package com.iamrishavdas;

public class Main {
    public static void main(String[] args) {
        boolean idSended = new SendMail().send("iamrishavdas@gmail.com", "javafactmail@gmail.com", "Daily Java Fact!", "java means cup of coffee!, so do you feel like to have java");
        if(idSended){
            System.out.println("message sended succfully!");
        } else {
            System.out.println("error while sending!");
        }
    }
}