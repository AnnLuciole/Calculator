import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File input = new File("C:\\Users\\Manager\\IdeaProjects\\Program\\input.txt");
        File output = new File("C:\\Users\\Manager\\IdeaProjects\\Program\\output.txt");
        String result = "";

        try (FileReader reader = new FileReader(input)) {
            Scanner sc = new Scanner(reader);
            input.createNewFile();
            output.createNewFile();
            ArrayList<String> dataFromFile = new ArrayList<>();
            while (sc.hasNextByte()) {
                String scannedString = sc.nextLine();
                if (scannedString != "") {
                    dataFromFile.add(scannedString);
                }
            }
            for (String scannedString : dataFromFile) {
                try {
                    Checker.checkString(scannedString);
                    NumbersReader.DataForCalculator convertedString = NumbersReader.convert(scannedString);
                    result = result + scannedString + " = " + Calculator.calculate(convertedString) + "\n" + "\n";
                } catch (MyException ex) {
                    result = result + scannedString + " = " + ex.getMessage() + "\n" + "\n";
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter(output, true)) {
            writer.write(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}