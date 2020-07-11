package main;

import calculator.VideoDurationCalculator;
import formatter.TimeFormatter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Any directory provided.");
            return;
        }
        System.out.println("Directories to scan: "+ Arrays.toString(args));
        for(String directories: args){
            Integer totalSeconds = new VideoDurationCalculator().getTotalTimeInSeconds(directories);
            String timeFormatted = TimeFormatter.formatTimeFromSeconds(totalSeconds);
            System.out.println(directories + ": "+timeFormatted);
        }
    }
}