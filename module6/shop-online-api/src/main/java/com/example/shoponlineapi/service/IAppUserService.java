package com.example.shoponlineapi.service;




import com.example.shoponlineapi.model.account.AppUser;

import java.util.List;

public interface IAppUserService {

    /**
     * @param
     * @return AppUser list
     * @creator TaiLV
     * Date 09/08/2022
     */
    List<AppUser> getAllUser();

    AppUser findAppUserByUserName(String userName);

    void saveAppUser(AppUser appUser);


}
