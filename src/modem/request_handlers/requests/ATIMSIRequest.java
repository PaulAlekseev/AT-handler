package modem.request_handlers.requests;


import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.interfaces.ATRequest;

public class ATIMSIRequest implements ATRequest {
    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        executor.executeAtCommand("AT+CIMI", 1000);
        return executor.readResult();
    }
}
