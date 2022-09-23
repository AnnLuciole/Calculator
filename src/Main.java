import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("input.txt")) {
            Scanner sc = new Scanner(reader);
            String scannedString = sc.nextLine().trim();
            Checker.checkString(scannedString);
            String[] convertedString = NumbersReader.convert(scannedString);
            System.out.println(Calculator.calculate(convertedString));
            FileWriter writer = new FileWriter("output.txt");
            writer.write(Double.toString(Calculator.calculate(convertedString)));
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}