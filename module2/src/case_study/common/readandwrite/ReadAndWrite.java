package case_study.common.readandwrite;


import case_study.model.*;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReadAndWrite {
    private final static String COMMA = ",";
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);

    // Write
    private static void  writeFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployee(String pathFile, List<Employee> employeeList) {
        List<String> stringList = new ArrayList<>();
        for (Employee e : employeeList) {
            stringList.add(e.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeCustomer(String pathFile, List<Customer> customerList) {
        List<String> stringList = new ArrayList<>();
        for (Customer c : customerList) {
            stringList.add(c.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeVilla(String pathFile, List<Villa> villaList) {
        List<String> stringList = new ArrayList<>();
        for (Villa v : villaList) {
            stringList.add(v.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeHouse(String pathFile, List<House> houseList) {
        List<String> stringList = new ArrayList<>();
        for (House h : houseList) {
            stringList.add(h.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeRoom(String pathFile, List<Room> roomList) {
        List<String> stringList = new ArrayList<>();
        for (Room r : roomList) {
            stringList.add(r.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeBooking(String pathFile, Set<Booking> bookingSet) {
        List<String> stringList = new ArrayList<>();
        for (Booking b : bookingSet) {
            stringList.add(b.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    public static void writeContract(String pathFile, List<Customer> customerList) {
        List<String> stringList = new ArrayList<>();
        for (Customer c : customerList) {
            stringList.add(c.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    //read File
    public static List<Employee> readFileEmployee(String pathFile) {
        List<Employee> employees = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);
                Date date = null;
                try{
                    date = dateFormat.parse(lines[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                employees.add(new Employee(lines[0],date, lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], Integer.parseInt(lines[6]), lines[7], lines[8], Integer.parseInt(lines[9])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public static List<Customer> readFileCustomer(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                Date date =null;
                try{
                    date = dateFormat.parse(lines[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                customers.add(new Customer(lines[0], date, lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], Integer.parseInt(lines[6]), lines[7], lines[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public static List<Villa> readFileVilla(String pathFile) {
        List<Villa> villas = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                villas.add(new Villa(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6], Integer.parseInt(lines[7]), Integer.parseInt(lines[8])));
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villas;
    }
    public static List<House> readFileHouse(String pathFile) {
        List<House> houses = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                houses.add(new House(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6], Integer.parseInt(lines[7])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houses;
    }
    public static List<Room> readFileRoom(String pathFile) {
        List<Room> rooms = new ArrayList<>();
        String[] lines = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                rooms.add(new Room(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
