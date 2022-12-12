import modem.request_handlers.Modem;

public class Main {

    public static void main(String[] args) {
        // Set the port name
        String portName = "COM90";
        long time = System.currentTimeMillis();
        Modem modem = new Modem(portName);
        System.out.println(modem.getSignalQuality());
        System.out.println(modem.getSignalQuality());
        System.out.println(System.currentTimeMillis() - time);
    }
}
