package githubcrawler.service;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class RestService {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "dupa") String name){
        return new Greeting(7, name);
    }
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }




}