package modem.request_handlers.requests;

import extra.OperatorPhoneRequestNumber;
import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.interfaces.ATRequest;

public class ATPhoneNumberRequest implements ATRequest {

    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        String commandAT = String.format("AT+CUSD=1,%s,15", OperatorPhoneRequestNumber.getRegex(operator));
        executor.executeAtCommand(commandAT, 10000);
        return executor.readResult();
    }

}
