abstract class SmartDevice {
    protected String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public void showStatus() {
        System.out.println("Device: " + deviceName);
    }
}

class SmartLight extends SmartDevice {
    public SmartLight(String deviceName) {
        super(deviceName);
    }

    public void turnOn() {
        System.out.println("Light is now ON");
    }

    public void turnOff() {
        System.out.println("Light is now OFF");
    }
}

class SmartSpeaker extends SmartDevice {
    public SmartSpeaker(String deviceName) {
        super(deviceName);
    }

    public void turnOn() {
        System.out.println("Speaker is now playing music");
    }

    public void turnOff() {
        System.out.println("Speaker is now OFF");
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String deviceName) {
        super(deviceName);
    }

    public void turnOn() {
        System.out.println("Thermostat is now set to 22°C");
    }

    public void turnOff() {
        System.out.println("Thermostat is turned off");
    }
}

public class Main {

    public static void main(String[] args) {
        SmartLight smartlight = new SmartLight("Smart Light");

        System.out.println("Smart Light:");
        smartlight.turnOn();
        smartlight.showStatus();
        smartlight.turnOff();

        SmartSpeaker smartspeaker = new SmartSpeaker("Smart Speaker");

        System.out.println("\nSmart Speaker:");
        smartspeaker.turnOn();
        smartspeaker.showStatus();
        smartspeaker.turnOff();

        SmartThermostat smartthermostat = new SmartThermostat("Smart Thermostat");

        System.out.println("\nSmart Thermostat:");
        smartthermostat.turnOn();
        smartthermostat.showStatus();
        smartthermostat.turnOff();
    }
}