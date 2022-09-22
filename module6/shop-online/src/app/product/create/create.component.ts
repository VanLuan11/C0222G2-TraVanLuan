import {Component, ElementRef, Inject, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {AngularFireStorage} from "@angular/fire/storage";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

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
              private el: ElementRef) {
  }

  ngOnInit(): void {
    this.createValidate();
    this.getAllCategory();
  }

  createValidate() {
    this.productForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
      manufacturer: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      dateIn: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
      discount: new FormControl('', [Validators.required]),
      guaranteeTime: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      specification: new FormControl('', [Validators.required]),
      isDeleted: new FormControl(0)
    });
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(d => {
      this.categories = d;
      this.createValidate();
    });
  }

  save() {
    const nameImg = this.getCurrentDateTime() + this.selectFileImg.name;
    const fileRel = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectFileImg).snapshotChanges().pipe(finalize(() => {
      fileRel.getDownloadURL().subscribe((url) => {
        this.productForm.patchValue({image: url});
        this.productService.createProduct(this.productForm.value).subscribe(d => {

          this.toastrService.success('Đã thêm mới');
          this.router.navigateByUrl('/home').then()
        });
      });
    })).subscribe();
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
