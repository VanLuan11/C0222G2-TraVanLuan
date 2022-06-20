package com.comtroller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String shoProduct(Model model) {
        model.addAttribute("productList", iProductService.getAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String getCreate(Product product) {
        iProductService.create(product);
        return "redirect: /product";
    }

    @GetMapping("{id}/delete")
    public String deletePage(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findBy(id));
        return "/delete";
    }

    @GetMapping("/delete")
    public String deleteProduct(Product product){
        iProductService.delete(product.getId());
        return "redirect: /product";
    }
    @GetMapping("{id}/view")
    public String viewPage(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findBy(id));
        return "/view";
    }
    @GetMapping("{id}/edit")
    public String editPage(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findBy(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editPage(Product product){
        System.out.println(product.getId());
        iProductService.edit(product.getId(), product);
        return "redirect: /product";
    }
}
