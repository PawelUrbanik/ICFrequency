package pl.pawel.icfreq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pawel.icfreq.service.LoadTrainService;

@Controller
public class mainController {
    @GetMapping
    public String hello(){
        return "hello";
    }
}
