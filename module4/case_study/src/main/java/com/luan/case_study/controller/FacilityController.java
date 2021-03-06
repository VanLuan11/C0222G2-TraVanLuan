package com.luan.case_study.controller;

import com.luan.case_study.dto.FacilityDto;
import com.luan.case_study.model.facility.Facility;
import com.luan.case_study.service.IFacilityTypeService;
import com.luan.case_study.service.IFacilityService;
import com.luan.case_study.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.Optional;

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
    public String show(Model model,
                       @PageableDefault(value = 3)Pageable pageable,
                       @RequestParam(name = "keyword") Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("listFacility", this.facilityService.findAllByName(keywordVal, pageable));
        return "facility/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("listRentType",rentTypeService.findAll());
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        return "facility/create";
    }
    @PostMapping("/create")
    public String getCreate(@ModelAttribute @Validated FacilityDto facilityDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("listRentType",rentTypeService.findAll());
            model.addAttribute("listFacilityType",facilityTypeService.findAll());
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        redirectAttributes.addFlashAttribute("msg",
                "???? th??m m???i th??nh c??ng  !");
       facilityService.save(facility);
        return "redirect:/facility/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        Facility facility = this.facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("listRentType",rentTypeService.findAll());
        model.addAttribute("listFacilityType",facilityTypeService.findAll());
        return "facility/edit";
    }
    @PostMapping("/edit")
    public String getEdit(@ModelAttribute @Validated FacilityDto facilityDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("listRentType",rentTypeService.findAll());
            model.addAttribute("listFacilityType",facilityTypeService.findAll());
            return "facility/edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        redirectAttributes.addFlashAttribute("msg",
                "Ch???nh s???a th??nh c??ng th??nh !");
        facilityService.save(facility);
        return "redirect:/facility/";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg",
                "???? xo?? th??nh c??ng !");
        facilityService.deleteById(id);
        return "redirect:/facility/";
    }
}
