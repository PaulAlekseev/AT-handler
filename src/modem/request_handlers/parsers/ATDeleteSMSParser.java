package modem.request_handlers.parsers;

import modem.request_handlers.interfaces.ATParser;

public class ATDeleteSMSParser implements ATParser {
    @Override
    public String parse(String data) {
        System.out.println(data);
        if (data.contains("OK")) {
            return "OK";
        }
        else {
            return null;
        }
    }
}
