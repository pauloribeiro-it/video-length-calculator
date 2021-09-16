package calculator;

import metadata.MetadataExtractor;
import metadata.MetadataVideoExtractor;
import searcher.FileVisitor;
import searcher.VideoVisitor;
import video.VideoFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class VideoDurationCalculator {

    private FileVisitor fileVisitor = new VideoVisitor();
    private MetadataExtractor metadataExtractor = new MetadataVideoExtractor();

    public Integer getTotalTimeInSeconds(String directory){
        final List<VideoFile> videoFiles = new ArrayList<>();
        try {
            List<Path> files = fileVisitor.getFilesPathOfDirectory(directory);
            files.parallelStream().forEach(file -> {
                VideoFile videoFile = new VideoFile(file, metadataExtractor.getData(file));
                videoFiles.add(videoFile);
//                System.out.println(videoFile);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoFiles.stream().flatMapToInt(v -> IntStream.of(v.getTotalDurationInSeconds())).sum();
    }
}
