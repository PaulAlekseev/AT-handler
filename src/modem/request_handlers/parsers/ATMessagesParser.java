package modem.request_handlers.parsers;

import modem.request_handlers.HexConverter;
import modem.request_handlers.interfaces.ATParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATMessagesParser implements ATParser {
    @Override
    public String parse(String data) {
        String resultRegex = "\\+CMGL:\\s\\d+,\"REC\\sREAD\",\".*\",\"\",\".*\"\r\n(.*)\r\n";
        Pattern resultRegexPattern = Pattern.compile(resultRegex);
        Matcher matcher = resultRegexPattern.matcher(data);
        ArrayList<String> resultList = new ArrayList<>();
        String dummy;
        String convertedDummy;
        while(matcher.find()) {
            dummy = matcher.group(1);
            convertedDummy = HexConverter.convertHexString(dummy);
            if(convertedDummy!=null) {
                resultList.add(convertedDummy);
                continue;
            }
            resultList.add(dummy);
        }
        return resultList.toString();
    }
}
