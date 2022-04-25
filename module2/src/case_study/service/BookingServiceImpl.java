package case_study.service;

public class BookingServiceImpl implements IService{
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    @Override
    public void display() {
        System.out.println("---------------Danh sách khách hàng---------------");
        customerService.display();
        System.out.println("---------------Danh sách loại dịch vụ---------------");
        facilityService.display();

    }

    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }
}
