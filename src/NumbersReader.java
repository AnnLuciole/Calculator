
public class NumbersReader {

    public static String[] convert(String scannedString) {
        String[] convertedString = new String[3];
        char[] symbols = scannedString.toCharArray();
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < symbols.length;) {
            if (Character.isDigit(symbols[i]) || Checker.isPointOrComma(symbols[i])) {
                while (Character.isDigit(symbols[i]) || Checker.isPointOrComma(symbols[i])) {
                    strBuilder.append(symbols[i]);
                    i++;
                }
                convertedString[i] = strBuilder.toString();
                strBuilder.setLength(0);
            } else if (Character.isSpaceChar(symbols[i]) || Checker.isOperationSign(symbols[i])) {
                while (Character.isSpaceChar(symbols[i]) || Checker.isOperationSign(symbols[i])) {
                    strBuilder.append(symbols[i]);
                    i++;
                }
                convertedString[i] = strBuilder.toString().trim();
                strBuilder.setLength(0);
            }
        }
        return convertedString;
    }
}
