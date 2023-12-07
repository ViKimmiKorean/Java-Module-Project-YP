import java.lang.Math;
import java.text.DecimalFormat;

class Formatter {
    private static int getIntPart(double amount){
        double value = Math.floor(amount);
        int intPart = (int)value;
        return intPart;
    }

    public static String formatCurrency(double amount) {
        int intPart = getIntPart(amount);

        String formattedAmount = String.format("%.2f", amount);

        int lastTwoDigits = intPart % 100;

        if ((lastTwoDigits >= 11 && lastTwoDigits <= 14) || lastTwoDigits % 10 == 0 || (lastTwoDigits % 10 >= 5 && lastTwoDigits % 10 <= 9)) {
            return formattedAmount + " рублей";
        } else if (lastTwoDigits % 10 == 1) {
            return formattedAmount + " рубль";
        } else {
            return formattedAmount + " рубля";
        }
    }
}
