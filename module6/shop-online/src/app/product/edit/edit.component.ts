import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {AngularFireStorage} from "@angular/fire/storage";
import {ToastrService} from "ngx-toastr";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {$} from "protractor";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  imgSrc: any;
  public Editor = ClassicEditor;
  productForm: FormGroup;
  product: Product;
  categories: Category[] = [];
  isLoading: Boolean = false;
  fileUploader: any;
  selectFileImg: any = null;

  constructor(@Inject(AngularFireStorage) private storage: AngularFireStorage,
              private productService: ProductService,
              private toastrService: ToastrService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private el: ElementRef) {
  }

  ngOnInit(): void {
  this.getByIdProduct()
  }

  getByIdProduct(){
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap)=>{
      const id = paraMap.get('id');
      this.productService.getFindById(parseInt(id)).subscribe(data=>{
        this.product = data;
        this.getAllCategory();
        this.createValidate();
      })
    })
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(d => {
      this.categories = d;
    });
  }

  createValidate() {

    this.imgSrc = this.product.image
    console.log(this.imgSrc)
    this.product.dateIn = this.product.dateIn.slice(0, 10);
    this.productForm = new FormGroup({
      id: new FormControl(this.product.id, [Validators.required]),
      name: new FormControl(this.product.name, [Validators.required]),
      price: new FormControl(this.product.price, [Validators.required]),
      image: new FormControl(this.product.image, [Validators.required]),
      manufacturer: new FormControl(this.product.manufacturer, [Validators.required]),
      quantity: new FormControl(this.product.quantity, [Validators.required]),
      dateIn: new FormControl(this.product.dateIn, [Validators.required]),
      category: new FormControl(this.product.category, [Validators.required]),
      discount: new FormControl(this.product.discount, [Validators.required]),
      guaranteeTime: new FormControl(this.product.guaranteeTime, [Validators.required]),
      description: new FormControl(this.product.description, [Validators.required]),
      specification: new FormControl(this.product.specification, [Validators.required]),
      isDeleted: new FormControl(this.product.isDeleted)
    });
  }

  editSave() {
    let product: Product = this.productForm.value;
    if(this.selectFileImg == null){
      if (this.productForm.valid) {
        this.productService.updateProduct(product).subscribe((data) => {
          this.toastrService.success('Cập nhật', 'Thông báo!!!')
          this.router.navigateByUrl('/home').then();
        });
      }
    }else{
      const nameImg = this.getCurrentDateTime() + this.selectFileImg.name;
      const fileRel = this.storage.ref(nameImg);
      this.storage.upload(nameImg, this.selectFileImg).snapshotChanges().pipe(finalize(() => {
        fileRel.getDownloadURL().subscribe((url) => {
          this.productForm.patchValue({image: url});
          this.productService.updateProduct(this.productForm.value).subscribe(d => {
             this.toastrService.success('Đã thay đổi thành công');
            this.router.navigateByUrl('/home').then()
          });
        });
      })).subscribe();
    }
  }

  compareCategory(c1: Category, c2: Category): boolean {
    if ((c1 && c2) != undefined) {
      return c1.id === c2.id;
    }
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ssa', 'en-US');
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (o: any) => this.imgSrc = o.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectFileImg = event.target.files[0];
      document.getElementById('img').style.display = 'block';
    } else {
      this.imgSrc = '';
      this.selectFileImg = null;
    }
  }



}
