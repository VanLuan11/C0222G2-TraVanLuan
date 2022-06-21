package com.comtroller;


import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class  ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showMusic(Model model){
        model.addAttribute("listProduct",iProductService.getAllProduct());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String getCreate(Product product){
        iProductService.create(product);
        return "redirect: /product";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findBy(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String getDelete(Product product){
        iProductService.delete(product.getId());
        return "redirect: /product";
    }
    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findBy(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String showEdit(Product product){
        iProductService.edit(product);
        return "redirect: /product";
    }
}
