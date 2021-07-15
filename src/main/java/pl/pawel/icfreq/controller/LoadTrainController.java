package pl.pawel.icfreq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawel.icfreq.service.LoadTrainService;

import java.sql.Date;


@Controller
public class LoadTrainController {

    @Autowired
    private LoadTrainService loadTrainService;

    @PostMapping("/getTrainFreq")
    public String getFreq(){
        //TODO Pobranie z formularza
        Date date = new Date(System.currentTimeMillis());
        loadTrainService.loadOneTrainAndSave(date, 15150);
        return "showFreq";
    }
}
