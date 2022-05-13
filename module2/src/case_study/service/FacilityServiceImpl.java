package case_study.service;

import case_study.common.readandwrite.ReadAndWrite;
import case_study.model.Facility;
import case_study.model.House;
import case_study.model.Room;
import case_study.model.Villa;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_VILLA = "case_study/common/data/villa.csv";
    private static final String FILE_HOUSE = "case_study/common/data/house.csv";
    private static final String FILE_ROOM = "case_study/common/data/room.csv";
    static List<Villa> villas = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
    static List<Room> rooms = new ArrayList<>();
    static List<Facility> maintenance = new ArrayList<>();
    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    @Override
    public void display() {
        villas = ReadAndWrite.readFileVilla(FILE_VILLA);
        houses = ReadAndWrite.readFileHouse(FILE_HOUSE);
        rooms = ReadAndWrite.readFileRoom(FILE_ROOM);
        facilityMap.clear();
        for (Villa villa : villas) {
            addFacilitylist(villa);
        }
        for (Room room : rooms) {
            addFacilitylist(room);
        }
        for (House house : houses) {
            addFacilitylist(house);
        }
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println("Service: " + entry.getKey().getNameService());
            System.out.println("Number of used: " + entry.getValue());
        }
    }

    @Override
    public void addFacilitylist(Facility facility) {

        if (facilityMap.isEmpty()) {
            facilityMap.put(facility, 1);
        } else {
            boolean flag = false;
            for (Facility key : facilityMap.keySet()) {
                if (facility.equals(key)) {
                    maintenanceCheck(key);
                    facilityMap.put(key, facilityMap.get(key) + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                facilityMap.put(facility, 1);
            }
        }
    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if (facilityMap.get(facility) >= 4) {
            System.out.println("-----DỊCH VỤ NÀY ĐANG ĐƯỢC BẢO TRÌ!-----");
            if (facility instanceof House) {
                houses.clear();
                ReadAndWrite.writeHouse(FILE_HOUSE,houses);
            } else if (facility instanceof Room) {
                rooms.clear();
                ReadAndWrite.writeRoom(FILE_ROOM,rooms);
            } else if (facility instanceof Villa) {
                villas.clear();
                ReadAndWrite.writeVilla(FILE_VILLA, villas);
            }
            maintenance.add(facility);
            facilityMap.put(facility, 0);
        }
    }


    @Override
    public void displayListFacilityMaintenance() {
        if (!maintenance.isEmpty()) {
            for (Facility f : maintenance) {
                System.out.println(f);
            }
        } else {
            System.out.println("-----DANH SÁCH BẢO TRÌ ĐANG TRỐNG!-----");
        }
    }

    @Override
    public void addVilla() {
        System.out.println("---------------ADD MEW VILLA---------------");

        System.out.print("Thên mới mã dịch vụ: ");
        String codeService = scanner.nextLine();
//        while (!Regex.Villa(codeService)){
//            System.out.println("Nhập không đúng định dạng SVVL-YYYY!");
//            System.out.print("Nhập lại mã dịch vụ Villa: ");
//            codeService = scanner.nextLine();
//        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();
//        while (!Regex.NameService(dichVu)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tên dịch vụ: ");
//            dichVu = scanner.nextLine();
//        }

        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());
//        while (!Regex.Area(dichVu)){
//            System.out.println("Nhập không đúng định dạng > 30m2 ");
//            System.out.println("Nhập lại diện tích: ");
//            dienTich = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.RentalCosts(String.valueOf(chiPhi))){
//            System.out.println("Nhập không đúng định dạng là số dương ");
//            System.out.println("Nhập lại chi phí: ");
//            chiPhi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.MaxmumPeople(String.valueOf(soLuongNguoi))){
//            System.out.println("Nhập không đúng định dạng  0< số lượng <20");
//            System.out.println("Nhập lại số lượng người: ");
//            soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();
//        while (!Regex.NameService(kieuThue)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu ");
//            System.out.println("Nhập lại kiểu thuê: ");
//            kieuThue = scanner.nextLine();
//        }

        System.out.print("Thên mới tiêu chuẩn villa: ");
        String tieuChuan = scanner.nextLine();
//        while (!Regex.NameService(tieuChuan)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tiêu chuẩn thuê: ");
//            tieuChuan = scanner.nextLine();
//        }

        System.out.print("Thên mới diện tích hô bơi: ");
        Integer dienTichHoBoi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.Area(String.valueOf(dienTichHoBoi))){
//            System.out.println("Nhập không đúng định dạng > 30m2");
//            System.out.println("Nhập lại ");
//            dienTichHoBoi = Integer.parseInt(scanner.nextLine());
//        }


        System.out.print("Thên mới số tầng: ");
        Integer soTang = Integer.parseInt(scanner.nextLine());
//        while (!Regex.FloorsNumber(String.valueOf(soTang))){
//            System.out.println("Nhập không đúng định dạng là số dương ");
//            System.out.println("Nhập lại số tầng: ");
//            soTang = Integer.parseInt(scanner.nextLine());
//        }

        Villa villa = new Villa(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, dienTichHoBoi, soTang);
        this.addFacilitylist(villa);
        villas.add(villa);
        ReadAndWrite.writeVilla(FILE_VILLA, villas);

    }

    @Override
    public void addHouse() {
        System.out.println("---------------ADD MEW HOUSE---------------");


        System.out.print("Thên mới mã dịch vụ: ");
        String codeService = scanner.nextLine();
//        while (!Regex.Villa(codeService)){
//            System.out.println("Nhập không đúng định dạng SVHO-YYYY!");
//            System.out.print("Nhập lại mã dịch vụ House: ");
//            codeService = scanner.nextLine();
//        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();
//        while (!Regex.NameService(dichVu)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tên dịch vụ: ");
//            dichVu = scanner.nextLine();
//        }


        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());
//        while (!Regex.Area(dichVu)){
//            System.out.println("Nhập không đúng định dạng > 30m2 ");
//            System.out.println("Nhập lại diện tích: ");
//            dienTich = Integer.parseInt(scanner.nextLine());
//        }


        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.RentalCosts(String.valueOf(chiPhi))){
//            System.out.println("Nhập không đúng định dạng là số dương ");
//            System.out.println("Nhập lại chi phí: ");
//            chiPhi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.MaxmumPeople(String.valueOf(soLuongNguoi))){
//            System.out.println("Nhập không đúng định dạng  0< số lượng <20");
//            System.out.println("Nhập lại số lượng người: ");
//            soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();
//        while (!Regex.NameService(kieuThue)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu ");
//            System.out.println("Nhập lại kiểu thuê: ");
//            kieuThue = scanner.nextLine();
//        }

        System.out.print("Thên mới tiêu chuẩn villa : ");
        String tieuChuan = scanner.nextLine();
//        while (!Regex.NameService(tieuChuan)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tiêu chuẩn thuê: ");
//            tieuChuan = scanner.nextLine();
//        }

        System.out.print("Thên mới số tầng: ");
        Integer soTang = Integer.parseInt(scanner.nextLine());
//        while (!Regex.FloorsNumber(String.valueOf(soTang))){
//            System.out.println("Nhập không đúng định dạng là số dương ");
//            System.out.println("Nhập lại số tầng: ");
//            soTang = Integer.parseInt(scanner.nextLine());
//        }

        House house = new House(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, soTang);
        this.addFacilitylist(house);
        houses.add(house);
        ReadAndWrite.writeHouse(FILE_HOUSE, houses);

    }

    @Override
    public void addRoom() {
        System.out.println("---------------ADD MEW ROOM---------------");

 
        System.out.print("Thên mới mã dịch  vụ: ");
        String codeService = scanner.nextLine();
//        while (!Regex.Villa(codeService)){
//            System.out.println("Nhập không đúng định dạng SVRO-YYYY!");
//            System.out.print("Nhập lại mã dịch vụ House: ");
//            codeService = scanner.nextLine();
//        }

        System.out.print("Thên mới tên dịch vụ: ");
        String dichVu = scanner.nextLine();
//        while (!Regex.NameService(dichVu)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tên dịch vụ: ");
//            dichVu = scanner.nextLine();
//        }

        System.out.print("Thên mới diện tích sử dụng: ");
        Integer dienTich = Integer.parseInt(scanner.nextLine());
//        while (!Regex.Area(dichVu)){
//            System.out.println("Nhập không đúng định dạng > 30m2 ");
//            System.out.println("Nhập lại diện tích: ");
//            dienTich = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới chi phí thêm: ");
        Integer chiPhi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.RentalCosts(String.valueOf(chiPhi))){
//            System.out.println("Nhập không đúng định dạng là số dương ");
//            System.out.println("Nhập lại chi phí: ");
//            chiPhi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới số lượng người tối đa: ");
        Integer soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        while (!Regex.MaxmumPeople(String.valueOf(soLuongNguoi))){
//            System.out.println("Nhập không đúng định dạng  0< số lượng <20");
//            System.out.println("Nhập lại số lượng người: ");
//            soLuongNguoi = Integer.parseInt(scanner.nextLine());
//        }

        System.out.print("Thên mới kiểu thuê: ");
        String kieuThue = scanner.nextLine();
//        while (!Regex.NameService(kieuThue)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu ");
//            System.out.println("Nhập lại kiểu thuê: ");
//            kieuThue = scanner.nextLine();
//        }

        System.out.print("Thên mới tiêu chuẩn villa : ");
        String tieuChuan = scanner.nextLine();
//        while (!Regex.NameService(tieuChuan)){
//            System.out.println("Nhập không đúng định dạng viết hoa ký tự đầu");
//            System.out.println("Nhập lại tiêu chuẩn thuê: ");
//            tieuChuan = scanner.nextLine();
//        }

        System.out.print("Thên mới dịch vụ miễn phí: ");
        String dichVufree = scanner.nextLine();

        Room room = new Room(codeService, dichVu, dienTich, chiPhi, soLuongNguoi, kieuThue, tieuChuan, dichVufree);
        this.addFacilitylist(room);
        rooms.add(room);
        ReadAndWrite.writeRoom(FILE_ROOM, rooms);

    }
}
