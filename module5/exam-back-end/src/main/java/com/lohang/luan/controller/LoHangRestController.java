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

import java.util.List;
import java.util.Optional;


@RequestMapping("/rest/loHang")
@RestController
@CrossOrigin
public class LoHangRestController {

    @Autowired
    private ILoHangService loHangService;


    @GetMapping("/page")
    public ResponseEntity<Page<LoHang>> getAllConsignment(@PageableDefault(5)Pageable pageable,
                                                               @RequestParam Optional<String> searchName,
                                                               @RequestParam Optional<String> searchDateCheckOut,
                                                               @RequestParam Optional<String> searchStartDate,
                                                               @RequestParam Optional<String> searchEndDate){
        String productName = searchName.orElse("");
        String dateCheckOut = searchDateCheckOut.orElse("");
        String startDate = searchStartDate.orElse("1000-01-01");
        String endDate = searchEndDate.orElse("8000-01-01");
        Page<LoHang> consignmentPage = loHangService.findAll(pageable,productName,dateCheckOut,startDate,endDate);
        if(consignmentPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(consignmentPage,HttpStatus.OK);
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LoHang> findByName(@PathVariable Integer id) {
        LoHang consignment = this.loHangService.findById(id);
        return new ResponseEntity<>(consignment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createConsignment(@RequestBody LoHang loHang) {
        this.loHangService.save(loHang);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<Void> deleteConsignment(@PathVariable Integer idDelete) {
        this.loHangService.delete(idDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateConsignment(@RequestBody LoHang loHang) {
        this.loHangService.save(loHang);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
