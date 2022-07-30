import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoHang} from "../model/lo-hang";
import {SanPham} from "../model/san-pham";

@Injectable({
  providedIn: 'root'
})
export class LoHangService {

  private URL_LOHANG = "http://localhost:8080/rest/loHang/list";
  private URL_SANPHAM = "http://localhost:8080/rest/sanPham/list";

  constructor(private httpClient: HttpClient) {
  }

  getAllLoHang(): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>(this.URL_LOHANG);
  }

  getAllSanPham(): Observable<SanPham[]> {
    return this.httpClient.get<SanPham[]>(this.URL_SANPHAM)
  }

  saveLoHang(loHang: LoHang) {
    return this.httpClient.post(this.URL_LOHANG, loHang)
  }

  findById(id: number): Observable<LoHang> {
    return this.httpClient.get(this.URL_LOHANG + '/' + id)
  }

  editLoHang(loHang: LoHang): Observable<LoHang> {
    return this.httpClient.patch(this.URL_LOHANG + '/' + loHang.id, loHang)
  }

  deleteLoHang(idDelete: number): Observable<LoHang> {
    return this.httpClient.delete(this.URL_LOHANG + '/' + idDelete);
  }

  loHangListBySearch(searchSanPham: string, searchNgayNhap: string): Observable<LoHang[]> {
    return this.httpClient.get<LoHang[]>(this.URL_LOHANG + "?sanPham.tenSanPham_like=" + searchSanPham + "&ngayNhap_like=" + searchNgayNhap);
  }
}
