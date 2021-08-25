package pl.pawel.icfreq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pawel.icfreq.model.TrainFrequency;
import pl.pawel.icfreq.service.LoadTrainService;

import java.sql.Date;


@RestController
public class LoadTrainController {

    private LoadTrainService loadTrainService;

    public LoadTrainController(LoadTrainService loadTrainService) {
        this.loadTrainService = loadTrainService;
    }

    @PostMapping("/getTrainFreq")
    public ResponseEntity<?> getFreq(
            @RequestParam("train_nr") Integer train_nr,
            @RequestParam("date_of_running") Date date
            ){
        //TODO Pobranie z formularza
        System.out.println(train_nr);
        System.out.println(date);
//        Date date2 = date;
        TrainFrequency frequency= loadTrainService.loadOneTrainAndSave(date, train_nr);

        if (frequency!=null)
        {
            return new ResponseEntity<>(frequency, HttpStatus.CREATED);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
