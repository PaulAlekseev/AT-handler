package modem.request_handlers.parsers;

import modem.request_handlers.HexConverter;
import modem.request_handlers.containers.MessageContainer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {
    private static final String resultRegex = "\\+CMGL:\\s\\d+,\"REC\\sREAD\",\"(.*)\",\"\",\".*\"\r\n(.*)\r\n";

    public static ArrayList<MessageContainer> parseMessages(String messages) {
        Pattern resultRegexPattern = Pattern.compile(resultRegex);
        ArrayList<MessageContainer> resultList = new ArrayList<>();
        Matcher matcher = resultRegexPattern.matcher(messages);
        while(matcher.find()) {
            MessageContainer messageContainer = new MessageContainer();
            messageContainer.setSender(matcher.group(1));
            messageContainer.setMessage(HexConverter.convertHexString(matcher.group(2)));
            resultList.add(messageContainer);
        }
        return resultList;
    }
}
