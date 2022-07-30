import {SanPham} from "./san-pham";

export interface LoHang {
  id?:number;
  maLoHang?:string;
  sanPham?: SanPham;
  soLuong?:number;
  ngayNhap?: string;
  ngaySanXuat?:string;
  ngayHetHan?:string;
}
