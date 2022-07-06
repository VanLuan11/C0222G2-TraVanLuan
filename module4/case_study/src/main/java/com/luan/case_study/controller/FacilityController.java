package com.luan.case_study.controller;

import com.luan.case_study.model.facility.Facility;
import com.luan.case_study.service.IFacilityTypeService;
import com.luan.case_study.service.IFacilityService;
import com.luan.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;
    @GetMapping("")
    public String show(Model model){
        model.addAttribute("listFacility",facilityService.findAll());
        return "facility/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("facility", new Facility());
        model.addAttribute("listRentType",rentTypeService.findAll());
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        return "facility/create";
    }
    @PostMapping("/create")
    public String getCreate(Facility facility){
       facilityService.save(facility);
        return "redirect:/facility/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("facility",facilityService.findById(id));
        model.addAttribute("listRentType",rentTypeService.findAll());
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        return "facility/edit";
    }
    @PostMapping("/edit")
    public String getEdit(Facility facility){
        facilityService.save(facility);
        return "redirect:/facility/";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id){
        facilityService.delete(id);
        return "redirect:/facility/";
    }
}
