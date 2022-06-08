package model.service.impl;

import model.model.service.Service;
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
}
