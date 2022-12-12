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
        executor.openPort(115200, 8, 1, 0);
        String commandResult;
        try {
            commandResult = request.makeRequest(executor);
        } catch (Exception exception) {
            return null;
        }
        executor.closePort();
        return parser.parse(commandResult);
    }

}
