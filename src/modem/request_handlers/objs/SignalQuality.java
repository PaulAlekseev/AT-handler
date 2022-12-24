package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATSignalQualityRequester;

public class SignalQuality {

    private ATSignalQualityRequester requester;

    public String getSignalQuality(ATCommandExecutor executor) {
        if(requester == null) {
            requester = new ATSignalQualityRequester();
        }
        return requester.makeRequest(executor);
    }
}
