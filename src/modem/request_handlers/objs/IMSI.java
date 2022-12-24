package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.containers.IMSIContainer;
import modem.request_handlers.parsers.IMSIParser;
import modem.request_handlers.requesters.ATIMSIRequester;

public class IMSI {

    private ATIMSIRequester requester;

    public IMSIContainer getIMSI(ATCommandExecutor executor) {
        if(requester == null) {
            requester = new ATIMSIRequester();
        }
        return IMSIParser.parseIMSI(requester.makeRequest(executor));
    }
}
