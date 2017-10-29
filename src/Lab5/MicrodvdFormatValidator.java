package Lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicrodvdFormatValidator {

    // pattern sample{123}{123}text
    private static final Pattern PATTERNMICRODVDFORMAT = Pattern.compile("\\{(\\d+)}\\{(\\d+)}(.*)");

    //###### validate method #######
    static int validate(String line) {
        Matcher matcher = PATTERNMICRODVDFORMAT.matcher(line);
        if (matcher.matches()) {

            // if starting frame is bigger than ending frame
            if (Integer.parseInt(matcher.group(1)) > Integer.parseInt(matcher.group(2)))
                return 2;
            else
                // if OK ! return 0
                return 0;
        } else
            // return 1 if char in curly brackets
            return 1;

    }

    //############ shufle method ########################
    static String shuffle(String line, int msec, int fps)throws Exception {

        //matcher for line
        Matcher matcher = PATTERNMICRODVDFORMAT.matcher(line);

        // u have to invoke this function to get access to function group
        matcher.matches();

        int shuffled  = ((msec / 1000) * fps);

        // creating to Frames
        int newStartFrameInt = Integer.parseInt(matcher.group(1)) + shuffled;
        int newEndFrameInt = Integer.parseInt(matcher.group(2)) + shuffled;

        //exception if negative frame
        if(newStartFrameInt< 0)
            throw new NegativeTimeFrameException();

        // creating new Strings for start and end frame
        String newStartFrameString = Integer.toString(newStartFrameInt);
        String newEndFrameString = Integer.toString(newEndFrameInt);

        // return shuffled String
        return "{" + newStartFrameString + "}" + "{" + newEndFrameString + "}" + matcher.group(3);

    }

}
