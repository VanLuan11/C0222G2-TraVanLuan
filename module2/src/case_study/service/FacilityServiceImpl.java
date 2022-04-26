package case_study.service;

import case_study.common.validate.ValidateFacility;
import case_study.model.Facility;
import case_study.model.House;
import case_study.model.Room;
import case_study.model.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
        static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        static Scanner scanner = new Scanner(System.in);
    static {
        // id,Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ),Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.
        facilityMap.put(new Villa("SVVL","Villa1",1000,1000,10,"1 tháng","normal",100,1),0);
        facilityMap.put(new Villa("SVVL","Villa2",1000,2000,20,"2 tháng","medium",200,2),0);
        facilityMap.put(new Villa("SVVL","Villa3",3000,3000,30,"3 tháng","vip",300,3),0);

        // id,Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ),Tiêu chuẩn phòng, Số tầng.
        facilityMap.put(new House("SVHO","House1",300,500,4,"4 tháng","normal",1),0);
        facilityMap.put(new House("SVHO","House2",600,1000,8,"8 tháng","medium",2),0);
        facilityMap.put(new House("SVHO","House3",900,1500,12,"12 tháng","vip",3),0);

        // id,Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ),Dịch vụ miễn phí đi kèm.
        facilityMap.put(new Room("SVRO","House1",200,100,2,"1 tuần","free room service"),0);
        facilityMap.put(new Room("SVRO","House2",400,200,4,"2 tuần","free food"),0);
        facilityMap.put(new Room("SVRO","House3",600,300,6,"3 tuần","free cheap service"),0);
    }
    @Override
    public void display() {
        for (Map.Entry<Facility,Integer> element : facilityMap.entrySet()) {
            System.out.println(element);
        }
        System.out.println();
    }

    @Override
    public void displayListFacilityMaintenance() {


    }

    @Override
    public void addVilla() {
        System.out.println("---------------ADD MEW VILLA---------------");
        System.out.print("Thên mới id: ");
        String codeService = scanner.nextLine();
        while (!ValidateFacility.isMatchesFacilityVila(String.valueOf(codeService ))){
            System.out.println("Quý khách nhập không đúng định dạng dịch vụ!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService  = scanner.nextLine();
        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();


        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();

        System.out.print("Thên mới tiêu chuẩn villa : ");
        String tieuChuan = scanner.nextLine();

        System.out.print("Thên mới diện tích hô bơi: ");
        Integer dienTichHoBoi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới số tầng: ");
        Integer soTang = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(codeService ,dichVu,dienTich,chiPhi,soLuongNguoi,kieuThue,tieuChuan,dienTichHoBoi,soTang);
        facilityMap.put(villa,0);

    }

    @Override
    public void addHouse() {
        System.out.println("---------------ADD MEW HOUSE---------------");
        System.out.print("Thên mới id: ");
        String codeService  = scanner.nextLine();
        while (!ValidateFacility.isMatchesFacilityHouse(String.valueOf(codeService))){
            System.out.println("Quý khách nhập không đúng định dạng dịch vụ!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService  = scanner.nextLine();
        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();


        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();

        System.out.print("Thên mới tiêu chuẩn villa : ");
        String tieuChuan = scanner.nextLine();

        System.out.print("Thên mới số tầng: ");
        Integer soTang = Integer.parseInt(scanner.nextLine());
        House house = new House(codeService ,dichVu,dienTich,chiPhi,soLuongNguoi,kieuThue,tieuChuan,soTang);
        facilityMap.put(house,0);

    }

    @Override
    public void addRoom() {
        System.out.println("---------------ADD MEW ROOM---------------");
        System.out.print("Thên mới id: ");
        String codeService  = scanner.nextLine();
        while (!ValidateFacility.isMatchesFacilityRoom(String.valueOf(codeService ))){
            System.out.println("Quý khách nhập không đúng định dạng dịch vụ!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService  = scanner.nextLine();
        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();

        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();

        System.out.print("Thên mới tiêu chuẩn villa : ");
        String tieuChuan = scanner.nextLine();

        System.out.print("Thên mới dịch vụ miễn phí: ");
        String dichVufree = scanner.nextLine();
        Room room = new Room(codeService ,dichVu,dienTich,chiPhi,soLuongNguoi,kieuThue,tieuChuan,dichVufree);
        facilityMap.put(room,0);

    }

}
