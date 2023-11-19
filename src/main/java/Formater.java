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

        if (intPart == 1) {
            return formattedAmount + " рубль";
        } else if (intPart > 1 && intPart < 5) {
            return formattedAmount + " рубля";
        } else {
            return formattedAmount + " рублей";
        }
    }
}
