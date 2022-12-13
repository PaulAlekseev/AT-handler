package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATSignalQualityRequester;

public class SignalQuality {
    private String signalQuality;

    public String getSignalQuality(ATCommandExecutor executor, String operator) {
        if(signalQuality == null) {
            ATSignalQualityRequester requester = new ATSignalQualityRequester(operator);
            signalQuality = requester.makeRequest(executor);
        }
        return signalQuality;
    }
}
