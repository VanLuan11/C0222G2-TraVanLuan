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
  submit = false;

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
    if (this.loHangFormCreate.valid) {
      this.submit= false;
      this.loHangService.saveLoHang(this.loHangFormCreate.value).subscribe(data => {
        this.showToastr();
        this.router.navigateByUrl("loHang-list").then(() => {
        })
      })
    }else {
      this.submit = true;
    }
  }


  showToastr() {
    if (this.loHangFormCreate.valid){
      this.submit= false;
      this.toastr.success('Success!', 'Create', {
        timeOut:1000,
        progressBar: true,
      });
    }else{
      this.toastr.error('Submit fail!','Create',{
        timeOut:1000,
        progressBar: true,
      })
    }
  }

  getMaLoHang(){
    return this.loHangFormCreate.controls.maLoHang;
  }
  getSanPham(){
    return this.loHangFormCreate.controls.sanPham;
  }
  getSoLuong(){
    return this.loHangFormCreate.controls.soLuong;
  }
  getNgayNhap(){
    return this.loHangFormCreate.controls.ngayNhap;
  }
  getNgaySanXuat(){
    return this.loHangFormCreate.controls.ngaySanXuat;
  }
  getNgayHetHan(){
    return this.loHangFormCreate.controls.ngayHetHan;
  }
}
