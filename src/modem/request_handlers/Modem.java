package modem.request_handlers;

import modem.request_handlers.containers.IMSIContainer;
import modem.request_handlers.containers.MessageContainer;
import modem.request_handlers.containers.PhoneNumberContainer;
import modem.request_handlers.containers.SignalQualityContainer;
import modem.request_handlers.objs.IMSI;
import modem.request_handlers.objs.Messages;
import modem.request_handlers.objs.PhoneNumber;
import modem.request_handlers.objs.SignalQuality;

import java.util.ArrayList;

public class Modem {
    private final SignalQuality signalQuality;
    private final PhoneNumber phoneNumber;
    private final ATCommandExecutor executor;
    private final Messages messages;
    private final IMSI imsi;

    public Modem(String portName) {
        executor = new ATCommandExecutor(portName);
        signalQuality = new SignalQuality();
        phoneNumber = new PhoneNumber();
        messages = new Messages();
        imsi = new IMSI();
    }

    public SignalQualityContainer getSignalQuality() {
        return signalQuality.getSignalQuality(executor);
    }

    public PhoneNumberContainer getPhoneNumber() {
        return phoneNumber.getPhoneNumber(executor);
    }

    public ArrayList<MessageContainer> getMessages() {
        return messages.getMessages(executor);
    }

    public IMSIContainer getIMSI() {
        return imsi.getIMSI(executor);
    }

    public ATCommandExecutor getExecutor() {
        return executor;
    }
}
