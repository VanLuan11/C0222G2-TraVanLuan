package com.luan.phone_idea.repository;


import com.luan.phone_idea.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
