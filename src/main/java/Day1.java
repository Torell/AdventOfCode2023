import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) {

        try {



            try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Day1.txt"))) {
                String line;

                int totalvalue = 0;


                while ((line = reader.readLine()) != null) {
                    String valueOfLine = "";
                    line = replaceWordsWithDigits(line);
                    System.out.println(line);
                    for (int i = 0; i <line.length() ; i++) {
                        if (Character.isDigit(line.charAt(i))) {
                            valueOfLine += line.charAt(i);
                            break;
                        }
                    }
                    for (int i = line.length()-1; i >= 0;  i--) {
                        if (Character.isDigit(line.charAt(i))) {
                            valueOfLine += line.charAt(i);
                            break;
                        }
                    }

                    totalvalue += Integer.parseInt(valueOfLine);
                    }
                System.out.println(totalvalue);
                }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String replaceWordsWithDigits(String line) {;

        line = line.replace("one", "o1e");
        line = line.replace("two", "t2o");
        line = line.replace("three", "t3e");
        line = line.replace("four", "f4r");
        line = line.replace("five", "f5e");
        line = line.replace("six", "s6x");
        line = line.replace("seven", "s7n");
        line = line.replace("eight", "e8t");
        line = line.replace("nine", "n9e");

        return line;
    }
}
