import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoHang} from "../model/lo-hang";
import {SanPham} from "../model/san-pham";

@Injectable({
  providedIn: 'root'
})
export class LoHangService {

  private URL_LOHANG = "http://localhost:8080/rest/loHang";
  private URL_SANPHAM = "http://localhost:8080/rest/sanPham";

  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number, searchName, searchDateCheckOut, searchStartDate, searchEndDate) {
    let productName;
    let dateCheckOut;
    let startDate;
    let endDate;
    if (searchName == null) {
      productName = '';
    } else {
      productName = searchName;
    }
    if (searchDateCheckOut == null) {
      dateCheckOut = '';
    } else {
      dateCheckOut = searchDateCheckOut;
    }

    if (searchStartDate == null) {
      startDate = '1000-01-01';
    } else {
      startDate = searchStartDate;
    }

    if (searchEndDate == null) {
      endDate = '8000-01-01';
    } else {
      endDate = searchEndDate;
    }
    return this.httpClient.get<LoHang[]>(this.URL_LOHANG + '/page?page=' + page + '&searchName=' + productName +
      '&searchDateCheckOut=' + dateCheckOut + '&searchStartDate=' + startDate + '&searchEndDate=' + endDate);
  }

  getAllSanPham(): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(this.URL_SANPHAM)
  }

  saveLoHang(loHang: LoHang) {
    return this.httpClient.post(this.URL_LOHANG+ "/create", loHang)
  }

  findById(id: number): Observable<LoHang> {
    return this.httpClient.get(this.URL_LOHANG + '/find/' + id)
  }

  editLoHang(loHang: LoHang): Observable<LoHang> {
    return this.httpClient.patch(this.URL_LOHANG + '/update', loHang)
  }

  deleteLoHang(idDelete: number): Observable<LoHang> {
    return this.httpClient.delete(this.URL_LOHANG + '/delete/' + idDelete);
  }

}
