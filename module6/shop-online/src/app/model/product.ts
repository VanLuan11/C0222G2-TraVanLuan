import {Category} from './category';

export interface Product {
  id?: number;
  image?: string;
  nameProduct?: string;
  price?: number;
  quantity?: number;
  dateOfManufacture?: string;
  specifications?: string;
  description?: string;
  category?: Category;
  isDeleted?: boolean;
}
