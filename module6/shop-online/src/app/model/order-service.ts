import {Customer} from './customer';
import {Product} from './product';

export interface OrderService {
  id?: number;
  creationDate?: string;
  quantity?: number;
  isDeleted?: boolean;
  customer?: Customer;
  product?: Product
}
