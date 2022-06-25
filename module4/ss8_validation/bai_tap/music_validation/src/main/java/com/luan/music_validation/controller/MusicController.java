package com.luan.music_validation.controller;

import com.luan.music_validation.dto.MusicDto;
import com.luan.music_validation.model.Music;
import com.luan.music_validation.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showMusic(Model model){
        model.addAttribute("listMusic", musicService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute @Valid MusicDto musicDto,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("music", musicDto);
            return "/create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        this.musicService.save(music);
        return "redirect:/music/";
    }

    @GetMapping("{id}/edit")
    public String showCreate(@PathVariable int id, Model model){
        model.addAttribute("music", musicService.getMusic(id));

        return "edit";
    }
    @PostMapping("/edit")
    public String getCreate(@ModelAttribute Music music){
        musicService.save(music);
        return "redirect:/music/";
    }
    @GetMapping("{id}/delete")
    public String getCreate(@PathVariable int id,Model model){
        model.addAttribute("music", musicService.getMusic(id));
        musicService.delete(id);
        return "redirect:/music/";
    }
}
