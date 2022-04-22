package ss16_io_text_file.bai.bai_tap.copy_file_text;

import java.io.*;
import java.nio.file.Files;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File("src/ss16_io_text_file/bai/bai_tap/read_file_csv/file.txt"));
            outputStream = new FileOutputStream(new File("src/ss16_io_text_file/bai/bai_tap/copy_file_text/file.txt"));
            int length ;
            byte[] buffer = new byte[1241];
            while ((length = inputStream.read(buffer))> 0){
                outputStream.write(buffer, 0,length);
            }
            System.out.println("");
        }catch (IOException e ){
            e.printStackTrace();
        }finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
