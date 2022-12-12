package modem.request_handlers.interfaces;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.Modem;

public interface ATRequest {
    public String makeRequest(ATCommandExecutor executor) throws Exception;
}
