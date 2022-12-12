package modem.request_handlers;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.beans.PropertyEditorSupport;

public class ATCommandExecutor {
    private SerialPort serialPort;

    private static ATCommandExecutor executor;

    private ATCommandExecutor() {
        serialPort = new SerialPort("COM1");
    }

    public void executeAtCommand(String command) throws Exception {
        String finalCommand = command + "\r\n";
        serialPort.writeString(finalCommand);
        // TO ENVIRONMENT VARIABLE
        Thread.sleep(1000);
    }

    public String readResult() throws SerialPortException {
        return serialPort.readString();
    }

    public ATCommandExecutor setPort(String port) {
        serialPort = new SerialPort(port);
        return this;
    }

    public boolean openPort(int baudRate, int dataBits, int stopBits, int parity) {
        try {
            if(serialPort.isOpened()) {
                serialPort.closePort();
            }
            serialPort.openPort();
            serialPort.setParams(baudRate, dataBits, stopBits, parity);
        } catch(SerialPortException exc) {
            return false;
        }
        return true;
    }

    public boolean closePort() {
        try {
            serialPort.closePort();
        } catch(SerialPortException exc) {
            return false;
        }
        return true;
    }

    public static ATCommandExecutor getExecutor() {
        if(executor == null) {
            executor = new ATCommandExecutor();
        }
        return executor;
    }
}
