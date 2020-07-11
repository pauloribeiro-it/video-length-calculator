package formatter;


import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.leftPad;
public class TimeFormatter {
    private static final int SECONDS_IN_HOUR = 60 * 60;

    private TimeFormatter(){
    }

    public static String formatTimeFromSeconds(Integer totalSeconds){
        int hours = 0, minutes = 0, seconds = 0;

        if(totalSeconds >= SECONDS_IN_HOUR){
            hours = totalSeconds / SECONDS_IN_HOUR;
            minutes = (totalSeconds % SECONDS_IN_HOUR) / 60;
            seconds = minutes % 60;
        }else{
            minutes = totalSeconds / 60;
            seconds = totalSeconds % 60;
        }

        return String.format("%s:%s:%s",leftPad(valueOf(hours), 2, "0")
                                       ,leftPad(valueOf(minutes),2, "0")
                                       ,leftPad(valueOf(seconds),2, "0"));
    }

}
