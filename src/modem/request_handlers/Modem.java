package modem.request_handlers;

import modem.request_handlers.objs.IMSI;
import modem.request_handlers.objs.Messages;
import modem.request_handlers.objs.PhoneNumber;
import modem.request_handlers.objs.SignalQuality;

public class Modem {
    private final SignalQuality signalQuality;
    private final PhoneNumber phoneNumber;
    private final ATCommandExecutor executor;
    private final Messages messages;
    private final IMSI imsi;

    public Modem(String portName, String modemModel) {
        executor = new ATCommandExecutor(portName);
        signalQuality = new SignalQuality();
        phoneNumber = new PhoneNumber();
        messages = new Messages();
        imsi = new IMSI();
    }

    public String getSignalQuality() {
        return signalQuality.getSignalQuality(executor);
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber(executor);
    }

    public String getMessages() {
        return messages.getMessages(executor);
    }

    public String getIMSI() {
        return imsi.getIMSI(executor);
    }
}
