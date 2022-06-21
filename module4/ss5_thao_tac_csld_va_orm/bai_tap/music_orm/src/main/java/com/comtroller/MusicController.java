package com.comtroller;

import com.model.Music;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showMusic(Model model){
        model.addAttribute("listMusic",musicService.getAllMusic());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "/create";
    }
    @PostMapping("/create")
    public String getCreate( Music music){
        musicService.create(music);
        return "redirect: /music";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("music",musicService.findBy(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String getDelete(Music music ){
        musicService.delete(music.getId());
        return "redirect: /music";
    }
    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("music",musicService.findBy(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String showEdit(Music music){
        musicService.edit(music);
        return "redirect: /music";
    }
}
