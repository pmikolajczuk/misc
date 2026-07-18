package pl.mikolaj.old.computer.drive;

import pl.mikolaj.old.computer.file.File;

import java.util.HashMap;
import java.util.Map;

public class SSDDrive implements Drive {
    Map<String, File> files = new HashMap<>();

    @Override
    public void addFile(File file) {
        files.put(file.getName(), file);
    }

    @Override
    public void listFiles() {
        //files.forEach((s, f) -> System.out.println(f.getName()));
        files.values()
                .stream()
                .map(File::getName)
                .forEach(System.out::println);
    }

    @Override
    public File findFile(String name) {
        return files.get(name);
    }
}
