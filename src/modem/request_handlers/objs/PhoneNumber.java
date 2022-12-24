package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.containers.PhoneNumberContainer;
import modem.request_handlers.parsers.PhoneNumberParser;
import modem.request_handlers.requesters.ATPhoneNumberRequester;

public class PhoneNumber {
    private String phoneNumber;

    private ATPhoneNumberRequester requester;

    public PhoneNumberContainer getPhoneNumber(ATCommandExecutor executor) {
        if(requester == null) {
            requester = new ATPhoneNumberRequester();
        }
        if(phoneNumber == null) {
            phoneNumber = requester.makeRequest(executor);
        }

        return PhoneNumberParser.parsePhoneNumber(phoneNumber, executor);
    }
}
