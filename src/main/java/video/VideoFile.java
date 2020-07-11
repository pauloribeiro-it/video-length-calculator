package video;

import java.nio.file.Path;

public class VideoFile {

    private Path path;
    private String duration;

    public VideoFile(Path path, String duration) {
        this.path = path;
        this.duration = duration;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getTotalDurationInSeconds(){
//        System.out.println(this.path.toFile().getAbsolutePath());
        String[] tokens = this.duration.split(",")[0].split(" ");
        String[] durationParts = tokens[tokens.length-1].split("\\.")[0].split(":");
        int hours = Integer.parseInt(durationParts[0]);
        int minutes = Integer.parseInt(durationParts[1]);
        int seconds = Integer.parseInt(durationParts[2]);
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }

    @Override
    public String toString() {
        return String.format("File: %s, duration: %d", this.path.toFile().getAbsolutePath(), getTotalDurationInSeconds());
    }
}
