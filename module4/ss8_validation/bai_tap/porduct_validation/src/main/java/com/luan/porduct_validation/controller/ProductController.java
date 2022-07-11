package com.luan.porduct_validation.controller;

import com.luan.porduct_validation.dto.ProductDto;
import com.luan.porduct_validation.model.Product;
import com.luan.porduct_validation.service.IManufacturerService;
import com.luan.porduct_validation.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IManufacturerService manufacturerService;

    @GetMapping("")
    public String showProduct(Model model,
                              @PageableDefault(value = 2) Pageable pageable,
                              @RequestParam(name = "keyword")Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("listProduct", productService.findAllByName(keywordVal,pageable));
        return "list";
    }
    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("listManufacturer", manufacturerService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String showCreate(@ModelAttribute @Validated ProductDto productDto,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("productDto", productDto);
            model.addAttribute("listManufacturer", manufacturerService.findAll());
            return "/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        this.productService.save(product);
        return "redirect:/product/";
    }

    @GetMapping("{id}/edit")
    public String showCreate(@PathVariable int id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("listManufacturer", manufacturerService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String getCreate(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product/";
    }
    @GetMapping("{id}/delete")
    public String getCreate(@PathVariable int id,Model model){
        model.addAttribute("product", productService.getProduct(id));
        productService.delete(id);
        return "redirect:/product/";
    }
}
