package modem.request_handlers.requests;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.interfaces.ATRequest;

public class ATDeleteSMSRequest implements ATRequest {
    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        executor.openPort(115200, 8, 1, 0);
        executor.executeAtCommand("AT+CMGD=1,4", 1000);
        String result = executor.readResult();
        executor.closePort();
        return result;
    }
}
