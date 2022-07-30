import {Component, OnInit} from '@angular/core';
import {LoHang} from "../../model/lo-hang";
import {ActivatedRoute, Router} from "@angular/router";
import {LoHangService} from "../../service/lo-hang.service";
import {Toast, ToastrService} from "ngx-toastr";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SanPham} from "../../model/san-pham";

@Component({
  selector: 'app-lo-hang-edit',
  templateUrl: './lo-hang-edit.component.html',
  styleUrls: ['./lo-hang-edit.component.css']
})
export class LoHangEditComponent implements OnInit {
  loHangFormEdit: FormGroup;
  loHang: LoHang = {}
  sanPham: SanPham[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private loHangService: LoHangService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getLoHangFindById()

  }

  getLoHangFindById() {
    this.activatedRoute.paramMap.subscribe(value => {
      const idEdit = +value.get('id');
      this.loHangService.findById(idEdit).subscribe(loHang => {
        this.loHangService.getAllSanPham().subscribe(sanPham => {
          this.sanPham = sanPham
        }, error => {
        }, () => {
          this.loHangFormEdit = new FormGroup({
            id: new FormControl(loHang.id),
            maLoHang: new FormControl(loHang.maLoHang, [Validators.required, Validators.pattern(/^LH\-[0-9]{4}/)]),
            sanPham: new FormControl(loHang.sanPham, [Validators.required]),
            soLuong: new FormControl(loHang.soLuong, [Validators.required, Validators.pattern(/^[0-9]{0,}$/)]),
            ngayNhap: new FormControl(loHang.ngayNhap, [Validators.required]),
            ngaySanXuat: new FormControl(loHang.ngaySanXuat, [Validators.required]),
            ngayHetHan: new FormControl(loHang.ngayHetHan, [Validators.required])
          })
        })
      })
    })
  }

  edit() {
    if (this.loHangFormEdit.valid) {
      this.loHangService.editLoHang(this.loHangFormEdit.value).subscribe(value => {
        this.showToastr()
        this.router.navigateByUrl('loHang-list').then(() =>{

        } )
      })
    }
  }

  compareSanPham(c1: SanPham, c2: SanPham): boolean {
    if ((c1 && c2) != undefined) {
      console.log(c1.id === c2.id);
      return c1.id === c2.id;
    }
  }

  showToastr() {
    this.toastr.success('Success!', 'Update', {
      timeOut: 1000,
      progressBar: true,
    });
  }
}
