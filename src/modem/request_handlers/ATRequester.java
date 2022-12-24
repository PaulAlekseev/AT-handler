package modem.request_handlers;


import modem.request_handlers.interfaces.ATParser;
import modem.request_handlers.interfaces.ATRequest;

public abstract class ATRequester {

    protected ATRequest request;
    protected ATParser parser;

    protected abstract void setRequester();



    public ATRequester() {
        setRequester();
    }

    public String makeRequest(ATCommandExecutor executor) {
        String commandResult;
        try {
            commandResult = request.makeRequest(executor);
        } catch (Exception exception) {
            return null;
        }
        if(commandResult == null) {
            return null;
        }
        return parser.parse(commandResult);
    }

}
