package com.luan.case_study.controller;

import com.luan.case_study.service.IFacilityTypeService;
import com.luan.case_study.service.IFacilityService;
import com.luan.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class Facility {
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
        model.addAttribute("facility",new Facility());
        model.addAttribute("listRentType",rentTypeService.findAll());
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        return "facility/create";
    }
    @PostMapping("/create")
    public String getCreate(Facility facility){
       facilityService.save(facility);
        return "redirect:/facility/";
    }
}
