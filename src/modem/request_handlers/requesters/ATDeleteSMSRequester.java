package modem.request_handlers.requesters;

import modem.request_handlers.ATRequester;
import modem.request_handlers.parsers.ATDeleteSMSParser;
import modem.request_handlers.requests.ATDeleteSMSRequest;

public class ATDeleteSMSRequester extends ATRequester {
    @Override
    protected void setRequester() {
        request = new ATDeleteSMSRequest();
        parser = new ATDeleteSMSParser();
    }
}
