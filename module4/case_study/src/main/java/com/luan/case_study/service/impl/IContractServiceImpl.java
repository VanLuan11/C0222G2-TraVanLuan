package com.luan.case_study.service.impl;

import com.luan.case_study.dto.ContractDto;
import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.model.contract.ContractDetail;
import com.luan.case_study.repository.ContractRepository;
import com.luan.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class IContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllByName(String keywordVal, Pageable pageable) {
        return contractRepository.findAllByName("%"+keywordVal+"%", pageable);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Page<ContractDto> getAllContract(String keywordVal, Pageable pageable) {
        Page<Contract> contractPage = this.contractRepository.findAllByName("%"+ keywordVal +"%", pageable);
        List<ContractDto> contractDtoList = new ArrayList<>();
        Page<ContractDto> contractDtoPage ;
        for (int i = 0; i < contractPage.getContent().size(); i++) {
            int total = 0;
            for (ContractDetail contractDetail: contractPage.getContent().get(i).getContractDetails()) {
                total += contractDetail.getContract().getFacility().getCost() + contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
            }
            ContractDto contractDto = new ContractDto(contractPage.getContent().get(i).getId(),
                    contractPage.getContent().get(i).getStartDate(),
                    contractPage.getContent().get(i).getEndDate(),
                    contractPage.getContent().get(i).getDeposit(),
                    contractPage.getContent().get(i).getCustomer(),
                    contractPage.getContent().get(i).getEmployee(),
                    contractPage.getContent().get(i).getFacility(),
                    contractPage.getContent().get(i).getContractDetails(),
                    total);
            contractDtoList.add(contractDto);
        }
        contractDtoPage = new PageImpl<>(contractDtoList,contractPage.getPageable(),contractPage.getTotalElements());
        return contractDtoPage;
    }

    @Override
    public Page<Contract> findAllCustomerUsingService(Pageable pageable) {
        return contractRepository.findAllCustomerUsingService(pageable);
    }
}
