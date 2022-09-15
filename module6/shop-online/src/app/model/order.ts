import {Customer} from './customer';
import {Product} from './product';
import {Bill} from "./bill";

export interface Order {
  id?: number;
  quantity?: number;
  isDeleted?: boolean;
  bill?: Bill;
  product?: Product;
  customer?: Customer;
  totalMoney?: number;
}
