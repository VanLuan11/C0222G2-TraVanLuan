import {AppUser} from './app-user';

export interface Customer {
  id?: number;
  name:string;
  email:string;
  appUser: AppUser;
  isDeleted: boolean;
}
