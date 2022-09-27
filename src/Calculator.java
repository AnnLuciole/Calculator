public class Calculator {

    public static double calculate (NumbersReader.DataForCalculator convertedString) throws Exception {
        double a = convertedString.getNumberOne();
        double b = convertedString.getNumberTwo();
        double result;
        switch (convertedString.getSignOfEqualation()) {
            case "+": result = a + b;
                break;
            case "-": result = a - b;
                break;
            case "*": result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new MyException("Error! Division by zero");
                }
                result = a / b;
                break;
            default:
                throw new MyException("Operation Error!");
        }
        return result;
    }
}
