package com.controller;

import com.service.Impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.IDictionaryService;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryServiceImpl;

    @GetMapping("/dictionary")
    public String showDictionary() {
        return "form-dictionary";
    }

    @PostMapping("/form-dictionary")
    public String dictionaryEnglish(@RequestParam String english, Model model) {
        String value = dictionaryServiceImpl.translation (english);
        model.addAttribute("tiengViet",value);
        model.addAttribute("english",english);
        return "form-dictionary";
    }
}
