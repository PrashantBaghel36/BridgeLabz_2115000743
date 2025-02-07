class Device {
    String deviceId;
    boolean status;
    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false; // Initially off
    }
    public void turnOn() {
        this.status = true;
    }
    public void turnOff() {
        this.status = false;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "On" : "Off"));
    }
}
class Thermostat extends Device {
    int temperatureSetting;
    public Thermostat(String deviceId, int temperatureSetting) {
        super(deviceId);
        this.temperatureSetting = temperatureSetting;
    }
    public void setTemperature(int temperature) {
        this.temperatureSetting = temperature;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("livingRoomThermostat", 22);
        thermostat.turnOn();
        thermostat.displayStatus();
        thermostat.setTemperature(24);
        thermostat.displayStatus();
        thermostat.turnOff();
        thermostat.displayStatus();
    }
}
