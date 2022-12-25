package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.containers.MessageContainer;
import modem.request_handlers.parsers.MessageParser;
import modem.request_handlers.requesters.ATMessagesRequester;

import java.util.ArrayList;

public class Messages {

    private ATMessagesRequester requester;

    public ArrayList<MessageContainer> getMessages(ATCommandExecutor executor) {
        if(requester == null) {
            requester = new ATMessagesRequester();
        }
        return MessageParser.parseMessages(requester.makeRequest(executor));
    }
}
