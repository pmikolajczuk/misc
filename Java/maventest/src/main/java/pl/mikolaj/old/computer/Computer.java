package pl.mikolaj.old.computer;

import pl.mikolaj.old.computer.drive.Drive;
import pl.mikolaj.old.computer.usbdevice.USBDevice;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Monitor monitor;
    private Drive drive;
    private Headphones headphones;

    private List<USBDevice> usbDevices = new ArrayList<>();

    public Computer(Monitor monitor, Drive drive) {
        this.monitor = monitor;
        this.drive = drive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Headphones getHeadphones() {
        return headphones;
    }

    public void setHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    public List<USBDevice> getUsbDevices() {
        return usbDevices;
    }

    public void addUsbDevice(USBDevice usbDevice) {
        boolean isConnected = usbDevice.connect();

        if(isConnected) {
            usbDevices.add(usbDevice);
        }
    }

    public void removeUsbDevice(USBDevice usbDevice) {
        boolean isDisconnected = usbDevice.disconnect();

        if(isDisconnected) {
            usbDevices.remove(usbDevice);
        }
    }
}
