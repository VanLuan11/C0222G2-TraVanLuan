package com.lohang.luan.controller;

import com.lohang.luan.model.LoHang;
import com.lohang.luan.service.ILoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/rest/loHang")
@RestController
@CrossOrigin
public class LoHangController {

    @Autowired
    private ILoHangService loHangService;


    @GetMapping("/list")
    public ResponseEntity<Page<LoHang>> getAllConsignment(@PageableDefault(5) Pageable pageable) {
        Page<LoHang> consignmentPage = this.loHangService.findAll(pageable);
        if (consignmentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(consignmentPage, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LoHang> findByName(@PathVariable Integer id) {
        LoHang consignment = this.loHangService.findById(id);
        return new ResponseEntity<>(consignment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createConsignment(@RequestBody LoHang consignment) {
        this.loHangService.save(consignment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<Void> deleteConsignment(@PathVariable Integer idDelete) {
        this.loHangService.delete(idDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateConsignment(@RequestBody LoHang consignment) {
        this.loHangService.save(consignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
