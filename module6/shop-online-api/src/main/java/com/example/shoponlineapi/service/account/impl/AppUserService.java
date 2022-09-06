package com.example.shoponlineapi.service.account.impl;


import com.example.shoponlineapi.model.account.AppUser;
import com.example.shoponlineapi.repository.IAppUserRepository;
import com.example.shoponlineapi.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository IAppUserRepository;

    /**
     * @param username
     * @return
     * @Creator PhuongTD
     * @date-create 9/8/2022
     */
    @Override
    public AppUser findAppUserByUserName(String username) {
        return this.IAppUserRepository.findAppUserByUserName(username);
    }

    /**
     * @param appUser
     * @creator: PhuongTD
     * @date-create 9/8/2022
     */
    @Override
    public void updatePassword(AppUser appUser) {
        this.IAppUserRepository.updatePassword(appUser);
    }
}
