package modem.request_handlers.requesters;

import modem.request_handlers.ATRequester;
import modem.request_handlers.parsers.ATPhoneNumberParser;
import modem.request_handlers.requests.ATPhoneNumberRequest;

public class ATPhoneNumberRequester extends ATRequester {
    public ATPhoneNumberRequester(String operator) {
        super(operator);
    }

    @Override
    protected void setRequester() {
        request = new ATPhoneNumberRequest();
        parser = new ATPhoneNumberParser();
    }
}
