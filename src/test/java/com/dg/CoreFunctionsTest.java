package com.dg;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;

public class CoreFunctionsTest {

    @Test
    public void splitString(){
        String pipeDelimited = "Google|Amazon|Microsoft|Facebook";
        String[] arraySplit = pipeDelimited.split("|");
        System.out.println("pipe delimited String: " + pipeDelimited);
        System.out.println("splitted String with delimiter: " + Arrays.toString(arraySplit));

        //\\|, Java needs double slash to escape
        String[] arraySplitPipe = pipeDelimited.split("\\|");
        System.out.println("splitted String after escaping pipe: " + Arrays.toString(arraySplitPipe));
        assertThat(arraySplitPipe, arrayContaining("Google", "Amazon", "Microsoft", "Facebook"));

        arraySplitPipe = pipeDelimited.split("[|]");
        System.out.println("output String after using pipe inside character clas: " + Arrays.toString(arraySplitPipe));

        String colonDelimited = "Android:Windows10:Linux:MacOSX";
        String[] os = colonDelimited.split(":");
        System.out.println("colon delimited String: " + colonDelimited);
        System.out.println("splitted String with delimiter as colon: " + Arrays.toString(os));

        String commaDelimited = "find,grep,chmod,netstat";
        String[] commands = commaDelimited.split(",");
        System.out.println("comma delimited String: " + commaDelimited);
        System.out.println("splitted String with comma as delimter: " + Arrays.toString(commands));





    }
}
