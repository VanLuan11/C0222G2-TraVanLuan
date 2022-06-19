package com.controller;

import com.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MusicController {
    @GetMapping("/music")
    public String showMusic(Model model){
        model.addAttribute("music",new  Music());
        return "music-form";
    }
    @PostMapping("/music")
    public String getEmail(@ModelAttribute Music music, Model model) {
        model.addAttribute("music", music);
        return "music-form";
    }
}
