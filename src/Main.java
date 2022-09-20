import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader("input.txt");
        Scanner sc = new Scanner(reader);
        sc.useDelimiter(" ");
        String[] expression = new String[3];
        for (int i = 0; i < 3; i++) {
            expression[i] = sc.next();
        }
        sc.close();
        double a = 0;
        double b = 0;
        double result = 0;
        String signs = "+-*/";

        try {
            a = Double.parseDouble(expression[0]);
            b = Double.parseDouble(expression[2]);
            if (expression[1].length() > 1) {
                throw new MyException("Operation Error!");
            }
            if (!signs.contains(expression[1])) {
                throw new MyException("Operation Error!");
            }
            switch (expression[1]) {
                case "+": System.out.println(a + b);
                    break;
                case "-": System.out.println(a - b);
                    break;
                case "*": System.out.println(a * b);
                    break;
                case "/":
                    if (b == 0) {
                        throw new MyException("Error! Division by zero");
                    }
                    System.out.println(a / b);
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error! Not number");
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
    }
}