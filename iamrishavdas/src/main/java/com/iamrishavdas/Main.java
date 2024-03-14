package com.iamrishavdas;

public class Main {
    public static void main(String[] args) {
        boolean idSended = new SendMail().send("iamrishavdas@gmail.com", "javafactmail@gmail.com", "Daily Java Fact!", "Java's syntax was influenced by C and C++, but it also borrowed concepts from other languages like Smalltalk.");
        if(idSended){
            System.out.println("message sended succfully!");
        } else {
            System.out.println("error while sending!");
        }
    }
}