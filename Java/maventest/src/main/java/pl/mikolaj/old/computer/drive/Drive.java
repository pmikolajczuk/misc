package pl.mikolaj.old.computer.drive;

import pl.mikolaj.old.computer.file.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String name);
}
