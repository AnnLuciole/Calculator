import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> resultData = new ArrayList<>();

        try (FileReader reader = new FileReader("input.txt")) {
            Scanner sc = new Scanner(reader);
            ArrayList<String> dataFromFile = new ArrayList<>();
            while (sc.hasNextByte()) {
                String scannedString = sc.nextLine();
                if (!scannedString.equals("")) {
                    dataFromFile.add(scannedString);
                }
            }
            sc.close();
            String result;
            for (String scannedString : dataFromFile) {
                try {
                    Checker.checkString(scannedString);
                    NumbersReader.DataForCalculator convertedString = NumbersReader.convert(scannedString);
                    result = scannedString + " = " + Calculator.calculate(convertedString) + "\n" + "\n";
                    resultData.add(result);
                } catch (MyException ex) {
                    result = scannedString + " = " + ex.getMessage() + "\n" + "\n";
                    resultData.add(result);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            for (String result : resultData) {
                writer.write(result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}