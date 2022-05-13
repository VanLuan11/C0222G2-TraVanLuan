package exam.common.readandwrite;

import case_study.model.Employee;
import exam.model.DienThoaiChinhHang;
import exam.model.DienThoaiXachTay;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndWrite {
    private final static String COMMA = ",";
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
    public static void writeDienThoaiChinhHang(String pathFile, List<DienThoaiChinhHang> dienThoaiChinhHangs) {
        List<String> stringList = new ArrayList<>();
        for (DienThoaiChinhHang d: dienThoaiChinhHangs) {
            stringList.add(d.convertLine());
        }
        writeFile(pathFile, stringList);
    }
    public static void writeDienThoaiXachTay(String pathFile, List<DienThoaiXachTay> dienThoaiXachTays) {
        List<String> stringList = new ArrayList<>();
        for (DienThoaiXachTay d : dienThoaiXachTays) {
            stringList.add(d.convertLine());
        }
        writeFile(pathFile, stringList);
    }

    //read File
    public static List<DienThoaiChinhHang> readFileDienThoaiChinhHang(String pathFile) {
        List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
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
                dienThoaiChinhHangs.add(new DienThoaiChinhHang(Integer.parseInt(lines[0]),lines[1],Integer.parseInt(lines[2]),Integer.parseInt(lines[3]),lines[4],lines[5],lines[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dienThoaiChinhHangs;
    }
    public static List<DienThoaiXachTay> readFileDienThoaiXachTay(String pathFile) {
        List<DienThoaiXachTay> dienThoaiXachTays = new ArrayList<>();
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

                dienThoaiXachTays.add(new DienThoaiXachTay(Integer.parseInt(lines[0]),lines[1],Integer.parseInt(lines[2]),Integer.parseInt(lines[3]),lines[4],lines[5],lines[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dienThoaiXachTays;
    }

}
