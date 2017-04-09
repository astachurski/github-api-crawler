package githubcrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {


    private RestFetcher restFetcher;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "dupa") String name){
        try {
            restFetcher.fetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Greeting(7, name);
    }
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    @Autowired
    public void setRestFetcher(RestFetcher restFetcher) {
        this.restFetcher = restFetcher;
    }
}