import java.io.*;
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
            while (sc.hasNextByte()) {
                String scannedString = sc.nextLine().trim();
                try {
                    Checker.checkString(scannedString);
                    String[] convertedString = NumbersReader.convert(scannedString);
                    System.out.println(Calculator.calculate(convertedString));
                    result = result + scannedString + " = " + Calculator.calculate(convertedString) + "\n" + "\n";
                    if (sc.nextLine() == null) {
                        result = result + "\n";
                    }
                } catch (MyException ex) {
                    result = result + scannedString + " = " + ex.getMessage() + "\n";
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