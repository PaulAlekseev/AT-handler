package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATPhoneNumberRequester;

public class PhoneNumber {
    private String phoneNumber;

    public String getPhoneNumber(ATCommandExecutor executor, String operator) {
        if(phoneNumber == null) {
            ATPhoneNumberRequester requester = new ATPhoneNumberRequester(operator);
            phoneNumber = requester.makeRequest(executor);
        }
        return phoneNumber;
    }
}
