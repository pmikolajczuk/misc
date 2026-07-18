package pl.mikolaj.old.computer.usbdevice;

public class Mouse implements USBDevice{
    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() {
        System.out.println("Mouse Connected");
        return true;
    }

    @Override
    public boolean disconnect() {
        System.out.println("Mouse disconnected");
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
