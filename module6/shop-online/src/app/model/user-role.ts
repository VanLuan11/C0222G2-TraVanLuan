import {AppUser} from './app-user';
import {AppRole} from './app-role';

export interface UserRole {
  id?: number;
  isDelete?: boolean;
  appUser?: AppUser;
  appRole?: AppRole;
}
