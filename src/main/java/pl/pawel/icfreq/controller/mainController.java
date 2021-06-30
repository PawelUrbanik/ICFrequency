package pl.pawel.icfreq.controller;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class mainController {

    @GetMapping
    public String hello(){

        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.intercity.pl/pl/site/dla-pasazera/informacje/frekwencja.html?location=&page=2&date=2021-07-03&category%5Beic_premium%5D=eip&category%5Beic%5D=eic&category%5Bic%5D=ic&category%5Btlk%5D=tlk").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        System.out.println(doc.body());
        Set<Element> elements = new HashSet<>();
        Elements elements1 = doc.getElementsByClass("_TableFreqCol-Available");
        elements1.forEach(element -> {
            System.out.println("{");
            Elements elements2 = element.getElementsByClass("m Col");
            System.out.println(elements2.get(1).text());
            System.out.println(elements2.get(2).text());
            System.out.println(elements2.get(3).text());
            Attributes attributes = elements2.get(0).attributes();
            System.out.println(attributes.get("title"));
            System.out.println("}");
        });
        System.out.println(title);
        return "hello";
    }
}
