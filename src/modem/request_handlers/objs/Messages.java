package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.requesters.ATMessagesRequester;

public class Messages {
    private String messages;

    public String getMessages(ATCommandExecutor executor, String operator) {
        if(messages == null) {
            ATMessagesRequester requester = new ATMessagesRequester(operator);
            messages = requester.makeRequest(executor);
        }
        return messages;
    }
}
