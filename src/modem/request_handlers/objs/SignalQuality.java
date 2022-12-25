package modem.request_handlers.objs;

import modem.request_handlers.ATCommandExecutor;
import modem.request_handlers.containers.SignalQualityContainer;
import modem.request_handlers.requesters.ATSignalQualityRequester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignalQuality {

    private ATSignalQualityRequester requester;

    public SignalQualityContainer getSignalQuality(ATCommandExecutor executor) {
        if(requester == null) {
            requester = new ATSignalQualityRequester();
        }
        try {
            String regex = "(\\d+),";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(requester.makeRequest(executor));
            if(matcher.find()) {
                int result = Integer.parseInt(matcher.group(1));
                SignalQualityContainer signalQualityContainer = new SignalQualityContainer();
                signalQualityContainer.setSignalQuality(result);
                return signalQualityContainer;
            }
            return null;
        } catch (Exception exc) {
            return null;
        }
    }
}
