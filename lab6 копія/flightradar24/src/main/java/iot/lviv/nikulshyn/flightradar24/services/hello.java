package iot.lviv.nikulshyn.flightradar24.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @RequestMapping("/")
    public String printHello(){
        return "hello";
    }
}
