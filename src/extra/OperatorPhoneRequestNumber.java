package extra;

public class OperatorPhoneRequestNumber {
    public static String getRegex(String operator) {
        switch(operator) {
            case "TELE2_RUSSIA":
                return "*201#";
        }
        return null;
    }
}
