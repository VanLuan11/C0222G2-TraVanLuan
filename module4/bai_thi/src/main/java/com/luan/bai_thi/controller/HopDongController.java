package com.luan.bai_thi.controller;


import com.luan.bai_thi.model.HopDong;
import com.luan.bai_thi.service.IHopDongService;
import com.luan.bai_thi.service.IPhongTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HopDongController {

    @Autowired
    private IHopDongService hopDongService;

    @Autowired
    private IPhongTroService phongTroService;


    @GetMapping("")
    public String show(Model model){
        model.addAttribute("listHopDong",hopDongService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("hopDong", new HopDong());
        model.addAttribute("listPhongTro",phongTroService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String getCreate(@ModelAttribute HopDong hopDong,
                            RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "Đã thêm mới thành công !");
        hopDongService.save(hopDong);
        return "redirect:/home/";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "Đã xoá thành công !");
        hopDongService.deleteById(id);
        return "redirect:/home/";
    }
}
