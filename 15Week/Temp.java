package quiz.imade;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Temp {
    public static void main(String[] args) {
        try {
            File dir = new File("C:/Temp");
            File text = new File("C:/Temp/Text.txt");
            if(dir.exists() == false) {
                dir.mkdirs();
                System.out.println("디렉토리 생성 완료");
            }
            if(text.exists() == false) {
                text.createNewFile();
                System.out.println("파일 생성 완료");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Temp/Text.txt"));
            char[] apple = { 'a', 'p', 'p', 'l', 'e'};
            char[] banana = { 'b', 'a', 'n', 'a', 'n', 'a' };
            char[] peach = { 'p', 'e', 'a', 'c', 'h' };
            writer.write(apple);
            writer.newLine();
            writer.write(banana);
            writer.newLine();
            writer.write(peach);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
