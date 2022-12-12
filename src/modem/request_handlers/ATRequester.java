package modem.request_handlers;

import modem.request_handlers.interfaces.ATRequest;

public class ATRequester {
    private ATCommandExecutor executor;

    public ATRequester(ATCommandExecutor executor) {
        this.executor = executor;
    }

    public String executeRequest(ATRequest request) throws Exception {
        return request.makeRequest(executor);
    }
}
