package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATPhoneNumberRequester;

public class PhoneNumber {
    private String phoneNumber;

    private ATPhoneNumberRequester requester;

    public String getPhoneNumber(ATCommandExecutor executor, String operator) {
        if(requester == null) {
            requester = new ATPhoneNumberRequester(operator);
        }
        if(phoneNumber == null) {
            phoneNumber = requester.makeRequest(executor);
        }
        return phoneNumber;
    }
}
