package modem.request_handlers.parsers;

import modem.request_handlers.interfaces.ATParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATPhoneNumberParser implements ATParser {

    @Override
    public String parse(String data) {
        String resultRegex = "\\+CUSD:\\s2,\"([\\d\\w]+)\"";
        Pattern regexResultPattern = Pattern.compile(resultRegex);
        Matcher matcher = regexResultPattern.matcher(data);
        if (matcher.find()) {
            data = matcher.group(1);
        } else {
            return null;
        }
        return data;
    }
}
