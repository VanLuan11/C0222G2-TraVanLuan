import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {LoHang} from "../../model/lo-hang";
import {LoHangService} from "../../service/lo-hang.service";
import {SanPham} from "../../model/san-pham";

@Component({
  selector: 'app-lo-hang-list',
  templateUrl: './lo-hang-list.component.html',
  styleUrls: ['./lo-hang-list.component.css']
})
export class LoHangListComponent implements OnInit {

  loHang: LoHang[] = [];
  p: number = 1;
  searchForm: FormGroup;
  idDelete: number;
  tenSanPham: string;
  ngayNhap: string;


  constructor(private loHangService: LoHangService,
              private router: Router,
              private toastr: ToastrService) {
  }

  showToastr() {
    this.toastr.success('Success!', 'Delete', {
      timeOut: 1000,
      progressBar: true,
    });
  }

  ngOnInit(): void {
    this.getAllLoHang()
    this.formSearch()
  }

  getAllLoHang() {
    this.loHangService.getAllLoHang().subscribe(data => {
      this.loHang = data;
    })
  }

  showDelete(loHang: LoHang) {
    this.idDelete = loHang.id;
    this.tenSanPham = loHang.maLoHang
    this.ngayNhap = loHang.ngayNhap
  }

  deleteLoHang(idDelete) {
    this.loHangService.deleteLoHang(idDelete).subscribe(value => {
      this.router.navigateByUrl('loHang-list').then(() => {
        this.ngOnInit()
      })
    })
  }

  formSearch() {
    this.searchForm = new FormGroup({
      searchSanPham: new FormControl(""),
      searchNgayNhap: new FormControl(""),
    });
  }

  getFormSearch() {
    this.loHangService.loHangListBySearch(this.searchForm.value.searchSanPham, this.searchForm.value.searchNgayNhap).subscribe(data => {
      this.loHang = data;
      console.log(data);
    })
  }
}
