package bai_thi.common;

import bai_thi.model.SuatChieu;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndWrite2 {
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
    public static void writeSuatChieu(String pathFile, List<SuatChieu> suatChieuList) {
        List<String> stringList = new ArrayList<>();
        for (SuatChieu s : suatChieuList) {
            stringList.add(s.convertLine());
        }
        writeFile(pathFile, stringList);
    }
    public static List<SuatChieu> readFileSuatChieu(String pathFile) {
        List<SuatChieu> suatChieus = new ArrayList<>();
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
                    date = dateFormat.parse(lines[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                suatChieus.add(new SuatChieu(lines[0], lines[1], date, Integer.parseInt(lines[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suatChieus;
    }
}
