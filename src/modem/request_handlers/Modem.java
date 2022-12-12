package modem.request_handlers;

import modem.request_handlers.objs.SignalQuality;

public class Modem {
    private final SignalQuality signalQuality;
    private final ATCommandExecutor executor;
    public Modem(String portName) {
        this.executor = new ATCommandExecutor(portName);
        this.signalQuality = new SignalQuality();
    }

    public String getSignalQuality() {
        return signalQuality.getSignalQuality(executor);
    }

}
