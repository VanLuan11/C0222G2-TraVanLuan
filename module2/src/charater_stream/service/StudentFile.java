package charater_stream.service;

import charater_stream.model.Student;
import ss17_io_binary_file_and_serialization.bai_tap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFile {
    private final static String PATH_STUDENT = "src/charater_stream/service/Student.txt";
    private static void writeFile(List<String> stringList, String pathFile, Boolean flag) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, flag);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        File file = new File(PATH_STUDENT);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] array = null;
            Student student = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                student = new Student(Integer.parseInt(array[0]), array[1],
                        array[2], Integer.parseInt(array[3]));
                studentList.add(student);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
