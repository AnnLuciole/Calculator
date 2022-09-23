import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class NumbersReader {

    public static String[] convert(String scannedString) {
        ArrayList <String> partsOfString = new ArrayList<>(3);
        String[] splitedString = scannedString.split(findSign(scannedString));
        String[] convertedString = new String[3];

        return convertedString;
    }

    private static String findSign(String scannedString){
        char[] symbols = scannedString.toCharArray();
        String sign = "";
        for (int i = 0; i < symbols.length; i++) {
            if(Checker.isOperationSign(symbols[i])) {
                sign = Character.toString(symbols[i]);
            }
        }
        return sign;
    }
}
