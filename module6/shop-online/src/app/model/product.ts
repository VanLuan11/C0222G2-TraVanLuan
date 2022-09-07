import {Category} from './category';
import {OrderService} from './order-service';

export interface Product {
  id?: number;
  image?: string;
  nameProduct?: string;
  price?: number;
  cpu?: string;
  hdh?: string;
  ram?: string;
  screen?: string;
  ssd?: string;
  vga?: string;
  description?: string;
  category?: Category;
  isDeleted?: boolean;
}
