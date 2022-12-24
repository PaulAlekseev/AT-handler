package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATIMSIRequester;

public class IMSI {

    private ATIMSIRequester requester;

    public String getIMSI(ATCommandExecutor executor, String operator) {
        if(requester == null) {
            requester = new ATIMSIRequester(operator);
        }
        return requester.makeRequest(executor);
    }
}
