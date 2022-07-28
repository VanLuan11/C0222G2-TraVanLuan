import {CustomerType} from "./customer-type";

export interface Customer {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  gender?: number;
  customerType?: CustomerType;
  address?: string;
}
