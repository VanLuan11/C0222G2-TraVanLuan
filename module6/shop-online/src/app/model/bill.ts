import {Feedback} from "./feedback";
import {Product} from "./product";

export interface Bill {
  id?: number,
  code?: number;
  creationDate?: string;
  isDeleted?: boolean;
}
