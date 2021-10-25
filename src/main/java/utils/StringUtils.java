package utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public String filterJsonTail(String in){
        if(in != null){
             in = in.replace(".json", "");
        }
        return in;
    }

    public String[] splitString(String in){
        String[] strArray = new String[0];
        if(in != null){
            strArray = in.split("END." , 35);
        }
        return strArray;
    }

    public String filterTailString(String in){
        if(in != null){
            in = in.replace("END.", "");
        }
        return in;
    }
}
