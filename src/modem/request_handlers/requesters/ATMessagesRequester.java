package modem.request_handlers.requesters;

import modem.request_handlers.ATRequester;
import modem.request_handlers.parsers.ATMessagesParser;
import modem.request_handlers.requests.ATMessagesRequest;

public class ATMessagesRequester extends ATRequester {
    public ATMessagesRequester(String operator) {
        super(operator);
    }

    @Override
    protected void setRequester() {
        request = new ATMessagesRequest();
        parser = new ATMessagesParser();
    }
}