package pl.pawel.icfreq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping
    public String hello(){
        return "hello";
    }
}
