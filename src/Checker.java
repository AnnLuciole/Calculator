public class Checker {

    public static void checkString(String scannedString) throws Exception {
        char[] symbols = scannedString.toCharArray();
        for (char symbol : symbols) {

            if (Character.isLetter(symbol)) {
                throw new MyException("Error! Not number");
            }

            if (!Checker.isPermittedSign(symbol)) {
                throw new MyException("Operation Error!");
            }
        }
    }

    private static boolean isPermittedSign(char sign) {
        if (Character.isDigit(sign) || Character.isSpaceChar(sign)) {
            return true;
        } else if (Checker.isPointOrComma(sign) || Checker.isOperationSign(sign)) {
            return true;
        }
        return false;
    }

    public static boolean isOperationSign(char sign) {
        String permittedSign = "+-*/";
        if (permittedSign.contains(Character.toString(sign))) {
            return true;
        }
        return false;
    }

    public static boolean isPointOrComma(char sign) {
        if (sign == '.' || sign == ',') {
            return true;
        }
        return false;
    }
}
