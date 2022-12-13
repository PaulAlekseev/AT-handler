package modem.request_handlers.parsers;

import modem.request_handlers.interfaces.ATParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATSignalQualityParser implements ATParser {
    @Override
    public String parse(String data, String operator) {
        Pattern regex = Pattern.compile("\\+CSQ:\s(\\d+,\\d+)");
        Matcher matcher = regex.matcher(data);
        if(matcher.find()){
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
