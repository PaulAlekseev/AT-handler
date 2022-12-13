package modem.request_handlers;

import modem.request_handlers.objs.PhoneNumber;
import modem.request_handlers.objs.SignalQuality;

public class Modem {
    private final SignalQuality signalQuality;
    private final PhoneNumber phoneNumber;
    private final ATCommandExecutor executor;
    private final String operator;
    public Modem(String portName, String operator) {
        this.executor = new ATCommandExecutor(portName);
        this.operator = operator;
        this.signalQuality = new SignalQuality();
        this.phoneNumber = new PhoneNumber();
    }

    public String getSignalQuality() {
        return signalQuality.getSignalQuality(executor, operator);
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber(executor, operator);
    }

    public String getOperator() {
        return operator;
    }
}
