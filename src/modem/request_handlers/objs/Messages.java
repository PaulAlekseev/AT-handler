package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATMessagesRequester;

public class Messages {

    private ATMessagesRequester requester;

    public String getMessages(ATCommandExecutor executor, String operator) {
        if(requester == null) {
            requester = new ATMessagesRequester(operator);
        }
        return requester.makeRequest(executor);
    }
}
