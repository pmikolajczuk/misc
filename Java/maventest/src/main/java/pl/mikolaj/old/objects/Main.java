package pl.mikolaj.old.objects;

public class Main {
    public static void main(String[] args) {
        Garnek garnek = new Garnek(7, 5, "srebrny");

    }

    private void testRemoteControl(){
        RemoteControl remote = new RemoteControl("Black");
        remote.volumeUp();
        remote.volumeUp();
        remote.volumeUp();

        remote.nextChannel();
        remote.nextChannel();

        System.out.println("CurrentVolume: " + remote.getCurrentVolume());
        System.out.println("CurrentChannel: " + remote.getCurrentChannel());
        System.out.println("Color: " + remote.getColor());
    }
}
