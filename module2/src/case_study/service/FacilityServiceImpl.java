package case_study.service;

import case_study.common.validate.ValidateFacility;
import case_study.model.Facility;
import case_study.model.House;
import case_study.model.Room;
import case_study.model.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    static List<Villa> villas = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
    static List<Room> rooms = new ArrayList<>();

    static {

        Villa villa = new Villa("SVVL", "Villa1", 1000, 1000, 10, "1 tháng", "normal", 100, 1);
        House house = new House("SVHO", "House1", 300, 500, 4, "4 tháng", "normal", 1);
        Room room = new Room("SVRO", "House1", 200, 100, 2, "1 tuần", "free room service");

        villas.add(villa);
        houses.add(house);
        rooms.add(room);

        facilityMap.put(villa,5);
        facilityMap.put(house,9);
        facilityMap.put(room,4);
    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityMap.entrySet()) {
            System.out.println(element);
        }
        System.out.println();
    }

    @Override
    public void displayListFacilityMaintenance() {
        for (Facility key : facilityMap.keySet()) {
            if (facilityMap.get(key) > 4) {
                System.out.println(key + ";" + facilityMap.get(key));
            }
        }
    }

    @Override
    public void addVilla() {
        System.out.println("---------------ADD MEW VILLA---------------");
        System.out.print("Thên mới mã dịch vụ: ");
        String codeService = scanner.nextLine();
        while (!ValidateFacility.Vila(String.valueOf(codeService))) {
            System.out.println("Quý khách nhập không đúng định dạng!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService = scanner.nextLine();
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
        Villa villa = new Villa(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, dienTichHoBoi, soTang);
        facilityMap.put(villa, 0);

    }

    @Override
    public void addHouse() {
        System.out.println("---------------ADD MEW HOUSE---------------");
        System.out.print("Thên mới mã dịch vụ: ");
        String codeService = scanner.nextLine();
        while (!ValidateFacility.House(String.valueOf(codeService))) {
            System.out.println("Quý khách nhập không đúng định dạng!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService = scanner.nextLine();
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
        House house = new House(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, soTang);
        facilityMap.put(house, 0);

    }

    @Override
    public void addRoom() {
        System.out.println("---------------ADD MEW ROOM---------------");
        System.out.print("Thên mới mã dịch  vụ: ");
        String codeService = scanner.nextLine();
        while (!ValidateFacility.Room(String.valueOf(codeService))) {
            System.out.println("Quý khách nhập không đúng định dạng!");
            System.out.print("Mời quý khách nhập lại mã dịch vụ: ");
            codeService = scanner.nextLine();
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
        Room room = new Room(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, dichVufree);
        facilityMap.put(room, 0);

    }

}
