package com.example.alg.triepkg.replacewords;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReplaceWordsTest {

    @Test
    public void replaceWords() {

        final ReplaceWords r = new ReplaceWords();
        final String output = r.replaceWords(Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the battery");

        Assertions.assertThat(output).isEqualTo("the cat was rat by the bat");

    }
}