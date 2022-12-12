import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jssc.SerialPort;
import jssc.SerialPortException;
import modem.request_handlers.ATCommandExecutor;

public class Main {

    public static void main(String[] args) throws IOException {
        // Set the port name
        String portName = "COM26";
        // Create a new serial port object
        SerialPort serialPort = new SerialPort(portName);

        try {
            ATCommandExecutor executor = ATCommandExecutor.getExecutor();
            executor.setPort("COM26");
            executor.openPort(115200, 8, 1, 0);

            executor.executeAtCommand("AT+CMGF=0");
            executor.executeAtCommand("AT+CMGL=4");

            System.out.println(executor.readResult());
//            Pattern regex = Pattern.compile("\\d+\\,\\d+");
//            Matcher matcher = regex.matcher(signalQuality);
//            System.out.println(signalQuality.contains("OK"));
//            System.out.println(matcher.find());
//            System.out.println(matcher);
//            System.out.println(matcher.group());


            // Close the port
            executor.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Function to execute an AT command and return the result
}
