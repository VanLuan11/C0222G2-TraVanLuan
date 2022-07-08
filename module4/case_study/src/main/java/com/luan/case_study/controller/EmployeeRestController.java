package com.luan.case_study.controller;

import com.luan.case_study.model.employee.Employee;
import com.luan.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employeeRest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> getPageBlog(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam Optional<String> searchValue){
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        String searchParam = searchValue.orElse("");
        Page<Employee> blogs = this.employeeService.findAllByName(searchParam ,pageable);
        if (blogs.hasContent()) {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
