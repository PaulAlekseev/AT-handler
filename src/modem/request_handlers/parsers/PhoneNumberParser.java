package modem.request_handlers.parsers;

import extra.OperatorNumberRegex;
import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.HexConverter;
import modem.request_handlers.containers.IMSIContainer;
import modem.request_handlers.containers.PhoneNumberContainer;
import modem.request_handlers.objs.IMSI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberParser {
    public static PhoneNumberContainer parsePhoneNumber(String data, ATCommandExecutor executor) {
        IMSI imsi = new IMSI();
        IMSIContainer imsiContainer = imsi.getIMSI(executor);
        Pattern pattern = Pattern.compile(OperatorNumberRegex.getRegex(imsiContainer));
        Matcher matcher = pattern.matcher(data);
        if(matcher.find()) {
            PhoneNumberContainer container = new PhoneNumberContainer();
            container.setPhoneNumber(matcher.group(1));
            return container;
        } else {
            data = HexConverter.convertHexString(data);
            Matcher matcher1 = pattern.matcher(data);
            if (matcher1.find()) {
                PhoneNumberContainer container = new PhoneNumberContainer();
                container.setPhoneNumber(matcher1.group(1));
                return container;
            }
        }
        return null;
    }
}
