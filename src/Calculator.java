public class Calculator {

    public static double calculate (String[] convertedString) throws Exception {
        double a = Double.parseDouble(convertedString[0]);
        double b = Double.parseDouble(convertedString[2]);
        double result;
        switch (convertedString[1]) {
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
