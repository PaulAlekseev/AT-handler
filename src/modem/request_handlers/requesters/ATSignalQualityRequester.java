package modem.request_handlers.requesters;

import modem.request_handlers.ATRequester;
import modem.request_handlers.parsers.ATSignalQualityParser;
import modem.request_handlers.requests.ATSignalQualityRequest;

public class ATSignalQualityRequester extends ATRequester {

    @Override
    protected void setRequester() {
        request = new ATSignalQualityRequest();
        parser = new ATSignalQualityParser();
    }

}
