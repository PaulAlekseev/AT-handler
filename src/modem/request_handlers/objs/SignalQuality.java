package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATSignalQualityRequester;

public class SignalQuality {
    private String signalQuality;

    public String getSignalQuality(ATCommandExecutor executor) {
        if(signalQuality == null) {
            ATSignalQualityRequester requester = new ATSignalQualityRequester();
            signalQuality = requester.makeRequest(executor);
        }
        return signalQuality;
    }
}
