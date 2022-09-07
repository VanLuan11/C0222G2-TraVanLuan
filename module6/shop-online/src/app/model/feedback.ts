import {Customer} from './customer';

export interface Feedback {
  id?: number;
  content?: string;
  rating?: number;
  feedbackDate?: string;
  customer?: Customer;
  isDeleted?: boolean;
}
