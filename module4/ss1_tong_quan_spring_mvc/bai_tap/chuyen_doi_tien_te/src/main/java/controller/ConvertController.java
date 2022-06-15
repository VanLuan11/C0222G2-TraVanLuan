package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @GetMapping("form-convert")
    public String showConvert(){
         return "convert";

    }
    @PostMapping ("convert")
    public String  getConvert(@RequestParam int vnd, Model model){

        model.addAttribute("usd",vnd/23000);
        model.addAttribute("vnd",vnd);
        return "convert";
    }

}
