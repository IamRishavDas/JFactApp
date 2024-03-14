package com.iamrishavdas;

import org.jsoup.nodes.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScrapper {
    public void getFact() {

        String url = "https://main--dummyjavafacts.netlify.app/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements facts = doc.select(".facts");

            for(Element f : facts){
                String fact = f.select("ul").text();
                System.out.println(fact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new WebScrapper().getFact();
    }
}
