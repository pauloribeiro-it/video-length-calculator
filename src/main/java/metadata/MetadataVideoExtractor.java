package metadata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class MetadataVideoExtractor implements MetadataExtractor{

    public String getData(Path path) {
       String metadata = null;
        String [] commands = {"ffmpeg","-i",path.toFile().getAbsolutePath()};
        try{
            Process process = Runtime.getRuntime().exec(commands);

            try(BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(process.getErrorStream()));){
                metadata = stdError.lines().filter(l -> l.toLowerCase().contains("duration")).collect(Collectors.joining());
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return metadata;
    }
}
