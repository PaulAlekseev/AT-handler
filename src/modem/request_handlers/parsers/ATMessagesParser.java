package modem.request_handlers.parsers;

import modem.request_handlers.interfaces.ATParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATMessagesParser implements ATParser {
    @Override
    public String parse(String data) {
        String resultRegex = "\\+CMGL:\\s\\d+,\"REC\\sREAD\",\"(.*)\",\"\",\".*\"\r\n(.*)\r\n";
        Pattern resultRegexPattern = Pattern.compile(resultRegex);
        Matcher matcher = resultRegexPattern.matcher(data);
        ArrayList<String> resultList = new ArrayList<>();
        while(matcher.find()) {
            resultList.add(matcher.group(0));
        }
        return resultList.toString();
    }
}
