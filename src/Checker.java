public class Checker {

    public static void checkString(String scannedString) throws Exception {
        char[] symbols = scannedString.toCharArray();
        for (int i = 0; i < symbols.length(); i++) {

            if (Character.isLetter(symbols[i])) {
                throw new MyException("Error! Not number");
            }

            if (!Checker.isPermittedSign(symbols[i])) {
                throw new MyException("Operation Error!");
            }
        }
    }

    private static boolean isPermittedSign(char sign) {
        if (Character.isDigit(sign)) {
            return true;
        } else if (Character.isSpaceChar(sign)) {
            return true;
        } else if (Checker.isPointOrComma(sign)) {
            return true;
        } else if (Checker.isOperationSign(sign)) {
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
