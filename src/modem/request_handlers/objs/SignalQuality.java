package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATSignalQualityRequester;

public class SignalQuality {

    private ATSignalQualityRequester requester;

    public String getSignalQuality(ATCommandExecutor executor, String operator) {
        if(requester == null) {
            requester = new ATSignalQualityRequester(operator);
        }
        return requester.makeRequest(executor);
    }
}
