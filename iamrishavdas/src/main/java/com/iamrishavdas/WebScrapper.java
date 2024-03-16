package com.iamrishavdas;

import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScrapper {
    private static String factCountFile = "C:\\Users\\Risha\\Desktop\\JFactApp\\JFactApp\\iamrishavdas\\src\\main\\resources\\Factcount.txt";
    private static int dailyIndex = readFactCount();

    public static String getFact() {

        int count = 0;
        String fact = "";

        String url = "https://main--dummyjavafacts.netlify.app/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements facts = doc.select(".facts");

            for (Element f : facts) {
                fact = f.select("ul").text();
                if(count == dailyIndex){
                    return fact;
                    // System.out.println(fact);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fact;
    }

    private static int readFactCount() {
        StringBuilder value = new StringBuilder("");
        try {
            FileReader reader = new FileReader(factCountFile);
            int i;
            while ((i = reader.read()) != -1) {
                value.append((char) i);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(value);
        return Integer.parseInt(value.toString());
    }

    public static void updateFactCount() {
        int numberToWrite = (dailyIndex+1)%201;
        try {
            FileWriter writer = new FileWriter(factCountFile);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(String.valueOf(numberToWrite));
            bw.close();
            writer.close();
            // System.out.println("Number written to file: " + factCountFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // new WebScrapper().getFact();

        // System.out.println(readFactCount());
        // updateFactCount();
        // System.out.println(readFactCount());

        // getFact();
        // updateFactCount();

        System.out.println(getFact());
    }
}
