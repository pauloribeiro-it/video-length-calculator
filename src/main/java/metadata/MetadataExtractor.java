package metadata;

import java.nio.file.Path;

public interface MetadataExtractor {
    String getData(Path path);
}
