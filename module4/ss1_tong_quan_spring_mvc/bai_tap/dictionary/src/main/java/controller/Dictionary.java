package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IDictionaryService;

@Controller
public class Dictionary {
    @Autowired
    private static IDictionaryService iDictionaryService;

    @GetMapping("/dictionary")
    public String showDictionary() {
        return "form-dictionary";
    }

    @PostMapping("form-dictionary")
    public String Dictionary(@RequestParam String searchEnglish, Model model) {
        String value = iDictionaryService.translation(searchEnglish);
        model.addAttribute("tiengViet",value);
        model.addAttribute("english", searchEnglish);
        return "form-dictionary";
    }
}
