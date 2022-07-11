package com.luan.case_study.repository;

import com.luan.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where `start_date` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from contract where `start_date` like :keyword and `status` = 0) hop_dong")
    Page<Contract> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);




    @Query(value = "select ct.* from contract ct " +
            "  join customer c on ct.customer_id = c.id " +
            "  join facility fa on ct.facility_id = fa.id " +
            "  join contract_detail dct on dct.contract_id = ct.id " +
            "  join attach_facility afa on dct.attach_facility_id = afa.id " +
            " group by c.id , fa.id ",nativeQuery = true,
            countQuery = " select count(*) from (select c.* from customer c " +
                    "           join contract ct on ct.customer_id = c.id " +
                    "           join facility fa on ct.facility_id = fa.id " +
                    "           join contract_detail dct on dct.contract_id = ct.id " +
                    "           join attach_facility afa on dct.attach_facility_id = afa.id " +
                    " group  by c.id, fa.id ) temp_table"
    )
    Page<Contract> findAllCustomerUsingService(Pageable pageable);
}
