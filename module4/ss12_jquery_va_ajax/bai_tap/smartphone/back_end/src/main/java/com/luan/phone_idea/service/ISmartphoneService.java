package com.luan.phone_idea.service;


import com.luan.phone_idea.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartPhone);

    void remove(int id);
}
