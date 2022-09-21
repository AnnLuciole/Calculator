
public class NumbersReader {

    public static String[] convert(String scannedString) {
        String[] convertedString = new String[3];
        char[] symbols = scannedString.toCharArray();
        int indexOfSign = 0;

        for (int i = 0; i < symbols.length; i++) {
            if(Checker.isOperationSign(symbols[i])) {
                indexOfSign = i;
            }
        }

        convertedString[0] = scannedString.substring(0,indexOfSign);
        convertedString[1] = scannedString.substring(indexOfSign, indexOfSign + 1);
        convertedString[2] = scannedString.substring(indexOfSign + 1);

        return convertedString;
    }
}
