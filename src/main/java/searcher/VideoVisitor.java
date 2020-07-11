package searcher;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoVisitor extends SimpleFileVisitor<Path> implements FileVisitor{

    private List<Path> filesPath = new ArrayList<>();
    private static final List<String> videoExtensions = Arrays.asList(".mp4",".ts",".avi",".mkv",".rmvb",".flv");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        if(videoExtensions.stream().anyMatch(e -> file.toFile().getAbsolutePath().endsWith(e))){
            filesPath.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public List<Path> getFilesPathOfDirectory(String directoryPath) throws IOException{
        Files.walkFileTree(Paths.get(directoryPath), this);
        return filesPath;
    }
}
