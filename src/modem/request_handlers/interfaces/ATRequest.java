package modem.request_handlers.interfaces;

import modem.request_handlers.ATCommandExecutor;

public interface ATRequest {
    String makeRequest(ATCommandExecutor executor) throws Exception;
}
