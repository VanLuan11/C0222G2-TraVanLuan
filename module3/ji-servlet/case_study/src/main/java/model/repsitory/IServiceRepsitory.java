package model.repsitory;


import model.model.service.RentType;
import model.model.service.Service;
import model.model.service.ServiceType;

import java.util.List;

public interface IServiceRepsitory {
    List<Service> getALlService();

    List<ServiceType> getAllServiceType();

    List<RentType> getAllRentType();

    void create(Service service);
}
