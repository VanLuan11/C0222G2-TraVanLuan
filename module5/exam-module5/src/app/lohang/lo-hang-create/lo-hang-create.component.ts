import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {SanPham} from "../../model/san-pham";
import {LoHang} from "../../model/lo-hang";
import {LoHangService} from "../../service/lo-hang.service";

@Component({
  selector: 'app-lo-hang-create',
  templateUrl: './lo-hang-create.component.html',
  styleUrls: ['./lo-hang-create.component.css']
})
export class LoHangCreateComponent implements OnInit {

  sanPham: SanPham[] = [];
  loHangFormCreate: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private loHangService: LoHangService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.createValidate()
  }

  createValidate() {
    this.loHangService.getAllSanPham().subscribe(data => {
      this.sanPham = data;
    }, error => {
    }, () => {
      this.loHangFormCreate = new FormGroup({
        maLoHang: new FormControl('',[Validators.required,Validators.pattern(/^LH\-[0-9]{4}/)]),
        sanPham: new FormControl('',[Validators.required]),
        soLuong: new FormControl('',[Validators.required, Validators.pattern(/^[0-9]{0,}$/)]),
        ngayNhap: new FormControl('',[Validators.required]),
        ngaySanXuat: new FormControl('',[Validators.required]),
        ngayHetHan: new FormControl('',[Validators.required])
      })
    })
  }

  create() {
    console.log(this.loHangFormCreate.value);
    if (this.loHangFormCreate.valid) {
      this.loHangService.saveLoHang(this.loHangFormCreate.value).subscribe(data => {
        this.showToastr();
        this.router.navigateByUrl("loHang-list").then(() => {
        })
      })
    }
  }

  showToastr() {
    this.toastr.success('Success!', 'Create', {
      timeOut:1000,
      progressBar: true,
    });
  }
}
