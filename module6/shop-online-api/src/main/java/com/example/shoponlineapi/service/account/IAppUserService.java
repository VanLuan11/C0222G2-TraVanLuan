package com.example.shoponlineapi.service.account;


import com.example.shoponlineapi.model.account.AppUser;

public interface IAppUserService {

    AppUser findAppUserByUserName(String username);

    void updatePassword(AppUser appUser);


}
