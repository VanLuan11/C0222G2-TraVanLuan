package com.example.shoponlineapi.service.impl;



import com.example.shoponlineapi.model.account.AppUser;
import com.example.shoponlineapi.repository.IAppUserRepository;
import com.example.shoponlineapi.service .IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository IAppUserRepository;

    /**
     * @param
     * @return AppUser list
     * @creator TaiLV
     * Date 09/08/2022
     */

    @Override
    public List<AppUser> getAllUser() {
        return IAppUserRepository.findAllUser();
    }

    @Override
    public AppUser findAppUserByUserName(String userName) {
        return IAppUserRepository.findAppUserByUserName(userName);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        IAppUserRepository.saveAppUser(appUser);
    }


}
