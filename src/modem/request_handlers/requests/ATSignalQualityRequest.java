package modem.request_handlers.requests;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.interfaces.ATRequest;

public class ATSignalQualityRequest implements ATRequest {
    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        executor.executeAtCommand("AT+CSQ", 50);
        return executor.readResult();
    }
}
