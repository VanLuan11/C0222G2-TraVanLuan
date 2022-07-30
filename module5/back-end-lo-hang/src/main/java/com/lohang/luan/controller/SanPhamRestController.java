package com.lohang.luan.controller;

import com.lohang.luan.model.SanPham;
import com.lohang.luan.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/sanPham")
public class SanPhamRestController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("/list")
    public ResponseEntity<List<SanPham>> getAllProduct() {
        List<SanPham> productList = this.sanPhamService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
