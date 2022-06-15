package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dictionary {
    @GetMapping("/dictionary")
    public String showDictionary(){
        return "dictionary";
    }
}
