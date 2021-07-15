package pl.pawel.icfreq.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawel.icfreq.model.TrainFrequency;
import pl.pawel.icfreq.repository.TrainFrequencyRepository;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class LoadTrainService {

    @Autowired
    private TrainFrequencyRepository trainFrequencyRepository;

    public void loadAllTrainsAndSave(String url, Date date){
        Document doc = null;

        try {
            doc = Jsoup.connect("https://www.intercity.pl/pl/site/dla-pasazera/informacje/frekwencja.html?location=&page=2&date="+date.toString()+"&category%5Beic_premium%5D=eip&category%5Beic%5D=eic&category%5Bic%5D=ic&category%5Btlk%5D=tlk").get();
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
    }

    public void loadOneTrainAndSave(Date date, Integer trainNumber){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.intercity.pl/pl/site/dla-pasazera/informacje/frekwencja.html?location="+trainNumber.toString()+"&page=1&date="+date.toString()+"&category%5Beic_premium%5D=eip&category%5Beic%5D=eic&category%5Bic%5D=ic&category%5Btlk%5D=tlk").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TrainFrequency trainFrequency = new TrainFrequency();
//        System.out.println(doc.body());
        Elements elements1 = doc.getElementsByClass("_TableFreqCol-Available");
        elements1.add(doc.getElementsByClass("_TableFreqCol-80").get(0));
        elements1.forEach(element -> {
//            System.out.println("{");
            Elements elements2 = element.getElementsByClass("m Col");
            trainFrequency.setDataDownload(new Date(System.currentTimeMillis()));
            trainFrequency.setDateOfRunning(date);
            trainFrequency.setNumber(Integer.parseInt(elements2.get(1).text()));
            trainFrequency.setCategory(elements2.get(2).text());
            trainFrequency.setFromStation(element.getElementsByClass("m Col freq-no-border").get(0).text());
            trainFrequency.setToStation(elements2.get(3).text());
            trainFrequency.setFrequency(elements2.get(0).attributes().get("title"));
//            System.out.println(elements2.get(1).text());
//            System.out.println(elements2.get(2).text());
//            System.out.println(element.getElementsByClass("m Col freq-no-border").get(0).text());
//            System.out.println(elements2.get(3).text());
//            Attributes attributes = elements2.get(0).attributes();
//            System.out.println(attributes.get("title"));
//            System.out.println("}");
        });

        trainFrequencyRepository.save(trainFrequency);
        System.out.println(trainFrequency);
    }
}
