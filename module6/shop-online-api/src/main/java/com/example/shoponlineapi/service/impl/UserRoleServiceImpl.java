package com.example.shoponlineapi.service.impl;


import com.example.shoponlineapi.model.account.UserRole;
import com.example.shoponlineapi.repository.IUserRoleRepository;
import com.example.shoponlineapi.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole);
    }
}
