package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesReader {

  public byte[] reader(String path) throws IOException {
    File file = new File(path);
    byte[] bytes = Files.readAllBytes(file.toPath());

    return bytes;
  }

}
