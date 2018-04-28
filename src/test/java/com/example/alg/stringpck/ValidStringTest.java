package com.example.alg.stringpck;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ValidStringTest {
    @Test
    public void isValid() throws Exception {
        final ValidString vS = new ValidString();

        assertEquals("YES",vS.isValid("aabbcc"));
        assertEquals("NO",vS.isValid("baacdd"));
        assertEquals("YES",vS.isValid("aabbccc"));
        assertEquals("YES",vS.isValid("aabbc"));
        assertEquals("NO",vS.isValid("abcccccc"));
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("test").toURI());
        StringBuilder data = new StringBuilder();
        Files.lines(path).forEach(a -> data.append(a));
        assertEquals("YES",vS.isValid(data.toString()));

    }

    @Test
    public void detectCapitalUse() {

        final ValidString v = new ValidString();
        assertFalse(v.detectCapitalUse("FFFf"));
        assertTrue(v.detectCapitalUse("USA"));
        assertTrue(v.detectCapitalUse("leeet"));
        assertFalse(v.detectCapitalUse("FlaG"));
    }

    @Test
    public void detectCapitalUseReg() {


        final ValidString v = new ValidString();
        assertFalse(v.detectCapitalUseReg("FFFf"));
        assertTrue(v.detectCapitalUseReg("USA"));
        assertTrue(v.detectCapitalUseReg("leeet"));
        assertFalse(v.detectCapitalUseReg("FlaG"));
    }
}