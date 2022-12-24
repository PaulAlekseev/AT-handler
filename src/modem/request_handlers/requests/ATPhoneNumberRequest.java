package modem.request_handlers.requests;

import extra.OperatorPhoneRequestNumber;
import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.containers.IMSIContainer;
import modem.request_handlers.interfaces.ATRequest;
import modem.request_handlers.objs.IMSI;

public class ATPhoneNumberRequest implements ATRequest {

    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        IMSI imsi = new IMSI();
        IMSIContainer imsiContainer = imsi.getIMSI(executor);
        executor.openPort(115200, 8, 1, 0);
        String commandAT = String.format("AT+CUSD=1,%s,15", OperatorPhoneRequestNumber.getRegex(imsiContainer));
        executor.executeAtCommand(commandAT, 10000);
        String result = executor.readResult();
        executor.closePort();
        return result;
    }

}
