package model.service.impl;

import model.model.service.RentType;
import model.model.service.Service;
import model.model.service.ServiceType;
import model.repsitory.IServiceRepsitory;
import model.repsitory.impl.ServiceRepsitoryImpl;
import model.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private static IServiceRepsitory iServiceRepsitory = new ServiceRepsitoryImpl();
    @Override
    public List<Service> getALlService() {
        return iServiceRepsitory.getALlService();
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        return iServiceRepsitory.getAllServiceType();
    }

    @Override
    public List<RentType> getAllRentType() {
        return iServiceRepsitory.getAllRentType();
    }

    @Override
    public void create(Service service) {
        iServiceRepsitory.create(service);
    }
}
