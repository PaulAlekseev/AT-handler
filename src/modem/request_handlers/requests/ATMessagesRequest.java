package modem.request_handlers.requests;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.interfaces.ATRequest;

public class ATMessagesRequest implements ATRequest {

    @Override
    public String makeRequest(ATCommandExecutor executor, String operator) throws Exception {
        executor.executeAtCommand("AT+CMGF=1", 300);
        executor.executeAtCommand("AT+CMGL=\"ALL\"", 1000);
        return executor.readResult();
    }
}
