package modem.request_handlers.requesters;

import modem.request_handlers.ATRequester;
import modem.request_handlers.parsers.ATIMSIParser;
import modem.request_handlers.requests.ATIMSIRequest;

public class ATIMSIRequester extends ATRequester {
    public ATIMSIRequester(String operator) {
        super(operator);
    }

    @Override
    protected void setRequester() {
        request = new ATIMSIRequest();
        parser = new ATIMSIParser();
    }
}
