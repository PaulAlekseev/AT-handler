package extra;

public class OperatorNumberRegex {
    public static String getRegex(String operator) {
        switch(operator) {
            case "TELE2_RUSSIA":
                return "\\+7\\s\\(\\d{3}\\)\\d{3}\\-\\d{2}-\\d{2}";
        }
        return null;
    }
}
