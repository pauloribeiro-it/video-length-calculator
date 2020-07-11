package searcher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileVisitor {
    List<Path> getFilesPathOfDirectory(String directoryPath) throws IOException;
}
