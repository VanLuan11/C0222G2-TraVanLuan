import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {LoHang} from "../../model/lo-hang";
import {LoHangService} from "../../service/lo-hang.service";

@Component({
  selector: 'app-lo-hang-list',
  templateUrl: './lo-hang-list.component.html',
  styleUrls: ['./lo-hang-list.component.css']
})
export class LoHangListComponent implements OnInit {

  loHang: LoHang[] = [];
  searchForm: FormGroup;
  idDelete: number;
  tenSanPham: string;
  ngayNhap: string;
  number: number;
  totalPages: number;
  countTotalPages: number[];

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
    this.getAll(0, '', '', '1000-01-01', '8000-01-01');
    this.searchForm = new FormGroup({
      searchName: new FormControl(),
      searchDateCheckOut: new FormControl(),
      searchStartDate: new FormControl(),
      searchEndDate: new FormControl()
    });
  }

  getAll(page: number, searchName, searchDateCheckOut, searchStartDate, searchEndDate) {
    this.loHangService.getAll(page, searchName, searchDateCheckOut, searchStartDate, searchEndDate).subscribe((data: LoHang[]) => {
        if (data != null) {
          // @ts-ignore
          this.consignment = data.content;
        } else {
          this.loHang = [];
        }
        if (this.loHang.length !== 0) {
          // @ts-ignore
          this.totalPages = data.totalPages;
          // @ts-ignore
          this.countTotalPages = new Array(data.totalPages);
          // @ts-ignore
          this.number = data.number;
        }
      });
  }

  getSearch() {
    const productName = this.searchForm.value.searchName;
    const dateCheckOut = this.searchForm.value.searchDateCheckOut;
    const startDate = this.searchForm.value.searchStartDate;
    const endDate = this.searchForm.value.searchEndDate;
    this.getAll(0, productName, dateCheckOut, startDate, endDate);
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

  // goPrevious() {
  //   let numberPage: number = this.number;
  //   if (numberPage > 0) {
  //     numberPage--;
  //     this.getAll(numberPage);
  //   }
  // }
  //
  // goNext() {
  //   let numberPage: number = this.number;
  //   if (numberPage < this.totalPages - 1) {
  //     numberPage++;
  //     this.getAll(numberPage);
  //   }
  // }
  //
  // goItem(i: number) {
  //   this.getAll(i);
  // }
}
