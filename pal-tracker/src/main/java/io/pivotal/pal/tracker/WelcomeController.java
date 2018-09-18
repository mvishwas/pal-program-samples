package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.*;



@RestController
public class WelcomeController {

    @Autowired
    public WelcomeController( @Value("${WELCOME_MESSAGE:Hello from test}") final String message){
        this.welcomeMessage=message;
    }


    private String welcomeMessage;

    @GetMapping("/")
    public String sayHello() {
        System.out.print("from env " +System.getenv("WELCOME_MESSAGE"));
        return welcomeMessage;

    }
}
