package pl.mikolaj.old.computer.drive;

import pl.mikolaj.old.computer.file.File;

import java.util.ArrayList;
import java.util.List;

public class HDDDrive implements Drive {
    List<File> files = new ArrayList<>();

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void listFiles() {
        files.stream()
                .map(File::getName)
                .forEach(System.out::println);
    }

    @Override
    public File findFile(String name) {
//        return files.stream()
//                .filter(file -> file.getName().equals(name))
//                .findFirst()
//                .orElseThrow();
        return null;
    }
}
