import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {
  product: Product;

  constructor(private productService: ProductService,
              private toast: ToastrService,
              private title: Title,
              private active: ActivatedRoute,
              private router: Router) {
    this.title.setTitle("Chi Tiết Sản Phẩm")
  }

  ngOnInit(): void {
    this.getById()
  }


  getById(){
    this.active.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id')
      this.productService.getFindById(id).subscribe(data => {
        // @ts-ignore
        this.product = data;
        if(data == null){
          this.toast.error("Không có  sản phẩm này",'Thông Báo!')
          this.router.navigateByUrl("/home").then()
        }
      })
    })
  }
}
