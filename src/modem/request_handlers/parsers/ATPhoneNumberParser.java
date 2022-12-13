package modem.request_handlers.parsers;

import extra.OperatorNumberRegex;
import modem.request_handlers.HexConverter;
import modem.request_handlers.interfaces.ATParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATPhoneNumberParser implements ATParser {

    @Override
    public String parse(String data, String operator) {
        String regex = OperatorNumberRegex.getRegex(operator);
        String resultRegex = "\\+CUSD:\\s2,\"([\\d\\w]+)\"";
        if(regex!=null) {
            Pattern regexResultPattern = Pattern.compile(resultRegex);
            Matcher matcher = regexResultPattern.matcher(data);
            if (matcher.find()) {
                data = matcher.group(1);
            } else {
                return null;
            }

            Pattern regexPattern = Pattern.compile(regex);
            Matcher matcherResult = regexPattern.matcher(data);
            if(matcherResult.find()) {
                return matcherResult.group(0);
            } else {

                Matcher matcherResult2 = regexPattern.matcher(HexConverter.convertHexString(data));
                if (matcherResult2.find()) {
                    return matcherResult2.group(0);
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
